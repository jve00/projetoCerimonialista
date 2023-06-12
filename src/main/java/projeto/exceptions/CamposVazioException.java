package projeto.exceptions;

public class CamposVazioException extends Exception{

	
	
	public CamposVazioException(String msg) {
		super(msg);
	}

	public CamposVazioException() {
		super("Os campos deve estar preenchido");
	}
}
