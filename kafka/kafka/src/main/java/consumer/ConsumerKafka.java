/**
 * 
 */
package consumer;

import consumer.ConsumerKafka;
import entity.MessageObject;

/**
 * @author quangns
 *
 */
public interface ConsumerKafka {
	Object run(MessageObject mesObj) throws Exception;
}
