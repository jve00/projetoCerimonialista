package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaCadastrarPacotes;
import projeto.telas.MenuAdm.TelaMenuADM;

public class OuvinteBotaoPacotesTelaMenuADM implements ActionListener {
	private TelaMenuADM tela;

	public OuvinteBotaoPacotesTelaMenuADM(TelaMenuADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		tela.dispose();
		new TelaCadastrarPacotes("Cadastrar pacotes de promoções");

	}

}
