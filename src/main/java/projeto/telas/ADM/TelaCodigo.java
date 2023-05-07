package projeto.telas.ADM;

import javax.swing.JButton;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteBotaoEnviarTelaCodigo;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

public class TelaCodigo extends TelaPadrao {

	private JButton btnEnviar;
	private JTextField txtEmail;
	private ImagemDeFundo background;

	public TelaCodigo(String titulo) {
		super(titulo);
		setVisible(true);
	}

	private void configImagemFundo() {
		background = super.configImagemFundo("background.jpg");
		add(background);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configFormEmail();
	}

	public void configFormEmail() {
		txtEmail = FabricaJText.criarJTextField(120, 300, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, 16);
		txtEmail.setToolTipText("digite o seu email aqui");
		btnEnviar = FabricaJButton.criarJButton("Enviar", 295, 360, 120, 45, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, 20);

		OuvinteBotaoEnviarTelaCodigo ouvinte = new OuvinteBotaoEnviarTelaCodigo(this);
		OuvinteBotaoFundoPreto ouvinteBotaoPadrao = new OuvinteBotaoFundoPreto();
		btnEnviar.addActionListener(ouvinte);
		btnEnviar.addMouseListener(ouvinteBotaoPadrao);

		background.add(txtEmail);
		background.add(btnEnviar);
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public static void main(String[] args) {
		new TelaCodigo("Esqueceu senha");
	}

}
