
//logica a ser pensanda, estamos sobrescrevendo muita coisa, e não tem necessidade

package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

import projeto.telas.ADM.TelaCadastrarFornecedor;

public class OuvinteCheckBoxTelaDeCadastrarFornecedor implements ActionListener {

	private TelaCadastrarFornecedor tela;

	public OuvinteCheckBoxTelaDeCadastrarFornecedor(TelaCadastrarFornecedor tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
//		Object componente = e.getSource();
////
//		boolean JuridicaSelecionada = tela.getJcbPessoaFisica().isSelected();
//		boolean FisicaSelecionada = tela.getJcbPessoaJuridica().isSelected();
//
//		ButtonGroup button = new ButtonGroup();
//		tela.getLblCPF().setVisible(false);
//		tela.getTxtCNPJ().setVisible(false);
//		tela.getLblCNPJ().setVisible(false);
//		tela.getTxtCPF().setVisible(false);
//
//		button.add(tela.getJcbPessoaFisica());
//		button.add(tela.getJcbPessoaJuridica());
//		if (JuridicaSelecionada) {
//			tela.getLblCNPJ().setVisible(true);
//			tela.getTxtCNPJ().setVisible(true);
//		} else {
//			tela.getTxtCPF().setVisible(true);
//			tela.getLblCPF().setVisible(true);
//		}
	}

}
