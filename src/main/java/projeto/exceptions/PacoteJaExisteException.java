package projeto.exceptions;

public class PacoteJaExisteException extends Exception{

	public PacoteJaExisteException(String msg) {
		super(msg);
	}
	
	public PacoteJaExisteException() {
		super("Pacote ja Cadastrado");
	}
}
