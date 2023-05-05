package projeto.telas.ADM;

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
import ultilidades.fabricas.FabricasColors;

//Classe da Tela de cadastro
public class TelaCadastroUsuario extends TelaPadrao {
	
	//Atributos unicos para a Tela de cadastro
	private ImagemDeFundo background;;
	private JFormattedTextField txtData;

	//Instancia��o da tela
	public TelaCadastroUsuario() {
		super("Tela de Cadastro");
		configurarComponentes();
		configImagemFundo();
		setVisible(true);
	}
	
	//Fun��o para adicionar uma imagem de fundo (background)
	private void configImagemFundo() {
		background = super.configImagemFundo("imgTelaUsuario.png");
		this.add(background);
	}
	
	//Fun��o para configurar e adicionar os componentes a tela
	public void configurarComponentes() {
		//valor padr�o para alinhamento dos objetos
		int x = 10;
		
		//valor padr�o para cor
		Color cor = new Color(0, 0, 0);
		
		//valor padr�o de cor
		Color corTxtField = new Color(179, 177, 177, 50);
		
		//Adesivo "Nome Completo" e caixa para armazenar string
		JLabel lbNome = FabricaJLabel.criarJLabel("NOME COMPLETO:", x, 60, 134, 20, cor, 12);
		JTextField txNome = FabricaJText.criarJTextField(x, 80, 350, 30, corTxtField, cor, 17);
		
		//Adesivo "Email" e caixa para armazenar
		JLabel lbEmail = FabricaJLabel.criarJLabel("EMAIL:", x, 115, 134, 20, cor, 12);
		JTextField txEmail = FabricaJText.criarJTextField(x, 135, 350, 30, corTxtField, cor, 17);
		
		//Adesivo "Senha" e caixa para armazenar
		JLabel lbSenha = FabricaJLabel.criarJLabel("SENHA:", x, 165, 134, 20, cor, 12);
		JTextField txSenha = FabricaJText.criarJPasswordField(x, 185, 350, 30, corTxtField, cor, 12);
		
		//Adesivo "Confirmar senha" e caixa para armazenar
		JLabel lbConfirmacaoDeSenha = FabricaJLabel.criarJLabel("CONFIRME SUA SENHA:", x, 225, 170, 20, cor, 12);
		JTextField txConfirmacaoDeSenha = FabricaJText.criarJPasswordField(x, 245, 350, 30, corTxtField, cor, 17);

		//Adesivo "Data de nascimento" e o lugar para armazenar
		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("DATA DE NASCIMENTO:", x, 280, 170, 20, cor, 12);
		
		//Cria��o da caixa para armazenar a data em formato DD/MM/YYYY
		try {
			txtData = FabricaJFormatted.criarJFormatted(x, 305, 120, 40, new MaskFormatter("##/##/####"), FabricasColors.corTxtField,
					FabricasColors.corLabelBranca);
		} catch (Exception e) {
		}
		
		//Bot�o cadastrar
		JButton btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 390, 150, 45, Color.white, Color.black, 12);

		//Bot�o cancelar
		JButton btnCancelar = FabricaJButton.criarJButton("Cancelar", 370, 390, 150, 45, Color.white, Color.black, 12);
		
		//adicionando os elemnetos a tela
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
		this.add(lblDataNascimento);
		this.add(btnCadastrar);
		this.add(btnCancelar);
	}
	
	//Teste de tela
	
	public static void main(String[] args) {
		new TelaCadastroUsuario();
	}
	
}
