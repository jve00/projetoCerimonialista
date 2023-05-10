package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteBotaoEntrarTelaLogin;
import projeto.telas.ADM.ouvintes.OuvinteBotaoEsqueceuSenhaTelaLogin;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

//classe da Tela de login
public class TelaLogin extends TelaPadrao {

	// Atributos unicos da tela login
	private JTextField txtEmail;
	private JPasswordField txtSenha;;
	private JButton btnResetSenha;
	private JButton btnEntrar;
	private JButton btnCadastrese;
	private ImagemDeFundo background;

	// Construtor da Tela de login
	public TelaLogin(String titulo) {
		super(titulo);
		setVisible(true);
	}

	// metodo para configurar uma imagem de fundo(background)
	private void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	// metodo para configurar os componentes da tela
	public void configurarComponentes() {
		configImagemFundo();
		configFormLogin();

	}

	// metodo para criar e adicionar os elementos da tela
	private void configFormLogin() {
		// Adesivo Email
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 100, 100, 460, 40, FabricasColors.corLabelBranca, 25);

		// Adesivo Senha
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 100, 180, 460, 40, FabricasColors.corLabelBranca, 25);

		JLabel lblTitulo = FabricaJLabel.criarJLabel("Party Helper", 225, 40, 460, 40, FabricasColors.corLabelBranca,
				40);

		// Campo para armazenar o email
		txtEmail = FabricaJText.criarJTextField(100, 135, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca,"Digite o seu email aqui", 16);

		// Campo para armazenar a senha
		txtSenha = FabricaJText.criarJPasswordField(100, 220, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca,"Digite a sua senha aqui", 20);

		// Bot�o esqueceu a senha
		btnResetSenha = FabricaJButton.criarJButton("Esqueceu a senha?", 430, 270, 120, 20, new Color(255, 255, 255),
				new Color(121, 107, 207)," clique aqui se voce esqueceu sua senha", 12);

		// Bot�o Entrar
		btnEntrar = FabricaJButton.criarJButton("Entrar", 270, 320, 120, 45, new Color(255, 255, 255),
				new Color(121, 107, 207),"clique aqui para logar ", 30);

		// Ouvinte para a tela
		OuvinteBotaoEsqueceuSenhaTelaLogin ouvinteSenha = new OuvinteBotaoEsqueceuSenhaTelaLogin(this);
		OuvinteBotaoEntrarTelaLogin ouvinteTelaLogin = new OuvinteBotaoEntrarTelaLogin(this);
		// Ouvinte padr�o para os bot�es
		OuvinteBotaoFundoPreto ouvinteBotaoPadrao = new OuvinteBotaoFundoPreto();

		// Adicionando um ouvinte para o bot�o esqueceu a senha
		btnResetSenha.addActionListener(ouvinteSenha);

		// Adicionando um ouvinte para identificar o click do mouse ao bot�o esqueceu a
		// senha
		btnResetSenha.addMouseListener(ouvinteBotaoPadrao);

		// Adicionando um ouvinte ao botao entrar
		btnEntrar.addActionListener(ouvinteTelaLogin);

		// Adicionando um ouvinte para identificar o click do mouse ao bot�o entrar
		btnEntrar.addMouseListener(ouvinteBotaoPadrao);

		// Adicionando os elementos citados acima a tela
		background.add(lblTitulo);
		background.add(btnResetSenha);
		background.add(btnEntrar);
		background.add(lblEmail);
		background.add(lblSenha);
		background.add(txtEmail);
		background.add(txtSenha);
	}

	// gets e sets do atributos de telaLogin
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JPasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}

	public JButton getBtnResetSenha() {
		return btnResetSenha;
	}

	public void setBtnResetSenha(JButton btnResetSenha) {
		this.btnResetSenha = btnResetSenha;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}

	public JButton getBtnCadastrese() {
		return btnCadastrese;
	}

	public void setBtnCadastrese(JButton btnCadastrese) {
		this.btnCadastrese = btnCadastrese;
	}

	// Teste de tela
	public static void main(String[] args) {
		new TelaLogin("Login");

	}
}
