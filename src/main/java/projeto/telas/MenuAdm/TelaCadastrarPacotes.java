package projeto.telas.MenuAdm;

import java.awt.Event;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.TelaPadrao;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

public class TelaCadastrarPacotes extends TelaPadrao{

	private ImagemDeFundo background;
	private JTextField txtNome;
	private JTextField txtfornecedores;
	private JTextField txtservicos;
	private JTextField txtpreco;
	private JTextField txtdetalhe;
	private JButton btnCadastrar;
	
	public TelaCadastrarPacotes(String titulo) {
		super(titulo);
		setVisible(true);
	}
	
	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}
	
	public void configurarComponentes() {
		configImagemFundo();
		configTela();
	}
	
	public void configTela() {
		
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome:", 100, 10, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Fornecedores:", 100, 90, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblTelefone = FabricaJLabel.criarJLabel("Servicos:", 100, 170, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblValor = FabricaJLabel.criarJLabel("Valor:", 100, 270, 70, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblDetalhePacote = FabricaJLabel.criarJLabel("Detalhes do pacote:", 100, 320, 460, 40, FabricasColors.corLabelBranca, 25);
		
		txtNome = FabricaJText.criarJTextField(100, 50, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Nome aqui", 20);
		txtfornecedores = FabricaJText.criarJTextField(100, 125, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite os fornecedores aqui", 20);
		txtservicos = FabricaJText.criarJTextField(100, 210, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite os servicos aqui", 20);
		txtpreco = FabricaJText.criarJTextField(175, 270, 200, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o preco aqui", 20);
		txtdetalhe = FabricaJText.criarJTextField(100, 370, 460, 80, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite os detalhes do pacote aqui", 20);
		
		btnCadastrar = FabricaJButton.criarJButton("Cadastrar Pacote", 380, 270, 200, 40, FabricasColors.corTxtField, FabricasColors.CorRoxo, "Clique aqui para concluir o cadastro", 20);
		
		
		
		background.add(lblNome);
		background.add(lblEmail);
		background.add(lblTelefone);
		background.add(lblValor);
		background.add(lblDetalhePacote);
		background.add(txtNome);
		background.add(txtfornecedores);
		background.add(txtservicos);
		background.add(txtpreco);
		background.add(txtdetalhe);
		background.add(btnCadastrar);
	}

	
	public static void main(String[] args) {
		TelaCadastrarPacotes tela = new TelaCadastrarPacotes("TelaCadastro");
	}
}
