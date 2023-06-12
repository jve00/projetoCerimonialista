package projeto.exceptions;

public class HoraInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HoraInvalidaException(String msg) {
		super(msg);
	}

	public HoraInvalidaException() {
		super("Hora Invalida, passe uma hora Valida!");
	}

}
