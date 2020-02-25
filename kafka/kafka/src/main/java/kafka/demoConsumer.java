/**
 * 
 */
package kafka;


import api.APIKafka;
import consumer.impl.ConsumerKafkaImpl;
import entity.MessageObject;
import producer.ProduceKafka;

/**
 * @author quangns
 *
 */
public class demoConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		APIKafka produce = new ProduceKafka();
		try {
			MessageObject mesObj = new MessageObject();
			mesObj.setTOPIC_NAME("test");
			for (int i = 3; i < 4; i++) {
				mesObj.setMessage("test" + i);
				produce.run(mesObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		APIKafka conKafka = new ConsumerKafkaImpl();
		try {
			MessageObject mesObj1 = new MessageObject();
			mesObj1.setTOPIC_NAME("test");
			conKafka.run(mesObj1);
//			TopicKafka topicKafka = new TopicKafkaImpl();
//			System.out.println(topicKafka.checkNameTopicExists("test"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
