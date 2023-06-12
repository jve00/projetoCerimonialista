package projeto.exceptions;

public class OrcamentoJaCadastradoException extends Exception{

	
	public OrcamentoJaCadastradoException(String msg) {
		super(msg);
	}
	public OrcamentoJaCadastradoException(){
		super("Orcamento Ja Cadastrado");
	}
}
