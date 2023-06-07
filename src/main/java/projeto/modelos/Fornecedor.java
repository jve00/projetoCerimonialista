package projeto.modelos;

import java.util.ArrayList;

import projeto.UsuarioPadrao;

public class Fornecedor extends UsuarioPadrao {

	private ArrayList<String> tipoDeServicos;
	private boolean situacaoDoFornecedor;
	private String feedback;

	public Fornecedor(String nome, String telefone, String tipo, String email, ArrayList<String> tipoDeServico,
			boolean situacao) {
		super(nome, telefone, tipo, email);
		this.situacaoDoFornecedor = situacao;
		this.tipoDeServicos = tipoDeServico;
	}

	public boolean getSituacaoDoFornecedor() {
		return situacaoDoFornecedor;
	}

	public void setSituacaoDoFornecedor(boolean situacaoDoFornecedor) {
		this.situacaoDoFornecedor = situacaoDoFornecedor;
	}

	public ArrayList<String> getTipoDeServicos() {
		return tipoDeServicos;
	}

	public void setTipoDeServicos(ArrayList<String> tipoDeServicos) {
		this.tipoDeServicos = tipoDeServicos;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
