package projeto.modelos;

import java.util.ArrayList;

import projeto.UsuarioPadrao;
import projeto.modelos.enuns.TipoDeServico;

public class Fornecedor extends UsuarioPadrao {

	private ArrayList<TipoDeServico> tipoDeServicos;

	public Fornecedor(String nome,String telefone, String tipo, String email,
			ArrayList<TipoDeServico> tipoDeServico) {
		super(nome,telefone, tipo, email);
		this.tipoDeServicos = tipoDeServico;

	}

	public ArrayList<TipoDeServico> getTipoDeServicos() {
		return tipoDeServicos;
	}

	public void setTipoDeServicos(ArrayList<TipoDeServico> tipoDeServicos) {
		this.tipoDeServicos = tipoDeServicos;
	}
	
}
