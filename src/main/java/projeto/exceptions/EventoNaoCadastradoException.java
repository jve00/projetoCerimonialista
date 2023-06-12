package projeto.exceptions;

public class EventoNaoCadastradoException extends Exception{

	
	
	public EventoNaoCadastradoException(String msg) {
		super(msg);
	}
	public EventoNaoCadastradoException() {
		super("Evento nao cadastrado");
	}
}
