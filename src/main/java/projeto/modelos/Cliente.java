package projeto.modelos;

import java.util.ArrayList;

import projeto.UsuarioPadrao;

//Classe para representar o cliente
public class Cliente extends UsuarioPadrao {

	private boolean situacaoDaReuniao = true;

	// Construto para facilitar a criacao da classe passando todos os atributos
	public Cliente(String nome, String telefone, String email, String tipo) {
		super(nome, telefone, email, tipo);
	}

	public boolean getSituacaoDaReuniao() {
		return situacaoDaReuniao;
	}

	public void setSituacaoDaReuniao(boolean situacaoDaReuniao) {
		this.situacaoDaReuniao = situacaoDaReuniao;
	}

}
