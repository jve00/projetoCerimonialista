package projeto.exceptions;

public class FornecedorExixtenteException extends Exception {

	public FornecedorExixtenteException(String msg) {
		super(msg);
	}

	public FornecedorExixtenteException() {
		super("Fornecedor ja Cadastrado.");
	}

}
