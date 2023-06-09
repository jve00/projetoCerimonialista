package projeto.servicos.fornecedores.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import projeto.telas.MenuAdm.TelaServicosFornecedores;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoApagarTelaServicosFornecedores implements ActionListener {
	private TelaServicosFornecedores tela;

	public OuvinteBotaoApagarTelaServicosFornecedores(TelaServicosFornecedores tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		int linhaSelecionada = 0;
		linhaSelecionada = tela.getTabelaServicos().getSelectedRow();
		Object componente = e.getSource();
		if (linhaSelecionada == -1) {
			FabricaJOptionPane.criarMsgErro("Selecione uma linha.");
		} else if (componente == tela.getBtnApagar()) {
			DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaServicos().getModel();
			central.getServicos().remove(linhaSelecionada);
			modelo.removeRow(linhaSelecionada);
			tela.getTabelaServicos().repaint();
			persistencia.salvarCentral(central, "central");
			FabricaJOptionPane.criarMsg("Servico excluido com sucesso");
		}
	}
}
