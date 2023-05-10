package projeto.exceptions;

public class ValidarCheckBoxException extends Exception {

	public ValidarCheckBoxException() {
		super("Selecione uma opcao");
	}

	public ValidarCheckBoxException(String msg) {
		super(msg);
	}

}
