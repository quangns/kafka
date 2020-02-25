/**
 * 
 */
package consumer.impl;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import consumer.ConsumerKafka;
import entity.MessageObject;
import properties.PropertyFile;

/**
 * @author quangns
 *
 */
public class ConsumerKafkaImpl extends ConsumerKafka {

	@Override
	protected Closeable createProperty() {
		PropertyFile varPropertyFile = new PropertyFile();
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, varPropertyFile.getProperty("KAFKA_BROKERS"));
		props.put(ConsumerConfig.GROUP_ID_CONFIG, varPropertyFile.getProperty("CLIENT_ID"));
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return new KafkaConsumer<Long, String>(props);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(MessageObject mesObj) {
		final Consumer<Long, String> consumer = (Consumer<Long, String>) createProperty();
		consumer.subscribe(Collections.singletonList(mesObj.getTOPIC_NAME()));
		while (true) {
	         ConsumerRecords<Long, String> records = consumer.poll(Duration.ofMillis(100));
	         for (ConsumerRecord<Long, String> record : records)
	             System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
	     }
	}

	@Override
	public void getMessageOffset(TopicPartition conOffset) {
		final Consumer<Long, String> consumer = (Consumer<Long, String>) createProperty();
		consumer.subscribe(Collections.singletonList(conOffset.topic()));
		while (true) {
		}
	}

}
