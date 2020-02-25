/**
 * 
 */
package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author quangns
 *
 */

public class PropertyFile {
	private static Properties propertyKafka = new Properties();
	
	static {
		try {
			String filePath = "\\src\\main\\resources\\KafkaProperties.properties";
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir") + filePath);
			propertyKafka.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object getProperty(String str) {
		return propertyKafka.get(str);
	}
}
