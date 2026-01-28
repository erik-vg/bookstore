package code.erik.bookstore.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -155469506558452813L;

	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}

}
