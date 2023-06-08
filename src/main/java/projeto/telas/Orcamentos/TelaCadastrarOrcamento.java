package projeto.telas.Orcamentos;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import ultilidades.fabricas.FabricaJFormatted;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;

public class TelaCadastrarOrcamento extends TelaPadrao {

	private ImagemDeFundo background;
	private JTextField txtNomeDoCliente;
	private JTextField txtEvento;
	private JTextField txtLocacao;
	private JTextField txtTamanho;
	private JLabel lblChooser;
	private JDateChooser chooser;
	private JFormattedTextField txtHora;

	public TelaCadastrarOrcamento(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configurarDateChooser();
		configTela();
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);

	}
	private void configurarDateChooser() {
		chooser = new JDateChooser(new Date());
		lblChooser = new JLabel();
		lblChooser.setLayout(null);
		lblChooser.setBounds(285, 150, 200, 40);
		chooser.setBounds(40, 10, 152, 25);
		chooser.setForeground(Color.black);
		chooser.setFont(new Font("Arial", 1, 13));

		lblChooser.add(chooser);
	}
	public void configTela() {

		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		JLabel lblTitulo = FabricaJLabel.criarJLabel("Cadastrar Orcamento", 180, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel lblNomeDoCliente = FabricaJLabel.criarJLabel("Nome do Cliente:", 100, 70, 200, 25,
				FabricasColors.corLabelBranca, 20);
		JLabel lblEvento = FabricaJLabel.criarJLabel("Evento: ", 100, 100, 100, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblLocacao = FabricaJLabel.criarJLabel("Locaocao:", 100, 130, 100, 25, FabricasColors.corLabelBranca,
				20);
		JLabel lblTamanho = FabricaJLabel.criarJLabel("Tamanho: ", 100, 160, 250, 25, FabricasColors.corLabelBranca,
				20);
		JLabel lblData = FabricaJLabel.criarJLabel("Data: ", 270, 160, 250, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora: ", 100, 200, 250, 25, FabricasColors.corLabelBranca, 20);

		txtNomeDoCliente = FabricaJText.criarJTextField(265, 70, 282, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o nome do Cliente aqui", 16);
		txtEvento = FabricaJText.criarJTextField(200, 100, 347, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o nome do Evento aqui", 16);

		txtLocacao = FabricaJText.criarJTextField(200, 130, 347, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite ", 16);

		txtTamanho = FabricaJText.criarJTextField(200, 160, 50, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite para quantas pessoas o evento sera fornecido", 16);
		try {
			txtHora = FabricaJFormatted.criarJFormatted(165, 195, 80, 35, new MaskFormatter("##:##"),
					FabricasColors.corTxtField, FabricasColors.corLabelBranca, "Digite a hora do Evento aqui");
		} catch (Exception e) {
		}
//		btnEditar = FabricaJButton.criarJButton("Editar", 230, 410, 90, 30, FabricasColors.corLabelBranca,
//				FabricasColors.CorRoxo, "Clique aqui para editar o servico", 16);
//		btnSalvar = FabricaJButton.criarJButton("Salvar", 350, 410, 90, 30, FabricasColors.corLabelBranca,
//				FabricasColors.CorRoxo, "Clique aqui para editar o servico", 16);
//
//		btnAlterar = FabricaJButton.criarJButton("Alterar Servico", 420, 250, 130, 30, FabricasColors.corLabelBranca,
//				FabricasColors.CorRoxo, "Clique aqui para editar o servico", 16);
//
//		// se for juridica não pode mudar para fisica, e se for fisica pode mudar pra
//		// juridica
//
//		rdPessoaJuridica = FabricaJRadionButton.criarRadionButton("Pessoa Juridica", 149, 272, 140, 25,
//				FabricasColors.corLabelBranca, "Clique aqui para selecionar o tipo Pessoa Juridica", 15);
//		rdAtivo = FabricaJRadionButton.criarRadionButton("Ativo", 100, 350, 70, 25, FabricasColors.corLabelBranca,
//				"Clique aqui para selecionar o tipo Pessoa Juridica", 15);
//		rdDesativado = FabricaJRadionButton.criarRadionButton("Desativado", 180, 350, 110, 25,
//				FabricasColors.corLabelBranca, "Clique aqui para selecionar o tipo Pessoa Juridica", 15);
//		rdBloqueado = FabricaJRadionButton.criarRadionButton("Bloqueado", 300, 350, 100, 25,
//				FabricasColors.corLabelBranca, "Clique aqui para selecionar o tipo Pessoa Juridica", 15);
//		txtCNPJ = FabricaJText.criarJTextField(160, 300, 250, 25, FabricasColors.corTxtField,
//				FabricasColors.corLabelBranca, "Digite seu CNPJ aqui", 16);
//
//		lblSituacao = FabricaJLabel.criarJLabel("Situacao do fornecedor: ", 100, 320, 460, 40,
//				FabricasColors.corLabelBranca, 15);
		background.add(lblTitulo);
		background.add(lblNomeDoCliente);
		background.add(lblEvento);
		background.add(lblLocacao);
		background.add(lblTamanho);
		background.add(lblData);
		background.add(lblHora);
		background.add(txtNomeDoCliente);
		background.add(txtEvento);
		background.add(txtLocacao);
		background.add(txtTamanho);
		background.add(lblChooser);
		background.add(txtHora);
	}

	public static void main(String[] args) {
		new TelaCadastrarOrcamento("");
	}

	public JTextField getTxtNomeDoCliente() {
		return txtNomeDoCliente;
	}

	public JTextField getTxtEvento() {
		return txtEvento;
	}

	public JTextField getTxtLocacao() {
		return txtLocacao;
	}

	public JTextField getTxtTamanho() {
		return txtTamanho;
	}

	public JFormattedTextField getTxtHora() {
		return txtHora;
	}

}
