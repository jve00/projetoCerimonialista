	package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaLogin;

//Classe para implementar os ouvintes a tela de login
public class OuvinteBotaoEntrarTelaLogin implements ActionListener {

	// Atributo para armazenar uma tela
	private TelaLogin tela;

	// Construto para passar a tela que implementara esse ouvinte
	public OuvinteBotaoEntrarTelaLogin(TelaLogin tela) {
		this.tela = tela;
	}

	// Metodo para atribuir ouvintes
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		if (componente == tela.getBtnEntrar()) {
			tela.dispose();
		}

	}

}
