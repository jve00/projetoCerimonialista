package projeto.modelos;

import java.time.LocalDate;

import projeto.UsuarioPadrao;
import projeto.modelos.enuns.TipoDeServico;

public class Fornecedor extends UsuarioPadrao {

	private TipoDeServico tipoDeServico;

	public Fornecedor(String nome, String tipo, String email, LocalDate idade, String sexo, String senha,
			TipoDeServico tipoDeServico) {
		super(nome, tipo, email, idade, sexo, senha);
		this.tipoDeServico = tipoDeServico;

	}
	public TipoDeServico getTipoDeServico() {
		return tipoDeServico;
	}
	public void setTipoDeServico(TipoDeServico tipoDeServico) {
		this.tipoDeServico = tipoDeServico;
	}
}
