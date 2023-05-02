package projeto.modelos;

import java.time.LocalDate;

import projeto.UsuarioPadrao;

public class Cliente extends UsuarioPadrao {

	public Cliente(String nome, String tipo, String email, LocalDate idade, String sexo, String senha) {
		super(nome, tipo, email, idade, sexo, senha);
	}
}
