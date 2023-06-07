package projeto.modelos;

import java.util.ArrayList;

public class FornecedorJuridico extends Fornecedor {

	// Atributos unicos de pessoa juridica
	private long CNPJ;

	// construtor feito para iniciar todos os atributos
	public FornecedorJuridico(String nome, String telefone, String tipo, String email, long CNPJ,
			ArrayList<String> tipoDeServico, boolean situacao) {
		super(nome, telefone, tipo, email, tipoDeServico, situacao);
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