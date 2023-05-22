package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

import projeto.telas.MenuAdm.TelaCadastrarCliente;

public class OuvinteCheckBoxJuridicoTelaDeCadastrarCliente implements ActionListener {

	private TelaCadastrarCliente tela;

	public OuvinteCheckBoxJuridicoTelaDeCadastrarCliente(TelaCadastrarCliente tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		boolean JuridicaSelecionada = tela.getJcbPessoaJuridica().isSelected();
		boolean FisicaSelecionada = tela.getJcbPessoaFisica().isSelected();
		ButtonGroup button = new ButtonGroup();
		tela.getLblCPF().setVisible(false);
		tela.getTxtCNPJ().setVisible(false);
		tela.getLblCNPJ().setVisible(false);
		tela.getTxtCPF().setVisible(false);

		button.add(tela.getJcbPessoaFisica());
		button.add(tela.getJcbPessoaJuridica());

		if (JuridicaSelecionada) {
			tela.getLblCNPJ().setVisible(true);
			tela.getTxtCNPJ().setVisible(true);
		} else {
			tela.getTxtCPF().setVisible(true);
			tela.getLblCPF().setVisible(true);
		}
	}

}
