package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaCadastrarFornecedor;
import projeto.telas.MenuAdm.TelaMenuADM;

public class OuvinteBotaoCadastrarFornecedorTelaMenu implements ActionListener {
	
	
	private TelaMenuADM tela;

	public OuvinteBotaoCadastrarFornecedorTelaMenu(TelaMenuADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		tela.dispose();
		new TelaCadastrarFornecedor("Cadastrar Fornecedor");
	}
}
