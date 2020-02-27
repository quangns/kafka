/**
 * 
 */
package api;

import java.io.Closeable;

import entity.MessageObject;

/**
 * @author quangns
 *
 */
public abstract class APIKafka {
	protected abstract Closeable createProperty();
	public abstract Object run(MessageObject mesObj) throws Exception;
}
