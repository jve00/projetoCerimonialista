package projeto.modelos;

import projeto.UsuarioPadrao;

public class PessoaJuridica extends UsuarioPadrao {

	// Atributos unicos de pessoa juridica
	private long CNPJ;

	// construtor feito para iniciar todos os atributos
	public PessoaJuridica(String nome, String tipo, String email, String senha, long CNPJ) {
		super(nome, tipo, email, senha);
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
