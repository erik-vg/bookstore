package code.erik.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> managmentResourceNotFoundException(ResourceNotFoundException ex) {
		ErrorResponse resp = new ErrorResponse();
		resp.setStatus(HttpStatus.NOT_FOUND.value());
		resp.setMensaje(ex.getMessage());

		return new ResponseEntity<ErrorResponse>(resp, HttpStatus.NOT_FOUND);
	}

}
