package fr.sparks.plage.exception;

public class ClientInexistantException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ClientInexistantException(String message) {
		super(message);
	}
}
