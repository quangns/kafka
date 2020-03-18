/**
 * 
 */
package propertiesImpl;

import java.io.Closeable;
import java.util.Properties;
import org.apache.kafka.clients.producer.ProducerConfig;
import properties.PropertyFile;

/**
 * @author quangns
 *
 */
public abstract class PropertiesKafka {
	
	/**
	 * declare property to use in kafka
	 * @return
	 */
	protected Properties declareProperty() {
		PropertyFile varPropertyFile = new PropertyFile();
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, varPropertyFile.getProperty("KAFKA_BROKERS"));
		props.put(ProducerConfig.CLIENT_ID_CONFIG, varPropertyFile.getProperty("CLIENT_ID"));
		return props;
	};
	
	/**
	 * add properties of a produce or consumer
	 * @return
	 */
	protected abstract Closeable createProperty();
}
