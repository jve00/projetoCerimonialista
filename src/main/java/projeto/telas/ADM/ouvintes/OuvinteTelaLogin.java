package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import projeto.exceptions.UsuarioNaoExisteException;
import projeto.exceptions.ValidacaoException;
import projeto.exceptions.ValidacaoExceptionEmail;
import projeto.telas.ADM.TelaCadastroUsuario;
import projeto.telas.ADM.TelaLogin;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteTelaLogin implements ActionListener {
	private TelaLogin tela;

	public OuvinteTelaLogin(TelaLogin tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		String email = tela.getTxtEmail().getText();
		String senha = String.valueOf(tela.getTxtSenha().getPassword());
		Object component = e.getSource();
		System.out.println("entrou");
			
		try {
			boolean valido = Validador.validarEmail(email);
			Validador.validarEmail(email);
			Validador.validarSenha(senha);
			if (valido) {
				if (central.verificarEmailAdm(email) && central.verificarSenha(senha)) {
					tela.dispose();
					new TelaCadastroUsuario();
				}
			}
		} catch (UsuarioNaoExisteException e1) {
			FabricaJOptionPane.criarMsgErro(e1.getMessage());
		} catch (ValidacaoExceptionEmail erro) {
			FabricaJOptionPane.criarMsgErro(erro.getMessage());
		} catch (ValidacaoException e1) {
			e1.printStackTrace();
		}

	}

}
