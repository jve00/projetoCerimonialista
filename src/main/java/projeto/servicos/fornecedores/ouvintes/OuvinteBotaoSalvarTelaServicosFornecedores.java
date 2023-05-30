package projeto.servicos.fornecedores.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import projeto.exceptions.ServicoJaCadastradoException;
import projeto.telas.MenuAdm.TelaServicosFornecedores;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoSalvarTelaServicosFornecedores implements ActionListener {

	private TelaServicosFornecedores tela;

	public OuvinteBotaoSalvarTelaServicosFornecedores(TelaServicosFornecedores tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("Central");
		Object componente = e.getSource();
		String servico = tela.getTxtServico().getText();
		boolean valido = Validador.validarCampos(servico);

		if (valido) {
			try {
				central.adicionarServico(servico);
				persistencia.salvarCentral(central, "central");
				tela.getTxtServico().setText("");
				FabricaJOptionPane.criarMsg("Servico cadastrado com sucesso.");
				tela.dispose();
				new TelaServicosFornecedores("Servicos");
			} catch (ServicoJaCadastradoException e1) {
				FabricaJOptionPane.criarMsgErro(e1.getMessage());
			}
		}

	}

}
