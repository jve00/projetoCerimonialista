package projeto.exceptions;

public class UsuarioNaoExisteException extends Exception{
	
	
	public UsuarioNaoExisteException(){
		super("Este usuario nao existe");
		
	}
	
	public UsuarioNaoExisteException(String msg) {
		super(msg);
		
	}

}
