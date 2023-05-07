package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaTrocarSenhaADM;
import ulitilidades.persistencia.Persistencia;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteTelaTrocarSenhaADM implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");

	private TelaTrocarSenhaADM tela;

	public OuvinteTelaTrocarSenhaADM(TelaTrocarSenhaADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		char[] NovaSenha = tela.getTxtNovaSenha().getPassword();
	
		char[] ConfirmarSenha = tela.getTxtConfirmarSenha().getPassword();
		String ConfiamrPassword = new String(ConfirmarSenha);
		
		Object componente = e.getSource();
		if (NovaSenha.equals(ConfirmarSenha)) {

		}

	}

}
