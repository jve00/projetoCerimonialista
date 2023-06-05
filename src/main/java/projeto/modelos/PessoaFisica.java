package projeto.modelos;

//Classe para representar pessoa fisica
public class PessoaFisica extends Cliente {

	// Atributos unicos de PessoaFisica
	private long CPF;

	// Construto para facilitar a cria��o passando todos os atributos
	public PessoaFisica(String nome, String telefone, String tipo, String email, long CPF) {
		super(nome, telefone, tipo, email);
		this.CPF = CPF;
	}
	private String tipo() {
		return "PESSOAFISICA";
	}
	// gets e sets dos atributos unicos
	public long getCPF() {
		return CPF;
	}

	public void setCPF(long CPF) {
		this.CPF = CPF;
	}

}
