/**
 * 
 */
package consumer;

import org.apache.kafka.common.TopicPartition;

import api.APIKafka;

/**
 * @author quangns
 *
 */
public abstract class ConsumerKafka extends APIKafka {
	public abstract void getMessageOffset(TopicPartition conOffObj);
}
