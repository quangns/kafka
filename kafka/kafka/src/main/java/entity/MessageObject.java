/**
 * 
 */
package entity;

/**
 * @author quangns
 *
 */
public class MessageObject {
	private String TOPIC_NAME;
	
	private Object message;

	public String getTOPIC_NAME() {
		return TOPIC_NAME;
	}

	public void setTOPIC_NAME(String tOPIC_NAME) {
		TOPIC_NAME = tOPIC_NAME;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
	
}
