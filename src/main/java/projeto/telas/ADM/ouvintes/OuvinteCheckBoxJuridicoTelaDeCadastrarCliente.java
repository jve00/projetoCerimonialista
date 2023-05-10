package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaCadastrarCliente;

public class OuvinteCheckBoxJuridicoTelaDeCadastrarCliente implements ActionListener {

	private TelaCadastrarCliente tela;

	public OuvinteCheckBoxJuridicoTelaDeCadastrarCliente(TelaCadastrarCliente tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		boolean JuridicaSelecionada = tela.getJcbPessoaJuridica().isSelected();
		boolean FisicaSelecionada = tela.getJcbPessoaFisica().isSelected();

		if (JuridicaSelecionada) {
			tela.getJcbPessoaFisica().setEnabled(false);
			tela.getTxtCNPJ().setEnabled(true);
			tela.getTxtCNPJ().setVisible(true);
			tela.getLblCNPJ().setEnabled(true);
			tela.getLblCNPJ().setVisible(true);
		} else {
			tela.getJcbPessoaFisica().setEnabled(true);
			tela.getTxtCNPJ().setEnabled(false);
			tela.getTxtCNPJ().setVisible(false);
			tela.getLblCNPJ().setEnabled(false);
			tela.getLblCNPJ().setVisible(false);

		}
		if (FisicaSelecionada) {
			tela.getJcbPessoaJuridica().setEnabled(false);
			tela.getTxtCPF().setEnabled(true);
			tela.getTxtCPF().setVisible(true);
			tela.getLblCPF().setEnabled(true);
			tela.getLblCPF().setVisible(true);
		} else {
			tela.getJcbPessoaJuridica().setEnabled(true);
			tela.getTxtCPF().setEnabled(false);
			tela.getTxtCPF().setVisible(false);
			tela.getLblCPF().setEnabled(false);
			tela.getLblCPF().setVisible(false);
		}
	}

}
