package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaServicosFornecedores;

public class OuvinteBotaoEditarTelaServicosFornecedores implements ActionListener {

	private TelaServicosFornecedores tela;

	public OuvinteBotaoEditarTelaServicosFornecedores(TelaServicosFornecedores tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		
	}

}
