/**
 * 
 */
package topic;

import java.util.Set;

/**
 * @author quangns
 *
 */
public interface TopicKafka {
	boolean checkNameTopicExists(final String nameTopic);
	Set<String> showlistTopic();
}
