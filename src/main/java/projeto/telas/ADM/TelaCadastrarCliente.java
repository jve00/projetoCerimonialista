package projeto.telas.ADM;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteBotaoCadastrarTelaCadastrarCliente;
import projeto.telas.ADM.ouvintes.OuvinteCheckBoxJuridicoTelaDeCadastrarCliente;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJCheckBox;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

public class TelaCadastrarCliente extends TelaPadrao {

	private ImagemDeFundo background;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCNPJ;
	private JTextField txtCPF;
	private JCheckBox JcbPessoaFisica;
	private JCheckBox JcbPessoaJuridica;
	private JButton btnCadastrar;
	private JLabel lblCNPJ;
	private JLabel lblCPF;

	public TelaCadastrarCliente(String titulo) {
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
		OuvinteBotaoCadastrarTelaCadastrarCliente ouvinteCadastrarCliente = new OuvinteBotaoCadastrarTelaCadastrarCliente(
				this);
		OuvinteCheckBoxJuridicoTelaDeCadastrarCliente ouvinteCheckBox = new OuvinteCheckBoxJuridicoTelaDeCadastrarCliente(
				this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		OuvinteBotaoFundoBranco ouvinteBranco = new OuvinteBotaoFundoBranco();

		JLabel lblNome = FabricaJLabel.criarJLabel("Nome", 100, 20, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Telefone", 100, 100, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblTelefone = FabricaJLabel.criarJLabel("Email", 100, 180, 460, 40, FabricasColors.corLabelBranca, 25);
		// Campo para armazenar o email
		lblCNPJ = FabricaJLabel.criarJLabel("CNPJ", 100, 280, 460, 40, FabricasColors.corLabelBranca, 20);
		lblCNPJ.setEnabled(false);
		lblCNPJ.setVisible(false);

		lblCPF = FabricaJLabel.criarJLabel("CPF", 100, 340, 460, 40, FabricasColors.corLabelBranca, 20);
		lblCPF.setEnabled(false);
		lblCPF.setVisible(false);

		btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 300, 300, 90, 40, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);

		JcbPessoaFisica = FabricaJCheckBox.criarJCheckBox(500, 264, 80, 30, "Fisica", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa fisica");
		JcbPessoaJuridica = FabricaJCheckBox.criarJCheckBox(430, 264, 80, 30, "juridica", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa juridica");



		txtNome = FabricaJText.criarJTextField(100, 60, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Nome aqui", 20);
		
		txtTelefone = FabricaJText.criarJTextField(100, 135, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Telefone aqui", 20);
		
		txtEmail = FabricaJText.criarJTextField(100, 220, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Email aqui", 20);

		txtCNPJ = FabricaJText.criarJTextField(100, 315, 190, 30, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu CNPJ aqui", 20);
		txtCNPJ.setEnabled(false);
		txtCNPJ.setVisible(false);

		
		txtCPF = FabricaJText.criarJTextField(100, 375, 190, 30, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu CPF aqui", 20);
		txtCPF.setEnabled(false);
		txtCPF.setVisible(false);

		
		btnCadastrar.addActionListener(ouvinteCadastrarCliente);
		btnCadastrar.addMouseListener(ouvinte);
		JcbPessoaFisica.addActionListener(ouvinteCheckBox);
		JcbPessoaFisica.addMouseListener(ouvinteBranco);
		JcbPessoaJuridica.addActionListener(ouvinteCheckBox);
		JcbPessoaJuridica.addMouseListener(ouvinteBranco);
	
		
		
		background.add(lblTelefone);
		background.add(lblEmail);
		background.add(lblCNPJ);
		background.add(lblNome);
		background.add(lblCPF);
		background.add(txtNome);
		background.add(txtEmail);
		background.add(txtTelefone);
		background.add(txtCNPJ);
		background.add(txtCPF);
		background.add(JcbPessoaFisica);
		background.add(JcbPessoaJuridica);
		background.add(btnCadastrar);
	}

	public JCheckBox getJcbPessoaFisica() {
		return JcbPessoaFisica;
	}

	public void setJcbPessoaFisica(JCheckBox jcbPessoaFisica) {
		JcbPessoaFisica = jcbPessoaFisica;
	}

	public JCheckBox getJcbPessoaJuridica() {
		return JcbPessoaJuridica;
	}

	public void setJcbPessoaJuridica(JCheckBox jcbPessoaJuridica) {
		JcbPessoaJuridica = jcbPessoaJuridica;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	public static void main(String[] args) {
		new TelaCadastrarCliente("");
	}

	public JTextField getTxtCNPJ() {
		return txtCNPJ;
	}

	public void setTxtCNPJ(JTextField txtCNPJ) {
		this.txtCNPJ = txtCNPJ;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}

	public JLabel getLblCNPJ() {
		return lblCNPJ;
	}

	public void setLblCNPJ(JLabel lblCNPJ) {
		this.lblCNPJ = lblCNPJ;
	}

	public JLabel getLblCPF() {
		return lblCPF;
	}

	public void setLblCPF(JLabel lblCPF) {
		this.lblCPF = lblCPF;
	}
	

}
