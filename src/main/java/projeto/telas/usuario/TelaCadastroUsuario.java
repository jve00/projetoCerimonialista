package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.TelaPadrao;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricaJTextArea;

public class TelaCadastroUsuario extends TelaPadrao{

	private JComboBox<String> cbTipoUsuario;
	private JButton btCriarConta;
	private JButton btCancelar;
	private JTextField inputNome;
	private JTextField inputEmail;
	private JPasswordField inputSenha;
	private JPasswordField inputConfirmacaoSenha;
	private JFormattedTextField inputDataDeNascimento;
	private JComboBox<String> cbSexo;
	
	public TelaCadastroUsuario() {
		super("Tela de Cadastro");
		configurarComponentes();
		setVisible(true);
	}

	public void configurarComponentes() {
		int x = 10;
		Color cor = new Color(0,0,0);
		JLabel lbNome = FabricaJLabel.criarJLabel("NOME COMPLETO:",x,20,134,20,cor,12);
		JTextField txNome = FabricaJText.criarJTextField(x, 40, 350, 30, getForeground(), cor, 12);
		JLabel lbEmail = FabricaJLabel.criarJLabel("EMAIL:",x,75,134,20,cor,12);
		JTextField txEmail = FabricaJText.criarJTextField(x, 95, 350, 30, getForeground(), cor, 12);
		JLabel lbSenha = FabricaJLabel.criarJLabel("SENHA:", x, 130, 134, 20, cor, 12);
		JTextField txSenha = FabricaJText.criarJPasswordField(x, 150, 350, 30, getForeground(), cor, 12);
		JLabel lbConfirmacaoDeSenha = FabricaJLabel.criarJLabel("CONFIRME SUA SENHA:", x, 185, 170, 20, cor, 12);
		JTextField txConfirmacaoDeSenha = FabricaJText.criarJPasswordField(x, 210, 350, 30, getForeground(), cor, 12);
		
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
