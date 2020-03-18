/**
 * 
 */
package producer.impl;

import java.io.Closeable;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import entity.MessageObject;
import exception.NonAttributeException;
import exception.TopicDontExistsExcepttion;
import producer.ProduceKafka;
import propertiesImpl.PropertiesKafka;
import topic.TopicKafka;
import topic.impl.TopicKafkaImpl;

/**
 * @author quangns
 *
 */
public class ProduceKafkaImpl extends PropertiesKafka implements ProduceKafka {
	@Override
	protected Closeable createProperty() {
		Properties props = declareProperty();
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return new KafkaProducer<Long, String>(props);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object runProduceKafka(MessageObject mesObj) throws Exception{
		final Producer<Long, String> producer = (Producer<Long, String>) createProperty();
		Object objectToPush = null;
		try {
			TopicKafka varTopic = new TopicKafkaImpl();
			if(varTopic.checkNameTopicExists(mesObj.getTOPIC_NAME())) {
				long time = System.currentTimeMillis();
				final ProducerRecord<Long, String> record;
				record = new ProducerRecord<Long, String>(mesObj.getTOPIC_NAME(), time, mesObj.getMessage().toString());
				RecordMetadata metadata = producer.send(record).get();
				long elapsedTime = System.currentTimeMillis() - time;
				System.out.printf("sent record(key=%s value=%s) " +
	                        "meta(partition=%d, offset=%d) time=%d\n",
	                        record.key(), record.value(), metadata.partition(),
	                        metadata.offset(), elapsedTime);
				objectToPush = mesObj.getMessage();
			} else {
				throw new TopicDontExistsExcepttion();
			}
		} catch (NullPointerException e) {
			throw new NonAttributeException();
		} catch (TopicDontExistsExcepttion e) {
			throw new TopicDontExistsExcepttion();
		} catch (Exception e) {
			throw e;
		} finally {
			producer.flush();
			producer.close();
		}
		return objectToPush;
	}
}
