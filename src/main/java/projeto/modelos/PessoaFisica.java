package projeto.modelos;

import projeto.UsuarioPadrao;

//Classe para representar pessoa fisica
public class PessoaFisica extends UsuarioPadrao {

	//Atributos unicos de PessoaFisica
	private int CPF;

	//Construto para facilitar a cria��o passando todos os atributos 
	public PessoaFisica(String nome, String tipo, String email, String senha, int CPF) {
		super(nome, tipo, email, senha);
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
