package projeto.exceptions;

public class ReuniaoJaCadastradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReuniaoJaCadastradaException(String msg) {
		super(msg);
	}
	public ReuniaoJaCadastradaException() {
		super("Essa reuniao ja foi Cadastrada.");
	}
}
