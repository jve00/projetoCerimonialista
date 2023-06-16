package servico.permissao.edit;

import projeto.telas.EditarDados.TelaEditarInforFornecedor;
import projeto.telas.Orcamentos.TelaEditarDadosDoOrcamento;
import projeto.telas.Orcamentos.TelaListarOrcamentos;

public class Editar {
	public static void ativarComponentes(TelaEditarInforFornecedor tela, boolean b) {
		tela.getTxtNome().setEnabled(b);
		tela.getTxtEmail().setEnabled(b);
		tela.getTxtCNPJ().setEnabled(b);
		tela.getTabelaServicos().setEnabled(b);
		tela.getLblCNPJ().setEnabled(b);
		tela.getLblEmail().setEnabled(b);
		tela.getLblNomeDoFornecedor().setEnabled(b);
		tela.getLblTipo().setEnabled(b);
		tela.getLblTitulo().setEnabled(b);
		tela.getRdPessoaJuridica().setEnabled(b);
		tela.getRdAtivo().setEnabled(b);
		tela.getRdBloqueado().setEnabled(b);
		tela.getRdDesativado().setEnabled(b);
	}

	public static void ativarComponentesOrcamento(TelaEditarDadosDoOrcamento tela, boolean b) {
		tela.getTxtEvento().setEnabled(b);
		tela.getTxtHora().setEnabled(b);
		tela.getTxtLocacao().setEnabled(b);
		tela.getTxtOrcamento().setEnabled(b);
		tela.getTxtTamanho().setEnabled(b);
		tela.getChooser().setEnabled(b);
		tela.getRdCliente().setEnabled(b);
		tela.getRdContrato().setEnabled(b);
		TelaListarOrcamentos.getTabelaDeOrcamentos().setEnabled(b);
	}
}
