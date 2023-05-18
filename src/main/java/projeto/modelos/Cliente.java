package projeto.modelos;

import projeto.UsuarioPadrao;

//Classe para representar o cliente
public class Cliente extends UsuarioPadrao {

	//Construto para facilitar a cria��o da classe passando todos os atributos
	public Cliente(String nome,String telefone,  String email, String tipo) {
		super(nome, telefone, email, tipo);
	}
}
