package projeto.telas.ADM;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteBotaoEnviarTelaCodigo;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.fabricas.FabricasDeVariaveis;

public class TelaCodigo extends TelaPadrao {

	private JButton btnEnviar;
	private JTextField txtEmail;
	private ImagemDeFundo background;
	private JButton btnSeta;
	OuvinteBotaoEnviarTelaCodigo ouvinte = new OuvinteBotaoEnviarTelaCodigo(this);
	
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
//		a seta n esta aparecendo na tela, concertar isso ai
//		btnSeta = FabricaJButton.criarJButton("", FabricasDeVariaveis.SETA, 10, 10, 50, 50);
//		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
//		btnSeta.addActionListener(ouvinte);
//		
		txtEmail = FabricaJText.criarJTextField(120, 300, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, 16);
		txtEmail.setToolTipText("digite o seu email aqui");
		btnEnviar = FabricaJButton.criarJButton("Enviar", 295, 360, 120, 45, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, 20);

		OuvinteBotaoFundoPreto ouvinteBotaoPadrao = new OuvinteBotaoFundoPreto();
		btnEnviar.addActionListener(ouvinte);
		btnEnviar.addMouseListener(ouvinteBotaoPadrao);

		background.add(txtEmail);
		background.add(btnEnviar);
//		background.add(btnSeta);
	
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
