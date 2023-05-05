package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaLogin;

public class OuvinteBotaoEsqueceuSenhaTelaLogin implements ActionListener{
	
	private TelaLogin tela;
	
	
	public OuvinteBotaoEsqueceuSenhaTelaLogin(TelaLogin tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		if(componente == tela.getBtnResetSenha()) {
			tela.dispose();
		}

	}

}
