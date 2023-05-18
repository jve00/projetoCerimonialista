package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaCadastrarCliente;
import projeto.telas.MenuAdm.TelaMenuADM;

public class OuvinteBotaoCadastrarClienteTelaMenu implements ActionListener{
	
		private TelaMenuADM tela;
		
		public OuvinteBotaoCadastrarClienteTelaMenu(TelaMenuADM tela) {
			this.tela = tela;
		}
		public void actionPerformed(ActionEvent e) {
			Object componente = e.getSource();
			tela.dispose();
			new TelaCadastrarCliente("Cadastrar Cliente");
	
		
	}

}
