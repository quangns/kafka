package producer;

import entity.MessageObject;

public interface ProduceKafka {
	Object runProduceKafka(MessageObject mesObj) throws Exception;
	
}
