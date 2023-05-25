package projeto.modelos;

import java.util.ArrayList;

import projeto.UsuarioPadrao;

public class Fornecedor extends UsuarioPadrao {

	private ArrayList<String> tipoDeServicos;

	public Fornecedor(String nome,String telefone, String tipo, String email,
			ArrayList<String> tipoDeServico) {
		super(nome,telefone, tipo, email);
		this.tipoDeServicos = tipoDeServico;

	}
	
	public ArrayList<String> getTipoDeServicos() {
		return tipoDeServicos;
	}

	public void setTipoDeServicos(ArrayList<String> tipoDeServicos) {
		this.tipoDeServicos = tipoDeServicos;
	}
	
}
