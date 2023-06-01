package projeto.modelos;

public class PessoaJuridica extends Cliente{

	// Atributos unicos de pessoa juridica
	private long CNPJ;

	// construtor feito para iniciar todos os atributos
	public PessoaJuridica(String nome,String telefone,  String email, String tipo, long CNPJ) {
		super(nome, telefone, email, tipo);
		this.CNPJ = CNPJ;
	}

	// gets e sets unicos
	public long getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(long cNPJ) {
		CNPJ = cNPJ;
	}
}
