package projeto.exceptions;

public class ServicoInvalidoException extends Exception {

	public ServicoInvalidoException(String msg) {
		super(msg);
	}

	public ServicoInvalidoException() {
		super("O fornecedor deve ter ao menos um servico");
	}

}
