package projeto.modelos;

import java.time.LocalDate;

public class PessoaFisica extends UsuarioPadrao {


	private int CPF;
	public PessoaFisica(String nome, String tipo, String email, LocalDate idade, String sexo, String senha, int CPF) {
		super(nome, tipo, email, idade, sexo, senha);
		this.CPF = CPF;
	}
	public int getCPF() {
		return CPF;
	}

	public void setCPF(int CPF) {
		this.CPF = CPF;
	}

}
