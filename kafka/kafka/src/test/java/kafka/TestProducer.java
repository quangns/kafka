/**
 * 
 */
package kafka;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import api.APIKafka;
import entity.MessageObject;
import exception.NonAttributeException;
import exception.TopicDontExistsExcepttion;
import producer.ProduceKafka;

/**
 * @author quangns
 *
 */
class TestProducer {
	
	/**
	 * don't have topic name
	 */
	@Test
	public void testNoTopicName() {
		APIKafka produce = new ProduceKafka();
		MessageObject mesObj = new MessageObject();
		mesObj.setMessage("test ");
		Throwable exception = assertThrows(NonAttributeException.class, () -> produce.run(mesObj));
		assertEquals("error: non topic name or message to push", exception.getMessage());
	}
	
	/**
	 * don't message to push into kafka
	 */
	@Test
	public void testNoMessage() {
		APIKafka produce = new ProduceKafka();
		MessageObject mesObj = new MessageObject();
		mesObj.setTOPIC_NAME("test");
		Throwable exception = assertThrows(NonAttributeException.class, () -> produce.run(mesObj));
		assertEquals("error: non topic name or message to push", exception.getMessage());
	}
	
	/**
	 * check topic name don't exist
	 */
	@Test
	public void testWrongTopicName() {
		APIKafka produce = new ProduceKafka();
		MessageObject mesObj = new MessageObject();
		mesObj.setTOPIC_NAME("abcxyz");
		Throwable exception = assertThrows(TopicDontExistsExcepttion.class, () -> produce.run(mesObj));
		assertEquals("topic don't exists", exception.getMessage());
	}
	
	/**
	 * send message success
	 * @throws Exception 
	 */
	@Test
	public void testSendMessageSuccess() throws Exception {
		final String message = "new Message to test";
		
		APIKafka produce = new ProduceKafka();
		MessageObject mesObj = new MessageObject();
		mesObj.setTOPIC_NAME("test");
		mesObj.setMessage(message);
		String strOutput = (String) produce.run(mesObj);
		
		assertEquals(message, strOutput);
	}
}
