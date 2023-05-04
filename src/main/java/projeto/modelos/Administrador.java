package projeto.modelos;

import java.sql.Date;

public class Administrador {
	private String login;
	private String senha;
	private Date dataDeNascimento;
	
	public Administrador(String login, String senha, Date dataDeNascimento) {
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
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
