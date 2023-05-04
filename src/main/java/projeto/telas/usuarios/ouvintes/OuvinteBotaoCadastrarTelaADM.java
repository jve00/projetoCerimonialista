package projeto.telas.usuarios.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.usuario.TelaDeCadastroADM;
import projeto.telas.usuario.TelaLogin;

public class OuvinteBotaoCadastrarTelaADM implements ActionListener {
	private TelaDeCadastroADM tela;

	public OuvinteBotaoCadastrarTelaADM(TelaDeCadastroADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		if(componente == tela.getBtnCadastrar()) {
			tela.dispose();
			new TelaLogin("");
		}

	}

}
