package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ListarFornecedores.TelaListarFornecedores;
import projeto.telas.MenuAdm.TelaMenuADM;

public class OuvinteBotaoFornecedoresTelaMenuADM implements ActionListener {

	private TelaMenuADM tela;

	public OuvinteBotaoFornecedoresTelaMenuADM(TelaMenuADM tela) {
		this.tela = tela;

	}
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		tela.dispose();
		new TelaListarFornecedores("Listagem dos fornecedores");

	}

}
