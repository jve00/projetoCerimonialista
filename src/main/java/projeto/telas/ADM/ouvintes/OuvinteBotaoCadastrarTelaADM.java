package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import projeto.exceptions.DataInvalidaException;
import projeto.exceptions.ValidacaoException;
import projeto.exceptions.ValidacaoExceptionEmail;
import projeto.modelos.Administrador;
import projeto.telas.ADM.TelaDeCadastroADM;
import projeto.telas.ADM.TelaLogin;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.data.ServicoData;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoCadastrarTelaADM implements ActionListener {
	private TelaDeCadastroADM tela;
	
	public OuvinteBotaoCadastrarTelaADM(TelaDeCadastroADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		String login = tela.getTxtEmail().getText();
		String senha = String.valueOf(tela.getTxtSenha().getPassword());
		String dataDeNascimento = tela.getTxtData().getText();
		Object componente = e.getSource();
		try {
			if (componente == tela.getBtnCadastrar()) {
				LocalDate data = ServicoData.retornarData(dataDeNascimento);
				boolean valido = Validador.validarCadastro(login, senha, data);
				if (valido) {
					central.setAdministrador(new Administrador(login, senha, data));
					persistencia.salvarCentral(central, "central");
					tela.dispose();
					new TelaLogin("Login");
				}
			}
		} catch (DataInvalidaException erro) {
			FabricaJOptionPane.criarMsgAtencao(erro.getMessage());
		} catch (ValidacaoException erroData) {
			FabricaJOptionPane.criarMsgErro(erroData.getMessage());
		} catch (ValidacaoExceptionEmail erroEmail) {
			FabricaJOptionPane.criarMsgErro(erroEmail.getMessage());
		}
	}

}
