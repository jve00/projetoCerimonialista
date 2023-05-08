package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaMenuADM;

public class OuvinteBotaoServicosTelaMenuADM implements ActionListener {

	private TelaMenuADM tela;

	public OuvinteBotaoServicosTelaMenuADM(TelaMenuADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
	}

}
