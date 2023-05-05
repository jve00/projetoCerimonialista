package projeto.modelos;

import java.time.LocalDate;

import javax.swing.JFormattedTextField;

public class Administrador {
	private String login;
	private String senha;
	private LocalDate dataDeNascimento;
	
	public Administrador(String login, String senha, LocalDate dataDeNascimento) {
		super();
		this.login = login;
		this.senha = senha;
		this.dataDeNascimento = dataDeNascimento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
