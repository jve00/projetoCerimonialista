package projeto.exceptions;

public class ValidarNomeException extends Exception{

	public ValidarNomeException(String msg) {
		super(msg);
	}
	public ValidarNomeException() {
		super("Nome invalido, o nome deve conter mais de 10 caracteres");
		}
}
