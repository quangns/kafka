package exception;

public class NonAttributeException extends NullPointerException {
	
	private static final long serialVersionUID = -7528930615580668516L;
	private static String msg;

	public NonAttributeException() {
		super(msg);
	}
	
	public String getMessage() {
		return "error: non topic name or message to push";
	}
}
