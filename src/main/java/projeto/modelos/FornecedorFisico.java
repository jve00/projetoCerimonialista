package projeto.modelos;

import java.util.ArrayList;

import projeto.modelos.enuns.TipoDeServico;

public class FornecedorFisico extends Fornecedor {

	// Atributos unicos de PessoaFisica
	private long CPF;

	// Construto para facilitar a cria��o passando todos os atributos
	public FornecedorFisico(String nome, String telefone, String tipo, String email, long CPF,
			ArrayList<TipoDeServico> tipoDeServico) {
		super(nome, telefone, tipo, email, tipoDeServico);
		this.CPF = this.CPF;
	}

	// gets e sets dos atributos unicos
	public long getCPF() {
		return CPF;
	}

	public void setCPF(long CPF) {
		this.CPF = CPF;
	}

}
