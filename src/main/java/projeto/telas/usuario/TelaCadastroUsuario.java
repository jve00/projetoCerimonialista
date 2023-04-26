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
		configurarTela();
		setVisible(true);
	}
	
	private void configurarTela() {
		Color corTxtField = new Color(179, 177, 177, 110);
		JLabel txNome = FabricaJLabel.criarJLabel("Nome Completo",100, 100, 100, 100, corTxtField, 25);
		
	}

	@Override
	public void configurarComponentes() {
	}
	
	public static void main(String[] args) {
		new TelaCadastroUsuario();
	}
	
}
