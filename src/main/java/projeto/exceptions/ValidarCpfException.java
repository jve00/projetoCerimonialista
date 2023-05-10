package projeto.exceptions;

public class ValidarCpfException extends Exception{

	public ValidarCpfException() {
		super("CPF invalido");
	}
	public ValidarCpfException(String msg) {
		super(msg);
	}
		

}
