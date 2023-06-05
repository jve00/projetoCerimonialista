package servico.permissao.edit;

import java.awt.Component;
import java.awt.Container;

import projeto.telas.EditarDados.TelaEditarInforFornecedor;

public class Editar {

	public static void desativarComponentes(TelaEditarInforFornecedor tela, boolean b) {
		tela.getTxtNome().setEnabled(b);
		tela.getTxtEmail().setEnabled(b);
		tela.getTxtCNPJ().setEnabled(b);
		tela.getTxtAreaFeedback().setEnabled(b);
		tela.getTabelaServicos().setEnabled(b);
		tela.getLblCNPJ().setEnabled(b);
		tela.getLblEmail().setEnabled(b);
		tela.getLblNomeDoFornecedor().setEnabled(b);
		tela.getLblTipo().setEnabled(b);
		tela.getLblTitulo().setEnabled(b);
		tela.getLblFeedback().setEnabled(b);
		tela.getRdPessoaJuridica().setEnabled(b);
	}


	public static void ativarComponentes(TelaEditarInforFornecedor tela, boolean b) {
		tela.getTxtNome().setEnabled(b);
		tela.getTxtEmail().setEnabled(b);
		tela.getTxtCNPJ().setEnabled(b);
		tela.getTxtAreaFeedback().setEnabled(b);
		tela.getTabelaServicos().setEnabled(b);
		tela.getLblCNPJ().setEnabled(b);
		tela.getLblEmail().setEnabled(b);
		tela.getLblNomeDoFornecedor().setEnabled(b);
		tela.getLblTipo().setEnabled(b);
		tela.getLblTitulo().setEnabled(b);
		tela.getLblFeedback().setEnabled(b);
		tela.getRdPessoaJuridica().setEnabled(b);
	}

}
