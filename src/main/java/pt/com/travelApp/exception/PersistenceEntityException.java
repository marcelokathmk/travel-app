package pt.com.travelApp.exception;

public class PersistenceEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersistenceEntityException(String msg) {
        super(msg);
    }

    public PersistenceEntityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
