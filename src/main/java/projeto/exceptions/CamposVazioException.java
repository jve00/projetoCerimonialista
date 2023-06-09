package projeto.exceptions;

public class CamposVazioException extends Exception{

	
	
	public CamposVazioException(String msg) {
		super(msg);
	}

	public CamposVazioException() {
		super("O campos deve estar preenchido");
	}
}
