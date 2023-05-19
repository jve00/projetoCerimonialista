package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.TelaPadrao;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJCheckBox;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

public class TelaCadastrarFornecedor extends TelaPadrao{

	
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
	private JCheckBox JcbBuffet;
	private JCheckBox JcbMusica;
	private JCheckBox JcbDecoracao;
	private JCheckBox JcbEquipamentosDeEstrutura;
	private JCheckBox JcbLocalDeEvento;
	
	public TelaCadastrarFornecedor(String titulo) {
		super(titulo);
		configTela();
		setVisible(true);
	
	}

	public void configurarComponentes() {
		configImagemFundo();
		
	}
	public void configTela() {
	
		
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome", 100, 20, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Telefone", 100, 100, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblTelefone = FabricaJLabel.criarJLabel("Email", 100, 180, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lbTiposDeServico = FabricaJLabel.criarJLabel("Tipos de Serviços", 100, 270, 460, 40, FabricasColors.corLabelBranca, 18);
		
		lblCNPJ = FabricaJLabel.criarJLabel("CNPJ", 430, 280, 460, 40, FabricasColors.corLabelBranca, 20);

		lblCNPJ.setVisible(true);

		lblCPF = FabricaJLabel.criarJLabel("CPF", 430, 340, 460, 40, FabricasColors.corLabelBranca, 20);

		lblCPF.setVisible(true);

		txtCNPJ = FabricaJText.criarJTextField(430, 315, 190, 30, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu CNPJ aqui", 20);

		txtCNPJ.setVisible(true);

		txtCPF = FabricaJText.criarJTextField(430, 375, 190, 30, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu CPF aqui", 20);
		txtCPF.setVisible(true);

		JcbPessoaFisica = FabricaJCheckBox.criarJCheckBox(500, 264, 80, 30, "Fisica", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa fisica");
		JcbPessoaJuridica = FabricaJCheckBox.criarJCheckBox(430, 264, 80, 30, "juridica", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa juridica");

		btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 300, 400, 90, 40, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);
		txtNome = FabricaJText.criarJTextField(100, 60, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Nome aqui", 20);

		txtTelefone = FabricaJText.criarJTextField(100, 135, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Telefone aqui", 20);

		txtEmail = FabricaJText.criarJTextField(100, 220, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Email aqui", 20);
		
		JcbBuffet = FabricaJCheckBox.criarJCheckBox(100, 300, 100, 30, "Buffet", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o serviço de buffet");
		
		JcbDecoracao = FabricaJCheckBox.criarJCheckBox(100, 335, 100, 30, "Decoração", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o serviço de decoração");
		
		JcbEquipamentosDeEstrutura = FabricaJCheckBox.criarJCheckBox(100, 365, 100, 30, "Estruturação", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o serviço de equipamentos de estrutura");
		
		JcbLocalDeEvento = FabricaJCheckBox.criarJCheckBox(100, 400, 180, 30, "Local de Evento", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o serviço de fornecedor de local");
		
		JcbMusica = FabricaJCheckBox.criarJCheckBox(100, 435, 100, 30, "Musica", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o serviço de musica");

		background.add(JcbPessoaFisica);
		background.add(JcbPessoaJuridica);
		background.add(txtCNPJ);
		background.add(txtCPF);
		background.add(lblCPF);
		background.add(lblCNPJ);
		background.add(lblTelefone);
		background.add(lblEmail);
		background.add(lblNome);
		background.add(txtNome);
		background.add(txtEmail);
		background.add(txtTelefone);
		background.add(btnCadastrar);
		background.add(JcbBuffet);
		background.add(JcbDecoracao);
		background.add(JcbEquipamentosDeEstrutura);
		background.add(JcbLocalDeEvento);
		background.add(JcbMusica);
		background.add(lbTiposDeServico);
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
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

	public static void main(String[] args) {
		new TelaCadastrarFornecedor("Cadastrar Fornecedor");
		
	}
	
}
