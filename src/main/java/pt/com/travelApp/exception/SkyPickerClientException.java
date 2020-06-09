package pt.com.travelApp.exception;

public class SkyPickerClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SkyPickerClientException(String msg) {
        super(msg);
    }

    public SkyPickerClientException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
