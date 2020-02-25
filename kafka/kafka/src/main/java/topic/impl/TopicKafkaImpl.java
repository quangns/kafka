/**
 * 
 */
package topic.impl;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.errors.TimeoutException;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import properties.PropertyFile;
import topic.TopicKafka;
import validates.ValidateKafka;

/**
 * @author quangns
 *
 */
public class TopicKafkaImpl implements TopicKafka {

	private AdminClient createProperty() {
		PropertyFile varPropertyFile = new PropertyFile();
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, varPropertyFile.getProperty("KAFKA_BROKERS"));
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, varPropertyFile.getProperty("GROUP_ID_CONFIG"));
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		AdminClient adminClient = AdminClient.create(props);
        return adminClient;
	}

	@Override
	public boolean checkNameTopicExists(String nameTopic) {
		ValidateKafka varVal = new ValidateKafka();
		boolean checkNameExists = false;
		if(! varVal.checkStringNull(nameTopic)) {
			Set<String> listTopic = showlistTopic();
			checkNameExists = listTopic.contains(nameTopic);
		}
		return checkNameExists;
	}

	@Override
	public Set<String> showlistTopic() {
		final AdminClient adminClient = createProperty();
		Set<String> topics = null;
		try {
			topics = adminClient.listTopics().names().get();
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		adminClient.close();
		return topics;
	}

}
