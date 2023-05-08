package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.exceptions.UsuarioNaoExisteException;
import projeto.exceptions.ValidacaoExceptionEmail;
import projeto.telas.ADM.TelaCodigo;
import projeto.telas.ADM.TelaLogin;
import projeto.telas.ADM.TelaTrocarSenhaADM;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.email.Mensageiro;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoEnviarTelaCodigo implements ActionListener {

	private TelaCodigo tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public OuvinteBotaoEnviarTelaCodigo(TelaCodigo tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		String email = tela.getTxtEmail().getText();
		Object componente = e.getSource();
		try {
			central.verificarEmailAdm(email);
			boolean valido = Validador.validarEmail(email);
			if (valido) {
				int codigo = Mensageiro.enviarCodigo(email);
				String codigoDigitado = FabricaJOptionPane.criarInput("Digite o codigo recebido por email");
				String codigoMensageiro = String.valueOf(codigo);
				if (codigoMensageiro.equals(codigoDigitado)) {
					tela.dispose();
					new TelaTrocarSenhaADM("Trocar de Senha");
				} else {
					FabricaJOptionPane.criarMsg("esse Codigo e invalido!");
					tela.getTxtEmail().setText("");
				}
			}
		} catch (ValidacaoExceptionEmail e1) {
			FabricaJOptionPane.criarMsgErro(e1.getMessage());
		} catch (UsuarioNaoExisteException erro) {
			FabricaJOptionPane.criarMsgErro(erro.getMessage());
		}

	}
}
