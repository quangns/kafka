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
	public boolean checkNameTopicExists(final String nameTopic);
	public Set<String> showlistTopic();
}
