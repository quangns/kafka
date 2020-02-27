package exception;

public class TopicDontExistsExcepttion extends Exception {

	private static final long serialVersionUID = -8785881114518004638L;
	private static String msg;

	public TopicDontExistsExcepttion() {
		super(msg);
	}
	
	public String getMessage() {
		return "topic don't exists";
	}
}
