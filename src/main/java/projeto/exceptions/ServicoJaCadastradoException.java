package projeto.exceptions;

public class ServicoJaCadastradoException extends Exception {

	public ServicoJaCadastradoException(String msg) {
		super(msg);
	}

	public ServicoJaCadastradoException() {
		super("Servico ja cadastrado.");
	}
}
