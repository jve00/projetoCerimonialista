package projeto.telas.ADM;

import javax.swing.JButton;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteBotaoCadastrosTelaMenuADM;
import projeto.telas.ADM.ouvintes.OuvinteBotaoFornecedoresTelaMenuADM;
import projeto.telas.ADM.ouvintes.OuvinteBotaoServicosTelaMenuADM;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.imagens.Imagens;

public class TelaMenuADM extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnCadastros;
	private JButton btnFornecedores;
	private JButton btnServicos;

	public TelaMenuADM(String titulo) {
		super(titulo);
		setVisible(true);

	}

	public void configurarComponentes() {
		configImagemFundo();
		configTela();
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public void configTela() {
		OuvinteBotaoCadastrosTelaMenuADM ouvinteCadastros = new OuvinteBotaoCadastrosTelaMenuADM(this);
		OuvinteBotaoServicosTelaMenuADM ouvinteServicos = new OuvinteBotaoServicosTelaMenuADM(this);
		OuvinteBotaoFornecedoresTelaMenuADM ouvinteFornecedores = new OuvinteBotaoFornecedoresTelaMenuADM(this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		btnCadastros = FabricaJButton.criarJButton("", Imagens.CADASTROS, 200, -70, 300, 300);
		btnCadastros.setToolTipText("Olhar clientes cadastrados");
		btnCadastros.addActionListener(ouvinteCadastros);
		btnCadastros.addMouseListener(ouvinte);
	
		
		btnFornecedores = FabricaJButton.criarJButton("", Imagens.FORNECEDORES, 200, 75, 300, 300);
		btnFornecedores.setToolTipText("Olhar fornecedores cadastrados");
		btnFornecedores.addActionListener(ouvinteFornecedores);
		btnFornecedores.addMouseListener(ouvinte);
		
		
		btnServicos = FabricaJButton.criarJButton("", Imagens.SERVICOS, 200, 220, 300, 300);
		btnServicos.setToolTipText("Olhar servicos disponiveis");
		btnServicos.addActionListener(ouvinteServicos);
		btnServicos.addMouseListener(ouvinte);

		background.add(btnCadastros);
		background.add(btnFornecedores);
		background.add(btnServicos);
	}

	public JButton getBtnServicos() {
		return btnServicos;
	}

	public void setBtnServicos(JButton btnServicos) {
		this.btnServicos = btnServicos;
	}

	public static void main(String[] args) {
		new TelaMenuADM("Menu");
	}

	public JButton getBtnCadastros() {
		return btnCadastros;
	}

	public void setBtnCadastros(JButton btnCadastros) {
		this.btnCadastros = btnCadastros;
	}

	public JButton getBtnFornecedores() {
		return btnFornecedores;
	}

	public void setBtnFornecedores(JButton btnFornecedores) {
		this.btnFornecedores = btnFornecedores;
	}

}
