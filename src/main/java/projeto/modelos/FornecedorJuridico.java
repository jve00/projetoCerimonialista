package projeto.modelos;

import java.util.ArrayList;

import projeto.modelos.enuns.TipoDeServico;

public class FornecedorJuridico extends Fornecedor {

	// Atributos unicos de pessoa juridica
	private long CNPJ;

	// construtor feito para iniciar todos os atributos
	public FornecedorJuridico(String nome, String telefone, String tipo, String email,long CNPJ, ArrayList<TipoDeServico> tipoDeServico) {
		super(nome, telefone, tipo, email, tipoDeServico);
		this.CNPJ = CNPJ;
	}


	// gets e sets unicos
	public long getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(long cNPJ) {
		CNPJ = cNPJ;
	}
}