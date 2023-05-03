package projeto.modelos;

import java.time.LocalDate;

import projeto.UsuarioPadrao;

public class PessoaJuridica extends UsuarioPadrao {

	//Atributos unicos de pessoa juridica
	private long CNPJ;

	//	construtor feito para iniciar todos os atributos
	public PessoaJuridica(String nome, String tipo, String email, LocalDate idade, String sexo, String senha,
			long CNPJ) {
		super(nome, tipo, email, idade, sexo, senha);
		this.CNPJ = CNPJ;
	}

	//gets e sets unicos
	public long getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(long cNPJ) {
		CNPJ = cNPJ;
	}
}
