/**
 * 
 */
package kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import api.APIKafka;
import consumer.ConsumerKafka;
import entity.MessageObject;
import exception.NonAttributeException;
import exception.TopicDontExistsExcepttion;
import producer.ProduceKafka;

/**
 * @author quangns
 *
 */
public class testConsumer {

	/**
	 * don't have topic name
	 */
	@Test
	public void testNoTopicName() {
		APIKafka consumer = new ConsumerKafka();
		MessageObject mesObj = new MessageObject();
		mesObj.setMessage("test ");
		Throwable exception = assertThrows(NonAttributeException.class, () -> consumer.run(mesObj));
		assertEquals("error: non topic name or message to push", exception.getMessage());
	}
	
	/**
	 * check topic name don't exist
	 */
	@Test
	public void testWrongTopicName() {
		APIKafka consumer = new ConsumerKafka();
		MessageObject mesObj = new MessageObject();
		mesObj.setTOPIC_NAME("abcxyz");
		Throwable exception = assertThrows(TopicDontExistsExcepttion.class, () -> consumer.run(mesObj));
		assertEquals("topic don't exists", exception.getMessage());
	}
	
	/**
	 * get message success
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetMessageSuccess() throws Exception {
		final String message1 = "1 message";
		final String message2 = "2 message";
		
		APIKafka produce = new ProduceKafka();
		MessageObject mesObjPro = new MessageObject();
		mesObjPro.setTOPIC_NAME("test");
		mesObjPro.setMessage(message1);
		produce.run(mesObjPro);
		mesObjPro.setMessage(message2);
		produce.run(mesObjPro);
	
		APIKafka consumer = new ConsumerKafka();
		MessageObject mesObj = new MessageObject();
		mesObj.setTOPIC_NAME("test");
		ArrayList<String> getMessages = (ArrayList<String>) consumer.run(mesObj);
		final int lenArr = getMessages.size();
		assertEquals(message1, getMessages.get(lenArr-2));
		assertEquals(message2, getMessages.get(lenArr-1));
	}
}
