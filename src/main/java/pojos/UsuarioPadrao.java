package pojos;

import java.time.LocalDate;

public abstract class UsuarioPadrao {

	private String nome;
	private TipoDeConta tipo;
	private String email;
	private LocalDate dataDeNascimento;
	private Sexo sexo;
	private String id;
	
	public UsuarioPadrao(String nome, String tipo, String email, LocalDate idade, String sexo) {
	
	this.nome = nome;
	this.tipo = TipoDeConta.valueOf(tipo);
	this.email = email;
	dataDeNascimento = idade;
	this.sexo = Sexo.valueOf(sexo);
	
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoDeConta getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeConta tipo) {
		this.tipo = tipo;
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

	
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
