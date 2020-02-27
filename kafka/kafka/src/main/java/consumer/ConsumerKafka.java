/**
 * 
 */
package consumer;

import java.io.Closeable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import api.APIKafka;
import consumer.ConsumerKafka;
import entity.MessageObject;
import exception.NonAttributeException;
import exception.TopicDontExistsExcepttion;
import properties.PropertyFile;
import topic.TopicKafka;
import topic.impl.TopicKafkaImpl;

/**
 * @author quangns
 *
 */
public class ConsumerKafka extends APIKafka {

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
	public Object run(MessageObject mesObj) throws Exception {
		final Consumer<Long, String> consumer = (Consumer<Long, String>) createProperty();
		ArrayList<String> message = new ArrayList<String>();
		try {
			TopicKafka varTopic = new TopicKafkaImpl();
			if(varTopic.checkNameTopicExists(mesObj.getTOPIC_NAME())) {
				consumer.subscribe(Collections.singletonList(mesObj.getTOPIC_NAME()));
			    ConsumerRecords<Long, String> records = consumer.poll(Duration.ofSeconds(30));
			    for (ConsumerRecord<Long, String> record : records) {
//			    	System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
			    	message.add(record.value());
			    }
			} else {
				throw new TopicDontExistsExcepttion();
			}
		} catch (NullPointerException e) {
			throw new NonAttributeException();
		} catch (TopicDontExistsExcepttion e) {
			throw new TopicDontExistsExcepttion();
		} catch (Exception e) {
			throw e;
		}
		return message;
	}

}
