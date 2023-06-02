package projeto.telas.MenuAdm;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.servicos.fornecedores.ouvintes.OuvinteBotaoApagarTelaServicosFornecedores;
import projeto.servicos.fornecedores.ouvintes.OuvinteBotaoEditarTelaServicosFornecedores;
import projeto.servicos.fornecedores.ouvintes.OuvinteBotaoSalvarTelaServicosFornecedores;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.imagens.Imagens;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaServicosFornecedores extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnApagar;
	private JTextField txtServico;
	private JTable tabelaServicos;

	private JScrollPane scrol;
	private DefaultTableModel modelo;
	private ArrayList<String> servicos;

	public TelaServicosFornecedores(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTabelaServicos();
		configTela();
		popularTabela();
	}

	public void configTela() {
		OuvinteBotaoEditarTelaServicosFornecedores ouvinteEditar = new OuvinteBotaoEditarTelaServicosFornecedores(this);
		OuvinteBotaoSalvarTelaServicosFornecedores ouvinteSalvar = new OuvinteBotaoSalvarTelaServicosFornecedores(this);
		OuvinteBotaoApagarTelaServicosFornecedores ouvinteApagar = new OuvinteBotaoApagarTelaServicosFornecedores(this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		JLabel lblNome = FabricaJLabel.criarJLabel("Novo Servico: ", 230, 20, 400, 40, FabricasColors.corLabelBranca,
				25);
		txtServico = FabricaJText.criarJTextField(140, 60, 365, 30, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "digite o servico que vc deseja cadastrar", 20);

		btnSalvar = FabricaJButton.criarJButton("", Imagens.SALVAR, 480, 50, 100, 50,
				"Clique aqui para Cadastrar o novo servico");

		btnEditar = FabricaJButton.criarJButton("Editar", 350, 390, 90, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para editar o servico", 16);
		btnApagar = FabricaJButton.criarJButton("Apagar", 220, 390, 90, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "clique aqui para apagar o servico", 16);

		btnApagar.addActionListener(ouvinteApagar);
		btnApagar.addMouseListener(ouvinte);
		btnEditar.addActionListener(ouvinteEditar);
		btnEditar.addMouseListener(ouvinte);
		btnSalvar.addActionListener(ouvinteSalvar);
		btnSalvar.addMouseListener(ouvinte);

		background.add(lblNome);
		background.add(txtServico);
		background.add(btnSalvar);
		background.add(btnEditar);
		background.add(btnApagar);
	}

	private void configTabelaServicos() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Servicos" });
		tabelaServicos = new JTable(modelo);
		tabelaServicos.setFont(new Font("Arial", 1, 15));
		tabelaServicos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
		tabelaServicos.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaServicos.getTableHeader().setForeground(FabricasColors.CorRoxo);
		scrol = new JScrollPane(tabelaServicos);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(140, 110, 390, 250);

		background.add(scrol);

	}

	public JTable getTabelaServicos() {
		return tabelaServicos;
	}

	public void setTabelaServicos(JTable tabelaServicos) {
		this.tabelaServicos = tabelaServicos;
	}

	private void popularTabela() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		servicos = central.getServicos();
	
		for (String s : servicos) {
			addLinha(modelo, s);
		}
		scrol.repaint();
	}

	private void addLinha(DefaultTableModel modelo, String c) {
		Object[] linhas = new Object[servicos.size()];
		linhas[0] = c;
		modelo.addRow(linhas);
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public JTextField getTxtServico() {
		return txtServico;
	}

	public void setTxtServico(JTextField txtServico) {
		this.txtServico = txtServico;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnApagar() {
		return btnApagar;
	}

	public void setBtnApagar(JButton btnApagar) {
		this.btnApagar = btnApagar;
	}

	public ArrayList<String> getServicos() {
		return servicos;
	}

	public static void main(String[] args) {
		new TelaServicosFornecedores("Cadastrar ou editar Servicos");
	}
}
