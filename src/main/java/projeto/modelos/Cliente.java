package projeto.modelos;

import java.time.LocalDate;

import projeto.UsuarioPadrao;

//Classe para representar o cliente
public class Cliente extends UsuarioPadrao {

	//Construto para facilitar a criação da classe passando todos os atributos
	public Cliente(String nome, String tipo, String email, LocalDate idade, String sexo, String senha) {
		super(nome, tipo, email, idade, sexo, senha);
	}
}
