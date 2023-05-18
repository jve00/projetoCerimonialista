package projeto.exceptions;

public class ClienteJaExisteException extends Exception{

	public ClienteJaExisteException() {
		super("Cliente ja Cadastrado.");
	}
	public ClienteJaExisteException(String msg) {
		super(msg);
	}

}
