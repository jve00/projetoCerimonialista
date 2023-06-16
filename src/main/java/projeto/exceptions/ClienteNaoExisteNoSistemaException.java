package projeto.exceptions;

public class ClienteNaoExisteNoSistemaException extends Exception {

	public ClienteNaoExisteNoSistemaException(String msg) {
		super(msg);

	}
	public ClienteNaoExisteNoSistemaException() {
		super("Esse cliente nao existe no nosso sistema");
	}
}
