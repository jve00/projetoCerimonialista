package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import projeto.exceptions.ValidacaoException;
import projeto.telas.ADM.TelaLogin;
import projeto.telas.ADM.TelaTrocarSenhaADM;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.email.Mensageiro;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteTelaTrocarSenhaADM implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");

	private TelaTrocarSenhaADM tela;

	public OuvinteTelaTrocarSenhaADM(TelaTrocarSenhaADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		String novaSenha = String.valueOf(tela.getTxtNovaSenha().getPassword());
		String confirmarSenha = String.valueOf(tela.getTxtConfirmarSenha().getPassword());

		Object componente = e.getSource();
		try {
			boolean valido = Validador.validarSenha(novaSenha);
			if (valido) {
				System.out.println("valido");
				if (novaSenha.equals(confirmarSenha)) {
					central.getAdministrador().setSenha(novaSenha);
					persistencia.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Senha cadastrada com sucesso.");
					tela.dispose();
					new TelaLogin("Tela Login");
				} else
					FabricaJOptionPane.criarMsg("As senhas digitadas nao se coincidem");
			}
		} catch (ValidacaoException erro) {
			FabricaJOptionPane.criarMsgErro(erro.getMessage());
		}

	}
}
