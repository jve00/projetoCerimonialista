package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.usuarios.ouvintes.OuvinteBotaoEntrarTelaLogin;
import projeto.telas.usuarios.ouvintes.OuvinteTelaLogin;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;

public class TelaLogin extends TelaPadrao {

	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private ImagemDeFundo background;;
	private JButton btnResetSenha;
	private JButton btnEntrar;
	private JButton btnCadastrese;

	private void configImagemFundo() {
		background = super.configImagemFundo("background.jpg");
		add(background);
	}

	public TelaLogin(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configFormLogin();

	}

	private void configFormLogin() {
		 
		Color corTxtField = new Color(179, 177, 177, 110);
		
		JLabel lblTipo = FabricaJLabel.criarJLabel("Tipo do usuario", 100, 20, 460, 40, corTxtField, 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 100, 100, 460, 40,corTxtField, 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 100, 180, 460, 40, corTxtField, 25);
		JLabel lblInfo = FabricaJLabel.criarJLabel("Ainda não tem Conta?", 20, 390, 460, 40, Color.white, 10);

		txtEmail = FabricaJText.criarJTextField(100, 135, 460, 40, corTxtField,new Color(96, 97, 96), 16);
		txtSenha = FabricaJText.criarJPasswordField(100, 220, 460, 40, corTxtField,new Color(96, 97, 96), 20);
		
		btnResetSenha = FabricaJButton.criarJButton("Esqueceu a senha?", 430, 270, 120, 20, new Color(194, 194, 194),Color.black, 12);
		btnCadastrese = FabricaJButton.criarJButton("Cadastre-se", 10, 418, 120, 20, new Color(194, 194, 194),Color.black, 12);
		btnEntrar = FabricaJButton.criarJButton("Entrar", 270, 320, 120, 45, new Color(194, 194, 194,200),Color.black, 30);
		
		OuvinteTelaLogin ouvinte = new OuvinteTelaLogin(this);	
		
		OuvinteBotaoFundoPreto ouvinteBotaoPadrao = new OuvinteBotaoFundoPreto();
		btnResetSenha.addActionListener(ouvinte);
		btnResetSenha.addMouseListener(ouvinteBotaoPadrao);
		
		btnCadastrese.addActionListener(ouvinte);
		btnCadastrese.addMouseListener(ouvinteBotaoPadrao);
		
		btnEntrar.addActionListener(new OuvinteBotaoEntrarTelaLogin(this));
		btnEntrar.addMouseListener(ouvinteBotaoPadrao);
		
		
		background.add(btnResetSenha);
		background.add(btnCadastrese);
		background.add(btnEntrar);
		background.add(lblTipo);
		background.add(lblEmail);
		background.add(lblSenha);
		background.add(lblInfo);
		background.add(txtEmail);
		background.add(txtSenha);
	}

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
	public static void main(String[] args) {
		new TelaLogin("Login");
		
	}

}
