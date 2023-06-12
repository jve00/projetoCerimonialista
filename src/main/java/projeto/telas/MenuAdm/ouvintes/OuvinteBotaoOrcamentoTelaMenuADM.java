package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaMenuADM;
import projeto.telas.Orcamentos.TelaCadastrarOrcamento;
import projeto.telas.Orcamentos.TelaListarOrcamentos;

public class OuvinteBotaoOrcamentoTelaMenuADM implements ActionListener {

	private TelaMenuADM tela;

	public OuvinteBotaoOrcamentoTelaMenuADM(TelaMenuADM tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		tela.dispose();
		new TelaListarOrcamentos("Listagem de Orcamentos");
	}

}
