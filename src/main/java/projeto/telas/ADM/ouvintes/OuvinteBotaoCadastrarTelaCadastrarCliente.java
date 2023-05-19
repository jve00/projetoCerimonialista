package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import projeto.exceptions.ClienteJaExisteException;
import projeto.modelos.PessoaFisica;
import projeto.modelos.PessoaJuridica;
import projeto.modelos.enuns.TipoDeConta;
import projeto.telas.ADM.TelaCadastrarCliente;
import projeto.telas.MenuAdm.TelaMenuADM;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoCadastrarTelaCadastrarCliente implements ActionListener{

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
	private TelaCadastrarCliente tela;

	public OuvinteBotaoCadastrarTelaCadastrarCliente(TelaCadastrarCliente tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {

		String nome = tela.getTxtNome().getText();
		String telefone = String.valueOf((tela.getTxtTelefone().getText()));
		String email = tela.getTxtEmail().getText();
		boolean selecionouPessoaFisica = tela.getJcbPessoaFisica().isSelected();
		TipoDeConta tipoDaConta = (selecionouPessoaFisica ? TipoDeConta.PESSOAFISICA : TipoDeConta.PESSOAJURIDICA);
		String tipo = String.valueOf(tipoDaConta);
		JCheckBox pessoaFisica = tela.getJcbPessoaFisica();
		JCheckBox pessoaJuridica = tela.getJcbPessoaJuridica();
		Object componente = e.getSource();
		String cpf = "";
		String cnpj = "";
		boolean cpfValido = false;
		boolean cnpjValido = false;
		try {
			boolean valido = Validador.validarCadastro(nome, telefone, email, pessoaFisica, pessoaJuridica);
			if (pessoaJuridica.isSelected()) {
				cnpj = tela.getTxtCNPJ().getText();
				cnpjValido = Validador.validarCNPJ(cnpj);
			} else {
				cpf = tela.getTxtCPF().getText();
				cpfValido = Validador.validarCpf(cpf);
			}
			if (valido) {
				if (cnpjValido) {
					central.adicionarCliente(new PessoaJuridica(nome, telefone, email, tipo, Long.parseLong(cnpj)));
					persistencia.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Cadastro Confirmado.");
					tela.dispose();
					new TelaMenuADM("Menu");
				} else {
					central.adicionarCliente(new PessoaFisica(nome, telefone, email, tipo, Long.parseLong(cpf)));
					System.out.println("não entrou");
					persistencia.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Cadastro Confirmado.");
					tela.dispose();
					new TelaMenuADM("Menu");
				}
			}
		} catch (Exception e1) {
			FabricaJOptionPane.criarMsgErro(e1.getMessage());
		}

	}
}
