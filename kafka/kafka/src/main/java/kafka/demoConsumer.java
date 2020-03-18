/**
 * 
 */
package kafka;

import consumer.ConsumerKafka;
import consumer.impl.ConsumerKafkaImpl;
import entity.MessageObject;
import producer.ProduceKafka;
import producer.impl.ProduceKafkaImpl;

/**
 * @author quangns
 *
 */
public class demoConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ProduceKafka produce = new ProduceKafkaImpl();
		try {
			MessageObject mesObj = new MessageObject();
			mesObj.setTOPIC_NAME("test");
			for (int i = 1; i < 4; i++) {
				mesObj.setMessage("test" + i);
//				mesObj.setMessage("test");
				produce.runProduceKafka(mesObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConsumerKafka conKafka = new ConsumerKafkaImpl();
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
