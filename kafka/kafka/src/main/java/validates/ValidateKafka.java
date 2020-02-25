/**
 * 
 */
package validates;

/**
 * @author quangns
 *
 */
public class ValidateKafka {
	public boolean checkStringNull(final String str) {
		return (str.isBlank() || str.trim().isEmpty());
	}
}
