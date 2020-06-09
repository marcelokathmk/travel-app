package pt.com.travelApp.exception;

public class ParseJSONException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParseJSONException(String msg) {
        super(msg);
    }

    public ParseJSONException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
