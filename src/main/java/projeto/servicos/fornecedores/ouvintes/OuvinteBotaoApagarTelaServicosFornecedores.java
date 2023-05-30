package projeto.servicos.fornecedores.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ListSelectionListener;

import projeto.telas.MenuAdm.TelaServicosFornecedores;

public class OuvinteBotaoApagarTelaServicosFornecedores implements ActionListener {
	private TelaServicosFornecedores tela;

	public OuvinteBotaoApagarTelaServicosFornecedores(TelaServicosFornecedores tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e, MouseEvent i) {
//		int linhaSelecionada = tela.getTabelaServicos().getSelectedRow();
//		System.out.println(linhaSelecionada);
		
//		if (linhaSelecionada != -1) {
//			tela.getTabelaServicos().removeRowSelectionInterval(linhaSelecionada, linhaSelecionada);
//			System.out.println("apagou");
//		}
	}
	private void Mousecli( MouseEvent i) {
		int linhaSelecionada = tela.getTabelaServicos().getSelectedRow();
		System.out.println(linhaSelecionada);

	}

	public void actionPerformed(ActionEvent e) {

	}

}
