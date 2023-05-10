package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaMenuADM;

public class OuvinteBotaoCadastrarFornecedorTelaMenu implements ActionListener {
	
	
	private TelaMenuADM tela;

	public OuvinteBotaoCadastrarFornecedorTelaMenu(TelaMenuADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
	}
}
