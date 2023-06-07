package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaCadastrarPacotes;
import ulitilidades.persistencia.Persistencia;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class OuvinteBotaoCadastrarTelaCadastrarPacotes implements ActionListener{
	private TelaCadastrarPacotes tela;
	
	
	public OuvinteBotaoCadastrarTelaCadastrarPacotes(TelaCadastrarPacotes tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		String nome = tela.getTxtNome().getText();
		Float valor = Float.parseFloat(tela.getTxtpreco().getText());
		String descricao = tela.getTxtdescricao().getText();
		
		
		
		
	}
	
}
