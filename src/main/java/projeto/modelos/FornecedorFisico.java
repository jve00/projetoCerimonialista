package projeto.modelos;

import java.util.ArrayList;

public class FornecedorFisico extends Fornecedor {

	// Atributos unicos de PessoaFisica
	private long CPF;

	// Construto para facilitar a cria��o passando todos os atributos
	public FornecedorFisico(String nome, String telefone, String tipo, String email, long CPF,
			ArrayList<String> tipoDeServico) {
		super(nome, telefone, tipo, email, tipoDeServico);
		this.CPF = CPF;
	}
	// gets e sets dos atributos unicos
	public long getCPF() {
		return CPF;
	}

	public void setCPF(long CPF) {
		this.CPF = CPF;
	}

}
