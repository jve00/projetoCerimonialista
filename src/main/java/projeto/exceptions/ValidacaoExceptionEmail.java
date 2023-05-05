package projeto.exceptions;

public class ValidacaoExceptionEmail extends Exception {

	public ValidacaoExceptionEmail() {
		super("O Email esta vazio");
	}

	public ValidacaoExceptionEmail(String msg) {
		super(msg);
	}

}
