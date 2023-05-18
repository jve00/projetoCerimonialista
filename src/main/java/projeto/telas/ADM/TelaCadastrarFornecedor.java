//package projeto.telas.ADM;
//
//import java.awt.Color;
//import java.awt.Font;
//
//import javax.swing.BorderFactory;
//import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//import projeto.OuvinteBotaoFundoPreto;
//import projeto.telas.MenuAdm.ouvintes.OuvinteCheckBoxTelaDeCadastrarFornecedor;
//import ultilidades.fabricas.FabricaJCheckBox;
//import ultilidades.fabricas.FabricaJLabel;
//import ultilidades.fabricas.FabricaJText;
//import ultilidades.fabricas.FabricasColors;
//
//revisar classe por completo e criar logica com o codigo mais limpo
//
//
//
//
//public class TelaCadastrarFornecedor extends TelaCadastrarCliente {
//
//	private JComboBox<String> box;
//	private JLabel lblNome;
//	private JLabel lblCpf;
//	private JLabel lblCnpj;
//	private JTextField txtCnpj;
//	private JTextField txtCpf;
//	private JCheckBox jcbPessoaFisica;
//	private JCheckBox JcbPessoaJuridica;
//
//	public TelaCadastrarFornecedor(String titulo) {
//		super(titulo);
//		configurarComponentes();
//	}
//
//	public void configurarComponentes() {
//		configImagemFundo();
//		configTela();
//	}
//
//	public void configTela() {
//		super.configTela();
//
//		OuvinteCheckBoxTelaDeCadastrarFornecedor ouvinteCheck = new OuvinteCheckBoxTelaDeCadastrarFornecedor(this);
//		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
//
//		lblNome = FabricaJLabel.criarJLabel("Tipo De Servico: ", 20, 260, 460, 40, FabricasColors.corLabelBranca, 15);
//
//		txtCnpj = (JTextField) getTxtCNPJ().add(FabricaJText.criarJTextField(440, 335, 190, 30,
//				FabricasColors.corTxtField, FabricasColors.corLabelBranca, "Digite o seu CNPJ aqui", 20));
//
//		txtCpf = (JTextField) getTxtCNPJ().add(FabricaJText.criarJTextField(440, 395, 190, 30,
//				FabricasColors.corTxtField, FabricasColors.corLabelBranca, "Digite o seu CPF aqui", 20));
//
//		lblCpf = (JLabel) getTxtCNPJ()
//				.add(FabricaJLabel.criarJLabel("CNPJ", 440, 300, 460, 40, FabricasColors.corLabelBranca, 20));
//		lblCnpj = (JLabel) getTxtCNPJ()
//				.add(FabricaJLabel.criarJLabel("CPF", 440, 360, 460, 40, FabricasColors.corLabelBranca, 20));
//
//		jcbPessoaFisica = FabricaJCheckBox.criarJCheckBox(500, 264, 80, 30, "Fisica", FabricasColors.corTxtField,
//				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa fisica");
//		JcbPessoaJuridica = FabricaJCheckBox.criarJCheckBox(430, 264, 80, 30, "juridica", FabricasColors.corTxtField,
//				FabricasColors.corLabelBranca, "clique aqui para selecionar o cliente como pessoa juridica");
//
//		jcbPessoaFisica.addActionListener(ouvinteCheck);
//		jcbPessoaFisica.addMouseListener(ouvinte);
//		JcbPessoaJuridica.addActionListener(ouvinteCheck);
//		JcbPessoaJuridica.addMouseListener(ouvinte);
//
//		box = new JComboBox<String>(new String[] { "Decoracao", "Musica" });
//		box.setBounds(20, 290, 240, 40);
//		box.setFont(new Font("Arial", 1, 20));
//		box.setForeground(Color.white);
//		box.setBackground(Color.BLUE);
//		box.setBorder(BorderFactory.createLineBorder(FabricasColors.CorRoxo));
//		box.setToolTipText("Selecione ate tres tipos de servicos");
//
//		getMeuBackground().add(lblCpf);
//		getMeuBackground().add(lblCnpj);
//		getMeuBackground().add(txtCnpj);
//		getMeuBackground().add(txtCpf);
//		getMeuBackground().add(lblNome);
//		getMeuBackground().add(box);
//
//	}
//
//	public JTextField getTxtCnpj() {
//		return txtCnpj;
//	}
//
//	public void setTxtCnpj(JTextField txtCnpj) {
//		this.txtCnpj = txtCnpj;
//	}
//
//	public JTextField getTxtCpf() {
//		return txtCpf;
//	}
//
//	public void setTxtCpf(JTextField txtCpf) {
//		this.txtCpf = txtCpf;
//	}
//
//	public JCheckBox getJcbPessoaFisica() {
//		return jcbPessoaFisica;
//	}
//
//	public void setJcbPessoaFisica(JCheckBox jcbPessoaFisica) {
//		this.jcbPessoaFisica = jcbPessoaFisica;
//	}
//
//	public JCheckBox getJcbPessoaJuridica() {
//		return JcbPessoaJuridica;
//	}
//
//	public void setJcbPessoaJuridica(JCheckBox jcbPessoaJuridica) {
//		JcbPessoaJuridica = jcbPessoaJuridica;
//	}
//
//	public JComboBox<String> getBox() {
//		return box;
//	}
//
//	public void setBox(JComboBox<String> box) {
//		this.box = box;
//	}
//
//	public static void main(String[] args) {
//		new TelaCadastrarFornecedor("");
//	}
//
//}
