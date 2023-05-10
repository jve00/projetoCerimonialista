package projeto.exceptions;

public class ValidarTelefoneException extends Exception {

	public ValidarTelefoneException(String msg) {
		super(msg);

	}

	public ValidarTelefoneException() {
		super("digite um telefone valido");

	}
}
