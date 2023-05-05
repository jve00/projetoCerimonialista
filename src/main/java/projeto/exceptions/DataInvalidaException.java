package projeto.exceptions;

public class DataInvalidaException extends Exception{
  
  public DataInvalidaException(String msg) {
    super(msg);
  }

  public DataInvalidaException() {
    super("Data inválida");
  }
}
