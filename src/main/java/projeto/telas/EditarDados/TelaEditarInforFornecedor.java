package projeto.telas.EditarDados;

import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.TelaPadrao;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

public class TelaEditarInforFornecedor extends TelaPadrao {
	
	private ImagemDeFundo background;
	private JLabel lblNomeDoFornecedor;

	public TelaEditarInforFornecedor(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTela();
		
	}
	
	public void configImagemFundo() {

		background = super.configImagemFundo("background.png");
		add(background);

	}
	
	public void configTela() {
		
		JLabel lblTitulo = FabricaJLabel.criarJLabel("Editar Perfil do Fornecedor", 210, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel lblNomeDoFornecedor = FabricaJLabel.criarJLabel("Nome:", 20, 70, 100, 25,
				FabricasColors.corLabelBranca, 20);
		JLabel lblEmail = FabricaJLabel.criarJLabel("E - mail:", 20, 100, 100, 25,
				FabricasColors.corLabelBranca, 20);
		JLabel lblServicos = FabricaJLabel.criarJLabel("Serviços:", 20, 130, 100, 25,
				FabricasColors.corLabelBranca, 20);
		JLabel lblTipo = FabricaJLabel.criarJLabel("Tipo:", 20,270, 100, 25,
				FabricasColors.corLabelBranca, 20);
		JLabel lblFeedback = FabricaJLabel.criarJLabel("Feedback:", 20, 300, 100, 25,
				FabricasColors.corLabelBranca, 20);
		
		JTextField txtNome = FabricaJText.criarJTextField(110, 70, 300, 25, FabricasColors.corTxtField, 
				FabricasColors.corLabelBranca, "Digite seu nome aqui", 16);
		JTextField txtEmail = FabricaJText.criarJTextField(110, 100, 300, 25, FabricasColors.corTxtField, 
				FabricasColors.corLabelBranca, "Digite seu e-mail aqui", 16);
		JTextField txtServicos = FabricaJText.criarJTextField(110, 130, 300, 25, FabricasColors.corTxtField, 
				FabricasColors.corLabelBranca, "Digite o serviço aqui", 16);
		
		// se for juridica não pode mudar para fisica, e se for fisica pode mudar pra juridica

		JTextField txtTipo = FabricaJText.criarJTextField(110, 270, 300, 25, FabricasColors.corTxtField, 
				FabricasColors.corLabelBranca, " ", 16);
		
		JTextField txtFeedback = FabricaJText.criarJTextField(110, 323, 300, 25, FabricasColors.corTxtField, 
				FabricasColors.corLabelBranca, "Nome", 16);
		
		background.add(lblTitulo);
		background.add(lblNomeDoFornecedor);
		background.add(txtNome);
		background.add(lblEmail);
		background.add(txtEmail);
		background.add(lblServicos);
		background.add(txtServicos);
		background.add(lblTipo);
		background.add(txtTipo);
		background.add(lblFeedback);
		background.add(txtFeedback);
	}
	public static void main(String[] args) {
		new TelaEditarInforFornecedor("Tela Editar Fornecedor ");
	}
	

}
