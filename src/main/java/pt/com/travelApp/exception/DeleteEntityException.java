package pt.com.travelApp.exception;

public class DeleteEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeleteEntityException(String msg) {
        super(msg);
    }

    public DeleteEntityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
