package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaMenuADM;

public class OuvinteBotaoCadastrosTelaMenuADM implements ActionListener {

	private TelaMenuADM tela;

	public OuvinteBotaoCadastrosTelaMenuADM(TelaMenuADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		tela.getBtnCadastrarFornecedor().setVisible(true);
		tela.getBtnCadastrarCliente().setVisible(true);

		
	

	}

}
