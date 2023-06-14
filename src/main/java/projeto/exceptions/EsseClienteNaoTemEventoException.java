package projeto.exceptions;

public class EsseClienteNaoTemEventoException extends Exception{
	
	public EsseClienteNaoTemEventoException(String msg) {
		super(msg);
	}
	public EsseClienteNaoTemEventoException() {
		super("Nao existe um evento cadastradom com o email desse cliente");
	}
}
