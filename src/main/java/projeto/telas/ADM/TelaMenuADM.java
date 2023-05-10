package projeto.telas.ADM;

import javax.swing.JButton;
import javax.swing.JLabel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteBotaoCadastrarClienteTelaMenu;
import projeto.telas.ADM.ouvintes.OuvinteBotaoCadastrarFornecedorTelaMenu;
import projeto.telas.ADM.ouvintes.OuvinteBotaoCadastrosTelaMenuADM;
import projeto.telas.ADM.ouvintes.OuvinteBotaoFornecedoresTelaMenuADM;
import projeto.telas.ADM.ouvintes.OuvinteBotaoServicosTelaMenuADM;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricasColors;
import ultilidades.imagens.Imagens;

public class TelaMenuADM extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnCadastros;
	private JButton btnFornecedores;
	private JButton btnServicos;
	private JButton btnCadastrarCliente;
	private JButton btnCadastrarFornecedor;

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
		OuvinteBotaoCadastrarFornecedorTelaMenu ouvinteCadastrarFornecedor = new OuvinteBotaoCadastrarFornecedorTelaMenu(
				this);
		OuvinteBotaoCadastrarClienteTelaMenu ouvinteCadastrarCliente = new OuvinteBotaoCadastrarClienteTelaMenu(this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		JLabel lblTitulo = FabricaJLabel.criarJLabel("Menu", 40, 60, 460, 40, FabricasColors.corLabelBranca, 40);

		btnCadastrarCliente = FabricaJButton.criarJButton("Cadastrar Cliente", 520, 40, 120, 35,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo, "Clique aqui para Cadastrar um cliente", 10);
		btnCadastrarCliente.setEnabled(true);
		btnCadastrarCliente.setVisible(false);
		btnCadastrarFornecedor = FabricaJButton.criarJButton("Cadastrar Fornecedor", 520, 90, 120, 35,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo, "Clique aqui para Cadastrar um fornecedor", 10);
		btnCadastrarFornecedor.setEnabled(true);
		btnCadastrarFornecedor.setVisible(false);

		btnCadastros = FabricaJButton.criarJButton("", Imagens.CADASTROS, 200, -70, 300, 300,
				"clique aqui para abrir os cadastros");
		btnCadastros.addActionListener(ouvinteCadastros);
		btnCadastros.addMouseListener(ouvinte);

		btnFornecedores = FabricaJButton.criarJButton("", Imagens.FORNECEDORES, 200, 75, 300, 300,
				"clique aqui para olhar os fornecedores");
		btnFornecedores.addActionListener(ouvinteFornecedores);
		btnFornecedores.addMouseListener(ouvinte);

		btnServicos = FabricaJButton.criarJButton("", Imagens.SERVICOS, 200, 220, 300, 300,
				"clique aqui para olhar os tipos de servicos");

		btnServicos.addActionListener(ouvinteServicos);
		btnServicos.addMouseListener(ouvinte);

		btnCadastrarCliente.addActionListener(ouvinteCadastrarCliente);
		btnCadastrarCliente.addMouseListener(ouvinte);
		btnCadastrarFornecedor.addActionListener(ouvinteCadastrarFornecedor);
		btnCadastrarFornecedor.addMouseListener(ouvinte);

		background.add(btnCadastros);
		background.add(btnFornecedores);
		background.add(btnServicos);
		background.add(lblTitulo);
		background.add(btnCadastrarCliente);
		background.add(btnCadastrarFornecedor);
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

	public JButton getBtnCadastrarCliente() {
		return btnCadastrarCliente;
	}

	public void setBtnCadastrarCliente(JButton btnCadastrarCliente) {
		this.btnCadastrarCliente = btnCadastrarCliente;
	}

	public JButton getBtnCadastrarFornecedor() {
		return btnCadastrarFornecedor;
	}

	public void setBtnCadastrarFornecedor(JButton btnCadastrarFornecedor) {
		this.btnCadastrarFornecedor = btnCadastrarFornecedor;
	}

}
