        package projeto.telas.ListarFornecedores;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import projeto.modelos.Fornecedor;
import projeto.telas.EditarDados.TelaEditarInforFornecedor;
import servico.permissao.edit.Editar;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaListarFornecedores extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnDetalhes;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private static JTable tabelaFornecedores;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");
	private JTextField txtFiltro;
	private static int linhaSelecionada;

	public TelaListarFornecedores(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTela();
		configTabela();
		configTexto();
		popularTabelaFornecedor();

	}

	private class OuvinteFiltro implements KeyListener {

		private TelaListarFornecedores tela;

		private ArrayList<Fornecedor> todosOsFornecedores;

		public void keyTyped(KeyEvent e) {
			todosOsFornecedores = new ArrayList<>();
			p = new Persistencia();
			central = p.recuperarCentral("central");

			for (Fornecedor f : central.getTodoOsFornecedores()) {
				todosOsFornecedores.add(f);
			}
			String filtro = txtFiltro.getText();
			char var = e.getKeyChar();
			if (Character.isAlphabetic(var) || Character.isDigit(var)) {
				filtro += var;
			} else if (Character.isWhitespace(var)) {
				e.consume();
				return;
			}
			modelo.setRowCount(0);
			for (Fornecedor f : todosOsFornecedores) {
				if (f.getTipo().contains(filtro)) {
					addLinha(modelo, f);
				} else if (f.getNome().contains(filtro)) {
					addLinha(modelo, f);
				}
			}
			scrol.repaint();
		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}
	}

	public void popularTabelaFornecedor() {
		p = new Persistencia();
		central = p.recuperarCentral("central");

		for (Fornecedor f : central.getTodoOsFornecedores()) {
			addLinha(modelo, f);
		}
		scrol.repaint();
	}

	private void addLinha(DefaultTableModel modelo, Fornecedor f) {
		Object[] linhas = new Object[4];
		linhas[0] = f.getNome();
		linhas[1] = f.getTipo();
		linhas[2] = f.getTipoDeServicos();
		linhas[3] = f.getEmail();
		modelo.addRow(linhas);
	}

	private void configTabela() {

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Fornecedor", "Tipo ", "Servicos", "E-Mail" });
		tabelaFornecedores = new JTable(modelo);
		tabelaFornecedores.setFont(new Font("Arial", 1, 15));
		tabelaFornecedores.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaFornecedores.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaFornecedores.getTableHeader().setForeground(FabricasColors.CorRoxo);
		tabelaFornecedores.setAutoCreateRowSorter(true);
		scrol = new JScrollPane(tabelaFornecedores);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(60, 120, 580, 260);
		background.add(scrol);

	}

	private void configTexto() {
		txtFiltro = FabricaJText.criarJTextField(60, 90, 300, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Física", 16);
		txtFiltro.addKeyListener(new OuvinteFiltro());
		background.add(txtFiltro);
	}

	public void configTela() {
		OuvinteFiltro ouvinteFiltro = new OuvinteFiltro();
		OuvinteBotaoDetalhesTelaListarFornecedores ouvinteDetalhes = new OuvinteBotaoDetalhesTelaListarFornecedores(
				this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		JLabel lblListaDeFornecedores = FabricaJLabel.criarJLabel("Lista De Fornecedores", 210, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel lblInfor = FabricaJLabel.criarJLabel("Digite no campos abaixo se deseja Filtrar por nome ou por Tipo",
				60, 50, 480, 40, FabricasColors.corLabelBranca, 13);

		btnDetalhes = FabricaJButton.criarJButton("Ver Detalhes", 280, 390, 120, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);

		btnDetalhes.addActionListener(ouvinteDetalhes);
		btnDetalhes.addMouseListener(ouvinte);

		background.add(lblInfor);
		background.add(btnDetalhes);
		background.add(lblListaDeFornecedores);

	}

	public class OuvinteBotaoDetalhesTelaListarFornecedores implements ActionListener {

		private TelaListarFornecedores tela;

		public OuvinteBotaoDetalhesTelaListarFornecedores(TelaListarFornecedores tela) {
			this.tela = tela;

		}

		public void actionPerformed(ActionEvent e) {
			Object componente = e.getSource();
			linhaSelecionada = TelaListarFornecedores.getTabelaFornecedores().getSelectedRow();
			String emailSelecionado = (String) TelaListarFornecedores.getTabelaFornecedores()
					.getValueAt(linhaSelecionada, 3);
			String tipoFornecedor = (String) TelaListarFornecedores.getTabelaFornecedores().getValueAt(linhaSelecionada,
					1);
			Fornecedor fornecedor = central.recuperarFornecedorPorEmail(emailSelecionado);
			TelaEditarInforFornecedor telaEditar = new TelaEditarInforFornecedor("tela de Editar Dados");
			Editar.desativarComponentes(telaEditar, false);
			if (emailSelecionado.equals(fornecedor.getEmail())) {
				Fornecedor fornecedorTipo = central.recuperarFornecedorPorEmail(emailSelecionado);
				telaEditar.getTxtNome().setText(fornecedor.getNome());
				telaEditar.getTxtEmail().setText(fornecedor.getEmail());
				telaEditar.getTabelaServicos();
				telaEditar.getRdAtivo().setSelected(true);
				tela.dispose();
				if (tipoFornecedor.equals("PESSOAJURIDICA")) {
					telaEditar.getLblTipo().setVisible(false);
					telaEditar.getRdPessoaJuridica().setVisible(false);
					telaEditar.getTxtCNPJ().setVisible(false);
					telaEditar.getLblCNPJ().setVisible(false);
				}
				if (tipoFornecedor.equals("PESSOAFISICA")) {
				}
			} else if (linhaSelecionada == -1) {
				FabricaJOptionPane.criarMsgErro("Selecione uma linha");
			}
		}
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public JTextField getTxtFiltro() {
		return txtFiltro;
	}

	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}

	public static JTable getTabelaFornecedores() {
		return tabelaFornecedores;
	}

	public static void main(String[] args) {
		new TelaListarFornecedores("Listar Fornecedores");
	}

	public static int getLinhaSelecionada() {
		return linhaSelecionada;
	}
}
