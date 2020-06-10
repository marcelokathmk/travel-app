package pt.com.travelApp.exception;

import java.time.format.DateTimeParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<StandardError> missingRequiredParameter(MissingServletRequestParameterException e, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<StandardError> datePatternNotCorrect(DateTimeParseException e, HttpServletRequest request){
    	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "The date should be in the format dd/MM/yyyy. Example: 08/09/2020.", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(ParseJSONException.class)
    public ResponseEntity<StandardError> jsonProcessingException(ParseJSONException e, HttpServletRequest request){
    	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Exception when tried parse Object to JSON.", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(SkyPickerClientException.class)
    public ResponseEntity<StandardError> skyPickerClientException(SkyPickerClientException e, HttpServletRequest request){
    	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Exception when called the SkyPicker API.", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(PersistenceEntityException.class)
    public ResponseEntity<StandardError> persistenceEntityException(PersistenceEntityException e, HttpServletRequest request){
    	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Exception when tried persist new record.", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }
    
    @ExceptionHandler(DeleteEntityException.class)
    public ResponseEntity<StandardError> deleteEntityException(DeleteEntityException e, HttpServletRequest request){
    	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Exception when tried delete records.", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }
    
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<StandardError> illegalStateException(IllegalStateException e, HttpServletRequest request){
    	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.REQUEST_TIMEOUT.value(), "Timeout when tried to call Skypicker API. Try again later or contact the administrator system.", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(error);
    }
}
