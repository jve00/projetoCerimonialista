package projeto.modelos;

import java.time.LocalDate;

import projeto.UsuarioPadrao;

//Classe para representar pessoa fisica
public class PessoaFisica extends UsuarioPadrao {

	//Atributos unicos de PessoaFisica
	private int CPF;

	//Construto para facilitar a criação passando todos os atributos 
	public PessoaFisica(String nome, String tipo, String email, LocalDate idade, String sexo, String senha, int CPF) {
		super(nome, tipo, email, idade, sexo, senha);
		this.CPF = CPF;
	}

	//gets e sets dos atributos unicos
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int CPF) {
		this.CPF = CPF;
	}

}
