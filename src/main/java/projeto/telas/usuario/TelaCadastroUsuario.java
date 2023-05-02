package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.TelaPadrao;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJFormatted;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;

public class TelaCadastroUsuario extends TelaPadrao {

	
	private JComboBox<String> cbTipoUsuario;
	private JButton btCriarConta;
	private JButton btCancelar;
	private JTextField inputNome;
	private JTextField inputEmail;
	private JPasswordField inputSenha;
	private JPasswordField inputConfirmacaoSenha;
	private JFormattedTextField inputDataDeNascimento;
	private JComboBox<String> cbSexo;
	private ImagemDeFundo background;;
	private JFormattedTextField txtData;

	public TelaCadastroUsuario() {
		super("Tela de Cadastro");
		configurarComponentes();
		configImagemFundo();
		setVisible(true);
	}
	private void configImagemFundo() {
		background = super.configImagemFundo("imgTelaUsuario.png");
		this.add(background);
	}
	public void configurarComponentes() {
		int x = 10;
		Color cor = new Color(0, 0, 0);
		Color corTxtField = new Color(179, 177, 177, 50);
		JLabel lbNome = FabricaJLabel.criarJLabel("NOME COMPLETO:", x, 60, 134, 20, cor, 12);
		JTextField txNome = FabricaJText.criarJTextField(x, 80, 350, 30, corTxtField, cor, 17);
		JLabel lbEmail = FabricaJLabel.criarJLabel("EMAIL:", x, 115, 134, 20, cor, 12);
		JTextField txEmail = FabricaJText.criarJTextField(x, 135, 350, 30, corTxtField, cor, 17);
		JLabel lbSenha = FabricaJLabel.criarJLabel("SENHA:", x, 165, 134, 20, cor, 12);
		JTextField txSenha = FabricaJText.criarJPasswordField(x, 185, 350, 30, corTxtField, cor, 12);
		JLabel lbConfirmacaoDeSenha = FabricaJLabel.criarJLabel("CONFIRME SUA SENHA:", x, 225, 170, 20, cor, 12);
		JTextField txConfirmacaoDeSenha = FabricaJText.criarJPasswordField(x, 245, 350, 30, corTxtField, cor, 17);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 20, 315, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(x, 290, 350, 40, new MaskFormatter("##/##/####"), corTxtField,
					cor, 12);
		} catch (Exception e) {
		}
		JButton btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 450, 150, 45, Color.white, Color.black, 8);

		this.add(btnCadastrar);
		this.add(txtData);
		this.add(lbNome);
		this.add(lbEmail);
		this.add(txNome);
		this.add(txEmail);
		this.add(lbSenha);
		this.add(txSenha);
		this.add(lbConfirmacaoDeSenha);
		this.add(txConfirmacaoDeSenha);
	}
	public static void main(String[] args) {
		new TelaCadastroUsuario();
	}
	public JComboBox<String> getCbTipoUsuario() {
		return cbTipoUsuario;
	}
	public void setCbTipoUsuario(JComboBox<String> cbTipoUsuario) {
		this.cbTipoUsuario = cbTipoUsuario;
	}
	public JButton getBtCriarConta() {
		return btCriarConta;
	}
	public void setBtCriarConta(JButton btCriarConta) {
		this.btCriarConta = btCriarConta;
	}
	public JButton getBtCancelar() {
		return btCancelar;
	}
	public void setBtCancelar(JButton btCancelar) {
		this.btCancelar = btCancelar;
	}
	public JTextField getInputNome() {
		return inputNome;
	}
	public void setInputNome(JTextField inputNome) {
		this.inputNome = inputNome;
	}
	public JTextField getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(JTextField inputEmail) {
		this.inputEmail = inputEmail;
	}

	public JPasswordField getInputSenha() {
		return inputSenha;
	}

	public void setInputSenha(JPasswordField inputSenha) {
		this.inputSenha = inputSenha;
	}

	public JPasswordField getInputConfirmacaoSenha() {
		return inputConfirmacaoSenha;
	}

	public void setInputConfirmacaoSenha(JPasswordField inputConfirmacaoSenha) {
		this.inputConfirmacaoSenha = inputConfirmacaoSenha;
	}

	public JFormattedTextField getInputDataDeNascimento() {
		return inputDataDeNascimento;
	}

	public void setInputDataDeNascimento(JFormattedTextField inputDataDeNascimento) {
		this.inputDataDeNascimento = inputDataDeNascimento;
	}

	public JComboBox<String> getCbSexo() {
		return cbSexo;
	}

	public void setCbSexo(JComboBox<String> cbSexo) {
		this.cbSexo = cbSexo;
	}
}
