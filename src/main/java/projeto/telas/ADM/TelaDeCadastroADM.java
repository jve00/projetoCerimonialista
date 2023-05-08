package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteBotaoCadastrarTelaADM;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJFormatted;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.fabricas.FabricasDeVariaveis;

public class TelaDeCadastroADM extends TelaPadrao {

	private JTextField txtEmail;
	private JPasswordField txtSenha;;
	private JButton btnCadastrar;
	private JFormattedTextField txtData;
	private ImagemDeFundo background;

	public TelaDeCadastroADM(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}
	public void configurarComponentes() {
		configImagemFundo();
		configFormLogin();
	}

	// metodo para criar e adicionar os elementos da tela
	private void configFormLogin() {
		JLabel lblTitulo = FabricaJLabel.criarJLabel("Olá Administrador.", 175, 40, 460, 40,
				FabricasColors.corLabelBranca, 40);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 100, 100, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 100, 180, 460, 40, FabricasColors.corLabelBranca, 25);

		btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 270, 350, 120, 45, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, 20);
		// Campo para armazenar o email
		txtEmail = FabricaJText.criarJTextField(100, 135, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, 20);

		// Campo para armazenar a senha
		txtSenha = FabricaJText.criarJPasswordField(100, 220, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, 20);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 100, 260, 460, 40, Color.white, 20);
		try {
			txtData = FabricaJFormatted.criarJFormatted(100, 295, 130, 40, new MaskFormatter("##/##/####"),
					FabricasColors.corTxtField, FabricasColors.corLabelBranca);
		} catch (Exception e) {
		}

		OuvinteBotaoCadastrarTelaADM ouvinte = new OuvinteBotaoCadastrarTelaADM(this);

		// Ouvinte padroes para os botoes
		OuvinteBotaoFundoPreto ouvinteFundoPreto = new OuvinteBotaoFundoPreto();
		btnCadastrar.addActionListener(ouvinte);
		btnCadastrar.addMouseListener(ouvinteFundoPreto);

		background.add(lblDataNascimento);
		background.add(txtData);
		background.add(btnCadastrar);
		background.add(lblTitulo);
		background.add(lblEmail);
		background.add(txtEmail);
		background.add(lblSenha);
		background.add(txtSenha);

	}

	public JFormattedTextField getTxtData() {
		return txtData;
	}

	public void setTxtData(JFormattedTextField txtData) {
		this.txtData = txtData;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
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

	public static void main(String[] args) {
		new TelaDeCadastroADM("Cadastro");
	}

}