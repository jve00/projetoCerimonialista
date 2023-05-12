package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

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
		ButtonGroup button = new ButtonGroup();
// logica a ser feita
//			tela.getJcbPessoaFisica().setEnabled(false);
//			tela.getLblCPF().setVisible(true);
//			tela.getTxtCNPJ().setVisible(true);
//			tela.getLblCNPJ().setVisible(true);
//			tela.getTxtCPF().setVisible(true);
//	
//			button.
	}
//
}
