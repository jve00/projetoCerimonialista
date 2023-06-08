package projeto.telas.EditarDados;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelos.Fornecedor;
import projeto.modelos.FornecedorJuridico;
import projeto.telas.ListarFornecedores.TelaListarFornecedores;
import servico.permissao.edit.Editar;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricaJRadionButton;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaEditarInforFornecedor extends TelaPadrao {

	private ImagemDeFundo background;
	private JRadioButton rdPessoaJuridica;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private JTable tabelaServicos;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");
	private JTextArea txtAreaFeedback;
	private JTextField txtEmail;
	private JTextField txtNome;
	private Fornecedor fornecedor;
	private JLabel lblCNPJ;
	private JTextField txtCNPJ;
	private JButton btnEditar;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JLabel lblTitulo;
	private JLabel lblNomeDoFornecedor;
	private JLabel lblEmail;
	private JLabel lblTipo;
	private JRadioButton rdAtivo;
	private JRadioButton rdDesativado;
	private JRadioButton rdBloqueado;
	private JLabel lblSituacao;

	public TelaEditarInforFornecedor(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTela();
		configTabela();
		popularTabelaFornecedor();

	}

	public void configImagemFundo() {

		background = super.configImagemFundo("background.png");
		add(background);

	}

	public void popularTabelaFornecedor() {
		p = new Persistencia();
		central = p.recuperarCentral("central");
		fornecedor = central.getTodoOsFornecedores().get(TelaListarFornecedores.getLinhaSelecionada());
		for (String f : fornecedor.getTipoDeServicos()) {
			addLinha(modelo, f);
		}
		scrol.repaint();
	}

	private void addLinha(DefaultTableModel modelo, String f) {
		Object[] linhas = new Object[fornecedor.getTipoDeServicos().size()];
		linhas[0] = f;
		modelo.addRow(linhas);
	}

	private void configTabela() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Servicos: " });
		tabelaServicos = new JTable(modelo);
		tabelaServicos.setFont(new Font("Arial", 1, 15));
		tabelaServicos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaServicos.getTableHeader().setBackground(FabricasColors.CorRoxo);
		tabelaServicos.getTableHeader().setForeground(FabricasColors.CorRoxo);
		tabelaServicos.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
		scrol = new JScrollPane(tabelaServicos);
		scrol.getViewport().setBackground(FabricasColors.corTxtField);
		scrol.setBounds(100, 130, 450, 120);

		background.add(scrol);

	}

	public class OuvinteBotaoEditar implements ActionListener {

		private TelaEditarInforFornecedor tela;

		public OuvinteBotaoEditar(TelaEditarInforFornecedor tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			Persistencia persistencia = new Persistencia();
			CentralDeInformacoes central = persistencia.recuperarCentral("central");
			Object componente = e.getSource();
			int linhaSelecionada = 0;
			String edit;
			String cnpj = "";
			String nome = tela.getTxtNome().getText();
			String emailDoFornecedor = tela.getTxtEmail().getText();
			String emailSelecionado = (String) TelaListarFornecedores.getTabelaFornecedores()
					.getValueAt(TelaListarFornecedores.getLinhaSelecionada(), 3);
			Fornecedor fornecedorRecuperado = central.recuperarFornecedorPorEmail(emailSelecionado);
			if (tela.getBtnEditar() == componente) {
				Editar.ativarComponentes(tela, true);
				TelaListarFornecedores.getTabelaFornecedores().repaint();
			}
			if (tela.getBtnAlterar() == componente) {
				if (linhaSelecionada == -1) {
					FabricaJOptionPane.criarMsg("Selecione uma linha");
				} else {
					edit = FabricaJOptionPane.criarInput("edite o serviço aqui");
					FabricaJOptionPane.criarMsg("Servico editado com sucesso.");
					fornecedorRecuperado.getTipoDeServicos().set(linhaSelecionada, edit);
					tela.getTabelaServicos().repaint();
					p.salvarCentral(central, "central");
				}
			}
			if (tela.getBtnSalvar() == componente) {
				fornecedorRecuperado.setNome(nome);
				fornecedorRecuperado.setEmail(emailDoFornecedor);
				if (tela.getRdAtivo().isSelected()) {
					fornecedorRecuperado.setSituacaoDoFornecedor(true);
					p.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Dados editado com sucesso");
					tela.dispose();
				}
				if (tela.getRdDesativado().isSelected()) {
					fornecedorRecuperado.setSituacaoDoFornecedor(false);
					p.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Dados editado com sucesso");
					tela.dispose();
				} else if (tela.getRdBloqueado().isSelected()) {
					String comentario = FabricaJOptionPane.criarInput("Digite um comentario a respeito do fornecedor");
					fornecedorRecuperado.setSituacaoDoFornecedor(false);
					fornecedorRecuperado.setFeedback(comentario);
					p.salvarCentral(central, "central");
					tela.dispose();
					FabricaJOptionPane.criarMsg("Dados editado com sucesso");
				} else if (tela.getRdPessoaJuridica().isSelected()) {
					cnpj = tela.getTxtCNPJ().getText();
					DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaServicos().getModel();
					try {
						boolean fornecedorValido = Validador.validarCadastro(nome, emailDoFornecedor, cnpj);
						if (fornecedorValido) {
							central.getTodoOsFornecedores().remove(fornecedorRecuperado);
							tela.getTabelaServicos().repaint();
							central.adicionarFornecedor(new FornecedorJuridico(fornecedorRecuperado.getNome(),
									fornecedorRecuperado.getTelefone(), fornecedorRecuperado.getEmail(),
									"PESSOAJURIDICA", Long.parseLong(cnpj), fornecedorRecuperado.getTipoDeServicos(),
									true));
							p.salvarCentral(central, "central");
							FabricaJOptionPane.criarMsg("Dados editado com sucesso");
							tela.dispose();
							new TelaListarFornecedores("Listagem de fornecedores");
						}
					} catch (Exception e1) {
						FabricaJOptionPane.criarMsgErro(e1.getMessage());
					}
				}
			}
		}
	}
	public void configTela() {
		OuvinteBotaoEditar ouvinteEditar = new OuvinteBotaoEditar(this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		lblTitulo = FabricaJLabel.criarJLabel("Editar Perfil do Fornecedor", 180, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);
		lblNomeDoFornecedor = FabricaJLabel.criarJLabel("Nome:", 100, 70, 100, 25, FabricasColors.corLabelBranca, 20);
		lblEmail = FabricaJLabel.criarJLabel("Email: ", 100, 100, 100, 25, FabricasColors.corLabelBranca, 20);

		lblTipo = FabricaJLabel.criarJLabel("Tipo:", 100, 270, 100, 25, FabricasColors.corLabelBranca, 20);
		lblCNPJ = FabricaJLabel.criarJLabel("CNPJ: ", 100, 300, 250, 25, FabricasColors.corLabelBranca, 20);

		txtNome = FabricaJText.criarJTextField(200, 70, 347, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite seu nome aqui", 16);
		txtEmail = FabricaJText.criarJTextField(200, 100, 347, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite seu e-mail aqui", 16);
		btnEditar = FabricaJButton.criarJButton("Editar", 230, 410, 90, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para editar o servico", 16);
		btnSalvar = FabricaJButton.criarJButton("Salvar", 350, 410, 90, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para editar o servico", 16);

		btnAlterar = FabricaJButton.criarJButton("Alterar Servico", 420, 250, 130, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para editar o servico", 16);

		// se for juridica não pode mudar para fisica, e se for fisica pode mudar pra
		// juridica

		rdPessoaJuridica = FabricaJRadionButton.criarRadionButton("Pessoa Juridica", 149, 272, 140, 25,
				FabricasColors.corLabelBranca, "Clique aqui para selecionar o tipo Pessoa Juridica", 15);
		rdAtivo = FabricaJRadionButton.criarRadionButton("Ativo", 100, 350, 70, 25, FabricasColors.corLabelBranca,
				"Clique aqui para selecionar o tipo Pessoa Juridica", 15);
		rdDesativado = FabricaJRadionButton.criarRadionButton("Desativado", 180, 350, 110, 25,
				FabricasColors.corLabelBranca, "Clique aqui para selecionar o tipo Pessoa Juridica", 15);
		rdBloqueado = FabricaJRadionButton.criarRadionButton("Bloqueado", 300, 350, 100, 25,
				FabricasColors.corLabelBranca, "Clique aqui para selecionar o tipo Pessoa Juridica", 15);
		txtCNPJ = FabricaJText.criarJTextField(160, 300, 250, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite seu CNPJ aqui", 16);

		lblSituacao = FabricaJLabel.criarJLabel("Situacao do fornecedor: ", 100, 320, 460, 40,
				FabricasColors.corLabelBranca, 15);

		btnEditar.addActionListener(ouvinteEditar);
		btnEditar.addMouseListener(ouvinte);
		btnSalvar.addActionListener(ouvinteEditar);
		btnSalvar.addMouseListener(ouvinte);
		btnAlterar.addActionListener(ouvinteEditar);
		btnAlterar.addMouseListener(ouvinte);

		background.add(btnEditar);
		background.add(lblTitulo);
		background.add(lblNomeDoFornecedor);
		background.add(lblEmail);
		background.add(lblTipo);
		background.add(lblCNPJ);
		background.add(txtNome);
		background.add(txtEmail);
		background.add(rdPessoaJuridica);
		background.add(txtCNPJ);
		background.add(btnSalvar);
		background.add(btnAlterar);
		background.add(lblSituacao);
		background.add(rdAtivo);
		background.add(rdBloqueado);
		background.add(rdDesativado);
	}

	public static void main(String[] args) {
		new TelaEditarInforFornecedor("Tela Editar Dados");
	}

	public JRadioButton getRdPessoaJuridica() {
		return rdPessoaJuridica;
	}

	public JTable getTabelaServicos() {
		return tabelaServicos;
	}

	public JTextArea getTxtAreaFeedback() {
		return txtAreaFeedback;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setRdPessoaJuridica(JRadioButton rdPessoaJuridica) {
		this.rdPessoaJuridica = rdPessoaJuridica;
	}

	public void setTabelaServicos(JTable tabelaServicos) {
		this.tabelaServicos = tabelaServicos;
	}

	public void setTxtAreaFeedback(JTextArea txtAreaFeedback) {
		this.txtAreaFeedback = txtAreaFeedback;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JLabel getLblCNPJ() {
		return lblCNPJ;
	}

	public JTextField getTxtCNPJ() {
		return txtCNPJ;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public JLabel getLblNomeDoFornecedor() {
		return lblNomeDoFornecedor;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public JRadioButton getRdAtivo() {
		return rdAtivo;
	}

	public JRadioButton getRdDesativado() {
		return rdDesativado;
	}

	public JRadioButton getRdBloqueado() {
		return rdBloqueado;
	}

}
