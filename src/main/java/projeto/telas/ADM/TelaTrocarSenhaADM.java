package projeto.telas.ADM;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.telas.ADM.ouvintes.OuvinteTelaTrocarSenhaADM;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

public class TelaTrocarSenhaADM extends TelaLogin {

	private ImagemDeFundo background;
	private JTextField txtEmail;
	private JPasswordField txtNovaSenha;
	private JPasswordField txtConfirmarSenha;
	private JButton btnConfirmar;

	public TelaTrocarSenhaADM(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTelaGeral();
	}

	public void configTelaGeral() {
		JLabel lblRedefinirSenha = FabricaJLabel.criarJLabel("Redefinir Senha", 225, 50, 460, 40,
				FabricasColors.corLabelBranca, 30);

		JLabel lblNovaSenha = FabricaJLabel.criarJLabel("Nova Senha", 110, 125, 460, 40, FabricasColors.corLabelBranca,
				20);
		JLabel lblConfirmarSenha = FabricaJLabel.criarJLabel("Confirmar sua senha", 110, 210, 460, 40,
				FabricasColors.corLabelBranca, 20);

		txtNovaSenha = FabricaJText.criarJPasswordField(110, 160, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, 20);
		txtConfirmarSenha = FabricaJText.criarJPasswordField(110, 245, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, 20);
		btnConfirmar = FabricaJButton.criarJButton("Confirmar", 270, 320, 120, 45, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, 20);

		OuvinteTelaTrocarSenhaADM ouvinteSenha = new OuvinteTelaTrocarSenhaADM(this);
		OuvinteBotaoFundoPreto ouvinteBotaoPadrao = new OuvinteBotaoFundoPreto();
		btnConfirmar.addActionListener(ouvinteSenha);
		btnConfirmar.addMouseListener(ouvinteBotaoPadrao);

		background.add(lblRedefinirSenha);
		background.add(lblNovaSenha);
		background.add(lblConfirmarSenha);
		background.add(txtNovaSenha);
		background.add(txtConfirmarSenha);
		background.add(btnConfirmar);
	}

	public static void main(String[] args) {
		new TelaTrocarSenhaADM("Mudar De Senha");
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getTxtNovaSenha() {
		return txtNovaSenha;
	}

	public void setTxtNovaSenha(JPasswordField txtNovaSenha) {
		this.txtNovaSenha = txtNovaSenha;
	}

	public JPasswordField getTxtConfirmarSenha() {
		return txtConfirmarSenha;
	}

	public void setTxtConfirmarSenha(JPasswordField txtConfirmarSenha) {
		this.txtConfirmarSenha = txtConfirmarSenha;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

}
