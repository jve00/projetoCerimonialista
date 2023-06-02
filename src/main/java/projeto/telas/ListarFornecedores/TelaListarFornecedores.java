package projeto.telas.ListarFornecedores;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import projeto.ImagemDeFundo;
import projeto.TelaPadrao;
import projeto.modelos.Fornecedor;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaListarFornecedores extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnDetalhes;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private JTable tabelaFornecedores;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");
	private JTextField txtFiltro;

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
		Object[] linhas = new Object[3];
		linhas[0] = f.getNome();
		linhas[1] = f.getTipo();
		linhas[2] = f.getTipoDeServicos();
		modelo.addRow(linhas);
	}

	private void configTabela() {

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Fornecedor", "Tipo ", "Servicos" });
		tabelaFornecedores = new JTable(modelo);
		tabelaFornecedores.setFont(new Font("Arial", 1, 15));
		tabelaFornecedores.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaFornecedores.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaFornecedores.getTableHeader().setForeground(FabricasColors.CorRoxo);
		scrol = new JScrollPane(tabelaFornecedores);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(60, 120, 580, 260);

		background.add(scrol);

		Comparator<Object> comparador = Comparator.comparing(Object::toString, String.CASE_INSENSITIVE_ORDER);
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
		tabelaFornecedores.setRowSorter(sorter);
		sorter.toggleSortOrder(0);

	}

	private void configTexto() {
		txtFiltro = FabricaJText.criarJTextField(60, 90, 300, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Física", 16);
		txtFiltro.addKeyListener(new OuvinteFiltro());
		background.add(txtFiltro);
	}

	public void configTela() {
		OuvinteFiltro ouvinteFiltro = new OuvinteFiltro();

		JLabel lblListaDeFornecedores = FabricaJLabel.criarJLabel("Lista De Fornecedores", 210, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel lblInfor = FabricaJLabel.criarJLabel("Digite no campos abaixo o que deseja Filtrar", 60, 50, 480, 40,
				FabricasColors.corLabelBranca, 13);

		btnDetalhes = FabricaJButton.criarJButton("Ver Detalhes", 280, 390, 120, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);

		background.add(lblInfor);
		background.add(btnDetalhes);

		background.add(lblListaDeFornecedores);
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

	public JTable getTabelaFornecedores() {
		return tabelaFornecedores;
	}

	public static void main(String[] args) {
		new TelaListarFornecedores("Listar Fornecedores");
	}

}
