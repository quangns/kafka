package entity;

public class KafkaElements {
	private static String KAFKA_BROKERS;
	
	private static int MESSAGE_COUNT;
	
	private static String CLIENT_ID;
	
	private static String TOPIC_NAME;
	
	private static String GROUP_ID_CONFIG;
	
	private static int MAX_NO_MESSAGE_FOUND_COUNT;
	
	private static String OFFSET_RESET_LATEST;
	
	private static String OFFSET_RESET_EARLIER;
	
	private static int MAX_POLL_RECORDS;

	public static String getKAFKA_BROKERS() {
		return KAFKA_BROKERS;
	}

	public static void setKAFKA_BROKERS(String kAFKA_BROKERS) {
		KAFKA_BROKERS = kAFKA_BROKERS;
	}

	public static int getMESSAGE_COUNT() {
		return MESSAGE_COUNT;
	}

	public static void setMESSAGE_COUNT(int mESSAGE_COUNT) {
		MESSAGE_COUNT = mESSAGE_COUNT;
	}

	public static String getCLIENT_ID() {
		return CLIENT_ID;
	}

	public static void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}

	public static String getTOPIC_NAME() {
		return TOPIC_NAME;
	}

	public static void setTOPIC_NAME(String tOPIC_NAME) {
		TOPIC_NAME = tOPIC_NAME;
	}

	public static String getGROUP_ID_CONFIG() {
		return GROUP_ID_CONFIG;
	}

	public static void setGROUP_ID_CONFIG(String gROUP_ID_CONFIG) {
		GROUP_ID_CONFIG = gROUP_ID_CONFIG;
	}

	public static int getMAX_NO_MESSAGE_FOUND_COUNT() {
		return MAX_NO_MESSAGE_FOUND_COUNT;
	}

	public static void setMAX_NO_MESSAGE_FOUND_COUNT(int mAX_NO_MESSAGE_FOUND_COUNT) {
		MAX_NO_MESSAGE_FOUND_COUNT = mAX_NO_MESSAGE_FOUND_COUNT;
	}

	public static String getOFFSET_RESET_LATEST() {
		return OFFSET_RESET_LATEST;
	}

	public static void setOFFSET_RESET_LATEST(String oFFSET_RESET_LATEST) {
		OFFSET_RESET_LATEST = oFFSET_RESET_LATEST;
	}

	public static String getOFFSET_RESET_EARLIER() {
		return OFFSET_RESET_EARLIER;
	}

	public static void setOFFSET_RESET_EARLIER(String oFFSET_RESET_EARLIER) {
		OFFSET_RESET_EARLIER = oFFSET_RESET_EARLIER;
	}

	public static int getMAX_POLL_RECORDS() {
		return MAX_POLL_RECORDS;
	}

	public static void setMAX_POLL_RECORDS(int mAX_POLL_RECORDS) {
		MAX_POLL_RECORDS = mAX_POLL_RECORDS;
	}
}
