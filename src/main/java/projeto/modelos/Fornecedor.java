package projeto.modelos;

import projeto.UsuarioPadrao;
import projeto.modelos.enuns.TipoDeServico;

public class Fornecedor extends UsuarioPadrao {

	private TipoDeServico tipoDeServico;

	public Fornecedor(String nome,String telefone, String tipo, String email, String senha,
			TipoDeServico tipoDeServico) {
		super(nome,telefone, tipo, email);
		this.tipoDeServico = tipoDeServico;

	}
	public TipoDeServico getTipoDeServico() {
		return tipoDeServico;
	}
	public void setTipoDeServico(TipoDeServico tipoDeServico) {
		this.tipoDeServico = tipoDeServico;
	}
}
