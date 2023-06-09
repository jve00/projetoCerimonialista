package projeto.exceptions;

public class LotalTimeException extends Exception {

	public LotalTimeException(String message) {
		super(message);
	}
	public LotalTimeException() {
		super("Hora invalida, parse uma hora valida");
	}
	

}
