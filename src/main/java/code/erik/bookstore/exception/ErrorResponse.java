package code.erik.bookstore.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int status;
	
	private String mensaje;

}
