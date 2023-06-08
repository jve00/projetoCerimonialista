package projeto.telas.MenuAdm;

import javax.swing.JButton;
import javax.swing.JLabel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoCadastrarClienteTelaMenu;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoCadastrarFornecedorTelaMenu;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoCadastrosTelaMenuADM;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoFornecedoresTelaMenuADM;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoOrcamentoTelaMenuADM;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoPacotesTelaMenuADM;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoServicosTelaMenuADM;
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
	private JButton btnOrcamentos;
	private JButton btnPacotes;

	public JButton getBtnPacotes() {
		return btnPacotes;
	}

	public void setBtnPacotes(JButton btnPacotes) {
		this.btnPacotes = btnPacotes;
	}

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
		OuvinteBotaoOrcamentoTelaMenuADM ouvinteOrcamento = new OuvinteBotaoOrcamentoTelaMenuADM(this);
		OuvinteBotaoPacotesTelaMenuADM ouvintePacotes = new OuvinteBotaoPacotesTelaMenuADM(this);
		OuvinteBotaoCadastrarClienteTelaMenu ouvinteCadastrarCliente = new OuvinteBotaoCadastrarClienteTelaMenu(this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		JLabel lblTitulo = FabricaJLabel.criarJLabel("Menu", 300, 40, 460, 40, FabricasColors.corLabelBranca, 40);

		btnCadastrarCliente = FabricaJButton.criarJButton("Cadastrar Cliente", 290, 100, 120, 35,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo, "Clique aqui para Cadastrar um cliente", 10);
		btnCadastrarCliente.setVisible(false);
		btnCadastrarCliente.addActionListener(ouvinteCadastrarCliente);
		btnCadastrarCliente.addMouseListener(ouvinte);
		btnCadastrarFornecedor = FabricaJButton.criarJButton("Cadastrar Fornecedor", 290, 150, 120, 35,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo, "Clique aqui para Cadastrar um fornecedor", 10);
		btnCadastrarFornecedor.setVisible(false);

		btnCadastrarFornecedor.addActionListener(ouvinteCadastrarFornecedor);
		btnCadastrarFornecedor.addMouseListener(ouvinte);

		btnCadastros = FabricaJButton.criarJButton("", Imagens.CADASTROS, 10, 20, 300, 300,
				"clique aqui para abrir os Cadastros");
		btnCadastros.addActionListener(ouvinteCadastros);
		btnCadastros.addMouseListener(ouvinte);

		btnFornecedores = FabricaJButton.criarJButton("", Imagens.FORNECEDORES, 390, 20, 300, 300,
				"clique aqui para olhar os Fornecedores");
		btnFornecedores.addActionListener(ouvinteFornecedores);
		btnFornecedores.addMouseListener(ouvinte);
		btnServicos = FabricaJButton.criarJButton("", Imagens.SERVICOS, 10, 180, 300, 300,
				"clique aqui para olhar os tipos de Servicos");
		btnServicos.addActionListener(ouvinteServicos);
		btnServicos.addMouseListener(ouvinte);

		btnOrcamentos = FabricaJButton.criarJButton("", Imagens.ORCAMENTOS, 390, 180, 300, 300,
				"clique aqui para verificar os Orcamentos");
		btnOrcamentos.addActionListener(ouvinteOrcamento);
		btnOrcamentos.addMouseListener(ouvinte);
		btnPacotes = FabricaJButton.criarJButton("", Imagens.PACOTES, 200, 100, 300, 300,
				"clique aqui para verificar os tipos de pacotes");
		btnPacotes.addActionListener(ouvintePacotes);
		btnPacotes.addMouseListener(ouvinte);

		background.add(btnCadastros);
		background.add(btnFornecedores);
		background.add(btnServicos);
		background.add(lblTitulo);
		background.add(btnCadastrarCliente);
		background.add(btnCadastrarFornecedor);
		background.add(btnOrcamentos);
		background.add(btnPacotes);
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

	public JButton getBtnOrcamentos() {
		return btnOrcamentos;
	}

	public void setBtnOrcamentos(JButton btnOrcamentos) {
		this.btnOrcamentos = btnOrcamentos;
	}

}
