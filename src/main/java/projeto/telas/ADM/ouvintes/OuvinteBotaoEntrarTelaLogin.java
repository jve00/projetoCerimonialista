package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.exceptions.UsuarioNaoExisteException;
import projeto.exceptions.ValidacaoException;
import projeto.exceptions.ValidacaoExceptionEmail;
import projeto.telas.ADM.TelaCadastroUsuario;
import projeto.telas.ADM.TelaLogin;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

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
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		Object componente = e.getSource();
		String email = tela.getTxtEmail().getText();
		String senha = String.valueOf(tela.getTxtSenha().getPassword());

		try {
			boolean valido = Validador.validarEmail(email);
			boolean validarSenha = Validador.validarSenha(senha);
			boolean verificarEmail = central.verificarEmailAdm(email);
			boolean VerificarSenha = central.verificarSenha(senha);

			if (valido && validarSenha && verificarEmail && VerificarSenha) {
				tela.dispose();
				new TelaCadastroUsuario();
			}else {
				FabricaJOptionPane.criarMsgErro("Email ou senha Invalido");
			}
		} catch (UsuarioNaoExisteException e1) {
			FabricaJOptionPane.criarMsgErro(e1.getMessage());
		} catch (ValidacaoExceptionEmail erro) {
			FabricaJOptionPane.criarMsgErro(erro.getMessage());
		} catch (ValidacaoException e2) {
			FabricaJOptionPane.criarMsgErro(e2.getMessage());
		}
	}

}
