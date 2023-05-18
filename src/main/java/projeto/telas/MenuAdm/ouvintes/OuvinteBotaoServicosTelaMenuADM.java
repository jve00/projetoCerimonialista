package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaMenuADM;

public class OuvinteBotaoServicosTelaMenuADM implements ActionListener {

	private TelaMenuADM tela;

	public OuvinteBotaoServicosTelaMenuADM(TelaMenuADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
	}

}
