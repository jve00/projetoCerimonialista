package projeto.modelos;

import java.time.LocalDate;

public class PessoaJuridica extends UsuarioPadrao {

	private long CNPJ;

	public PessoaJuridica(String nome, String tipo, String email, LocalDate idade, String sexo, String senha,
			long CNPJ) {
		super(nome, tipo, email, idade, sexo, senha);
		this.CNPJ = CNPJ;
	}
	public long getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(long cNPJ) {
		CNPJ = cNPJ;
	}
}
