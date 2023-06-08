package projeto.modelos;

import java.util.ArrayList;

public class Pacote {
	
	private String nome;
	private ArrayList<Fornecedor> fornecedores;
	private ArrayList<String> servicos;
	private float preco;
	private String descricao;
	
	public Pacote(String nome, ArrayList<Fornecedor> fornecedores, 
			ArrayList<String> servicos, float preco, String descricao) {
		this.nome = nome;
		this.fornecedores = fornecedores;
		this.servicos = servicos;
		this.preco = preco;
		this.descricao = descricao;
	}
	public String toString() {
		return nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public ArrayList<String> getServicos() {
		return servicos;
	}
	public void setServicos(ArrayList<String> servicos) {
		this.servicos = servicos;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
