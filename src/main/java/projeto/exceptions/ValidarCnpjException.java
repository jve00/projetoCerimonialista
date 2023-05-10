package projeto.exceptions;

public class ValidarCnpjException extends Exception {

	public ValidarCnpjException() {
		super("CNPJ invalido");
	}

	public ValidarCnpjException(String msg) {
		super(msg);
	}
}
