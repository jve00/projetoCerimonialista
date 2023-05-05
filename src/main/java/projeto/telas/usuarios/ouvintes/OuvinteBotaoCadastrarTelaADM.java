package projeto.telas.usuarios.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import projeto.exceptions.DataInvalidaException;
import projeto.modelos.Administrador;
import projeto.telas.usuario.TelaDeCadastroADM;
import projeto.telas.usuario.TelaLogin;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.data.ServicoData;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoCadastrarTelaADM implements ActionListener {
	private TelaDeCadastroADM tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public OuvinteBotaoCadastrarTelaADM(TelaDeCadastroADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		String login = tela.getTxtEmail().getText();
		String senha = String.valueOf(tela.getTxtSenha().getPassword());
		String dataDeNascimento = tela.getTxtData().getText();
		try {
			Object componente = e.getSource();
			if (componente == tela.getBtnCadastrar()) {
				LocalDate data = ServicoData.retornarData(dataDeNascimento);
				central.setAdministrador(new Administrador(login, senha, data));
				persistencia.salvarCentral(central, "central");
			}

		} catch (DataInvalidaException erro) {
			FabricaJOptionPane.criarMsgAtencao(erro.getMessage());
		}
		tela.dispose();
		new TelaLogin("Login");
	}

}
