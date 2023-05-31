package projeto.telas.MenuAdm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoCadastarTelaCadastrarFornecedor;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJCheckBox;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaCadastrarFornecedor extends TelaPadrao {

	private ImagemDeFundo background;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCNPJ;
	private JTextField txtCPF;
	private JCheckBox JcbPessoaFisica;
	private JCheckBox JcbPessoaJuridica;
	private JButton btnCadastrar;
	private JLabel lblCNPJ;
	private JLabel lblCPF;
	private JButton btnTiposDeServicos;
	private ArrayList<String> servicosDoFornecedor;

	public TelaCadastrarFornecedor(String titulo) {
		super(titulo);
		configTela();
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
	}

	private class OuvinteBotaoTiposDeServicos implements ActionListener {

		private TelaCadastrarFornecedor tela;

		public OuvinteBotaoTiposDeServicos(TelaCadastrarFornecedor tela) {
			this.tela = tela;

		}

		public void actionPerformed(ActionEvent e) {
			Persistencia persistencia = new Persistencia();
			CentralDeInformacoes central = persistencia.recuperarCentral("central");

			ArrayList<String> servicos = central.getServicos();
			String[] servicosArray = servicos.toArray(new String[servicos.size()]);
			JComboBox<String> comboBox = new JComboBox<>(servicosArray);
			JOptionPane.showMessageDialog(null, comboBox, "Selecione um serviço", JOptionPane.QUESTION_MESSAGE);
			String servicoSelecionado = comboBox.getSelectedItem().toString();
			servicosDoFornecedor = new ArrayList<String>();

			for (String s : servicosArray) {
				if (servicoSelecionado != null) {
					servicosDoFornecedor.add(s);
				}
				System.out.println(s);
			}
		}

	}

	public class OuvinteCheckBoxTelaDeCadastrarFornecedor implements ActionListener {

		private TelaCadastrarFornecedor tela;

		public OuvinteCheckBoxTelaDeCadastrarFornecedor(TelaCadastrarFornecedor tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			Object componente = e.getSource();

			boolean JuridicaSelecionada = tela.getJcbPessoaJuridica().isSelected();
			boolean FisicaSelecionada = tela.getJcbPessoaFisica().isSelected();
			ButtonGroup button = new ButtonGroup();
			tela.getLblCPF().setVisible(false);
			tela.getTxtCNPJ().setVisible(false);
			tela.getLblCNPJ().setVisible(false);
			tela.getTxtCPF().setVisible(false);

			button.add(tela.getJcbPessoaFisica());
			button.add(tela.getJcbPessoaJuridica());

			if (JuridicaSelecionada) {
				tela.getLblCNPJ().setVisible(true);
				tela.getTxtCNPJ().setVisible(true);
			} else {
				tela.getTxtCPF().setVisible(true);
				tela.getLblCPF().setVisible(true);
			}
		}

	}

	public void configTela() {
		OuvinteBotaoCadastarTelaCadastrarFornecedor ouvinteCadastrar = new OuvinteBotaoCadastarTelaCadastrarFornecedor(
				this);
		OuvinteBotaoTiposDeServicos ouvinteServicos = new OuvinteBotaoTiposDeServicos(this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		OuvinteCheckBoxTelaDeCadastrarFornecedor ouvinteCheckBox = new OuvinteCheckBoxTelaDeCadastrarFornecedor(this);
		OuvinteBotaoFundoBranco ouvinteBranco = new OuvinteBotaoFundoBranco();
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome", 100, 20, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Telefone", 100, 100, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblTelefone = FabricaJLabel.criarJLabel("Email", 100, 180, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lbTiposDeServico = FabricaJLabel.criarJLabel("Tipos de Servicos", 110, 270, 440, 35,
				FabricasColors.corLabelBranca, 15);

		lblCNPJ = FabricaJLabel.criarJLabel("CNPJ", 430, 280, 460, 40, FabricasColors.corLabelBranca, 20);

		lblCNPJ.setVisible(true);

		lblCPF = FabricaJLabel.criarJLabel("CPF", 430, 340, 460, 40, FabricasColors.corLabelBranca, 20);

		lblCPF.setVisible(true);

		txtCNPJ = FabricaJText.criarJTextField(430, 315, 190, 30, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu CNPJ aqui", 20);

		txtCNPJ.setVisible(true);

		txtCPF = FabricaJText.criarJTextField(430, 375, 190, 30, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu CPF aqui", 20);

		txtCPF.setVisible(true);

		JcbPessoaFisica = FabricaJCheckBox.criarJCheckBox(500, 264, 80, 30, "Fisica", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa fisica");

		JcbPessoaJuridica = FabricaJCheckBox.criarJCheckBox(430, 264, 80, 30, "juridica", FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa juridica");

		btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 290, 400, 90, 40, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);

		txtNome = FabricaJText.criarJTextField(100, 60, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Nome aqui", 20);

		txtTelefone = FabricaJText.criarJTextField(100, 135, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Telefone aqui", 20);

		txtEmail = FabricaJText.criarJTextField(100, 220, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Email aqui", 20);

		btnCadastrar.addActionListener(ouvinteCadastrar);
		btnCadastrar.addMouseListener(ouvinte);

		btnTiposDeServicos = FabricaJButton.criarJButton("Tipos de servicos", 110, 300, 135, 40,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo, "Selecione os tipos de Servicos aqui", 15);
		btnTiposDeServicos.addActionListener(ouvinteServicos);
		btnTiposDeServicos.addMouseListener(ouvinte);

		JcbPessoaFisica.addActionListener(ouvinteCheckBox);
		JcbPessoaFisica.addMouseListener(ouvinteBranco);
		JcbPessoaJuridica.addActionListener(ouvinteCheckBox);
		JcbPessoaJuridica.addMouseListener(ouvinteBranco);

		background.add(lblTelefone);
		background.add(lblEmail);
		background.add(lblNome);
		background.add(lbTiposDeServico);
		background.add(JcbPessoaFisica);
		background.add(JcbPessoaJuridica);
		background.add(txtCNPJ);
		background.add(txtCPF);
		background.add(lblCPF);
		background.add(lblCNPJ);
		background.add(txtNome);
		background.add(txtEmail);
		background.add(txtTelefone);
		background.add(btnCadastrar);
		background.add(btnTiposDeServicos);
	}

	public JButton getBtnTiposDeServicos() {
		return btnTiposDeServicos;
	}

	public void setBtnTiposDeServicos(JButton btnTiposDeServicos) {
		this.btnTiposDeServicos = btnTiposDeServicos;
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	public JTextField getTxtCNPJ() {
		return txtCNPJ;
	}

	public void setTxtCNPJ(JTextField txtCNPJ) {
		this.txtCNPJ = txtCNPJ;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}

	public JCheckBox getJcbPessoaFisica() {
		return JcbPessoaFisica;
	}

	public void setJcbPessoaFisica(JCheckBox jcbPessoaFisica) {
		JcbPessoaFisica = jcbPessoaFisica;
	}

	public JCheckBox getJcbPessoaJuridica() {
		return JcbPessoaJuridica;
	}

	public void setJcbPessoaJuridica(JCheckBox jcbPessoaJuridica) {
		JcbPessoaJuridica = jcbPessoaJuridica;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JLabel getLblCNPJ() {
		return lblCNPJ;
	}

	public void setLblCNPJ(JLabel lblCNPJ) {
		this.lblCNPJ = lblCNPJ;
	}

	public JLabel getLblCPF() {
		return lblCPF;
	}

	public void setLblCPF(JLabel lblCPF) {
		this.lblCPF = lblCPF;
	}

	public ArrayList<String> getServicosDoFornecedor() {
		return servicosDoFornecedor;
	}

	public void setServicosDoFornecedor(ArrayList<String> servicosDoFornecedor) {
		this.servicosDoFornecedor = servicosDoFornecedor;
	}

	public static void main(String[] args) {
		new TelaCadastrarFornecedor("Cadastrar Fornecedor");

	}

}
