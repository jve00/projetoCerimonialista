package projeto.telas.usuarios.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.usuario.TelaLogin;

public class OuvinteBotaoEntrarTelaLogin implements ActionListener{
	private TelaLogin tela;

	public OuvinteBotaoEntrarTelaLogin(TelaLogin tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		
	}

}
