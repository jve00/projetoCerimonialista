package projeto.servicos.fornecedores.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import projeto.telas.MenuAdm.TelaServicosFornecedores;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoEditarTelaServicosFornecedores implements ActionListener {

	private TelaServicosFornecedores tela;

	public OuvinteBotaoEditarTelaServicosFornecedores(TelaServicosFornecedores tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		Object componente = e.getSource();
		int linhaSelecionada = 0;
		linhaSelecionada = tela.getTabelaServicos().getSelectedRow();
		System.out.println(linhaSelecionada);
		if (linhaSelecionada == -1) {
			FabricaJOptionPane.criarMsgErro("Selecione uma linha.");
		} else if (componente == tela.getBtnEditar()) {
			String edit = FabricaJOptionPane.criarInput("edite o serviço aqui");
			central.getServicos().set(linhaSelecionada, edit);
			FabricaJOptionPane.criarMsg("Servico editado com sucesso.");
			persistencia.salvarCentral(central, "central");
			tela.dispose();
			tela.getTabelaServicos().repaint();
			new TelaServicosFornecedores("Tela de Servicos");

		}

	}

}
