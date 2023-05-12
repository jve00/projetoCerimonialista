package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import projeto.exceptions.ValidacaoExceptionEmail;
import projeto.exceptions.ValidarCheckBoxException;
import projeto.exceptions.ValidarCnpjException;
import projeto.exceptions.ValidarCpfException;
import projeto.exceptions.ValidarNomeException;
import projeto.exceptions.ValidarTelefoneException;
import projeto.modelos.Cliente;
import projeto.telas.ADM.TelaCadastrarCliente;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoCadastrarTelaCadastrarCliente implements ActionListener {

	private TelaCadastrarCliente tela;

	public OuvinteBotaoCadastrarTelaCadastrarCliente(TelaCadastrarCliente tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		String nome = tela.getTxtNome().getText();
		String telefone = String.valueOf((tela.getTxtTelefone().getText()));
		String email = tela.getTxtEmail().getText();
		JCheckBox pessoaFisica = tela.getJcbPessoaFisica();
		JCheckBox pessoaJuridica = tela.getJcbPessoaJuridica();
		Object componente = e.getSource();
		String cpf = "";
		String cnpj = "";

		if (pessoaJuridica.isSelected()) {
			cnpj = tela.getTxtCNPJ().getText();
		} else {
			cpf = tela.getTxtCPF().getText();
		}
		try {
			boolean valido = Validador.validarCadastro(nome, telefone, email, pessoaFisica, pessoaJuridica, cpf, cnpj);
			if (valido) {
				if (pessoaFisica.isSelected()) {
					System.out.println("entrou");
					central.adicionarCliente(new Cliente(nome, telefone, email, cpf));
					System.out.println("salvo");
					persistencia.salvarCentral(central, "central");
				} else {
					central.adicionarCliente(new Cliente(nome, telefone, email, cnpj));
					persistencia.salvarCentral(central, "central");
				}
			}
		} catch (Exception e1) {
			FabricaJOptionPane.criarMsgErro(e1.getMessage());
		}
	}

}
