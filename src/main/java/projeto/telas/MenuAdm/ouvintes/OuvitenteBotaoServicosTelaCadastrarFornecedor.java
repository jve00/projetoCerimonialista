package projeto.telas.MenuAdm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.MenuAdm.TelaCadastrarFornecedor;

public class OuvitenteBotaoServicosTelaCadastrarFornecedor implements ActionListener {

	private TelaCadastrarFornecedor tela;

	public OuvitenteBotaoServicosTelaCadastrarFornecedor(TelaCadastrarFornecedor tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
//		TipoDeServico[] opcoes = { TipoDeServico.BUFFET, TipoDeServico.DECORACAO,
//				TipoDeServico.EQUIPAMENTOS_DE_ESTRUTURA, TipoDeServico.LOCAL_DO_EVENTO, TipoDeServico.MUSICA };
//
//		TipoDeServico retorno = (TipoDeServico) JOptionPane.showInputDialog(null,
//				"Qual tipo de servicos esse fornecedor oferece?", "Servicos", JOptionPane.QUESTION_MESSAGE, null,
//				opcoes, opcoes[2]);
//		
//		
//		
//		if(Integer.parseInt(retorno) == 0) {
			
//		}
	}
}
