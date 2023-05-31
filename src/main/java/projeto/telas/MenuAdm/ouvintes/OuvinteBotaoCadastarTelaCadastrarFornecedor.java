package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import projeto.modelos.FornecedorFisico;
import projeto.modelos.FornecedorJuridico;
import projeto.modelos.enuns.TipoDeConta;
import projeto.telas.MenuAdm.TelaCadastrarFornecedor;
import projeto.telas.MenuAdm.TelaMenuADM;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoCadastarTelaCadastrarFornecedor implements ActionListener {

	private TelaCadastrarFornecedor tela;

	public OuvinteBotaoCadastarTelaCadastrarFornecedor(TelaCadastrarFornecedor tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		Object componente = e.getSource();
		String nome = tela.getTxtNome().getText();
		String telefone = String.valueOf((tela.getTxtTelefone().getText()));
		String email = tela.getTxtEmail().getText();
		boolean selecionouPessoaFisica = tela.getJcbPessoaFisica().isSelected();
		TipoDeConta tipo = (selecionouPessoaFisica ? TipoDeConta.PESSOAFISICA : TipoDeConta.PESSOAJURIDICA);
		String tipoDaConta = String.valueOf(tipo);

		JCheckBox pessoaFisica = tela.getJcbPessoaFisica();
		JCheckBox pessoaJuridica = tela.getJcbPessoaJuridica();
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
					central.adicionarFornecedor(new FornecedorJuridico(nome, telefone, email, tipoDaConta,
							Long.parseLong(cnpj), tela.getServicosDoFornecedor()));
					persistencia.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Cadastro Confirmado.");
					tela.dispose();
					new TelaMenuADM("Menu");
				} else {
					central.adicionarFornecedor(new FornecedorFisico(nome, telefone, email, tipoDaConta,
							Long.parseLong(cpf), tela.getServicosDoFornecedor()));
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