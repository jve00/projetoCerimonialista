package projeto;

import java.time.LocalDate;

import projeto.modelos.enuns.TipoDeConta;

//Classe criada com o intuito de diminuir o codigo duplicado, pois os clientes, pessoas fisicas 
// e as pessoas juridicas iram ter os mesmo atributos.
public abstract class UsuarioPadrao {

	private String nome;
	private String email;
	private LocalDate dataDeNascimento;
	private String tipo;
	private String id;
	

	public UsuarioPadrao(String nome, String telefone, String email, String tipo) {
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;

	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}


	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


}
