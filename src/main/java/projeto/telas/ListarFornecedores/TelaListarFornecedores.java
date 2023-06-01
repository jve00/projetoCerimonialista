package projeto.telas.ListarFornecedores;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
		popularTabelaFornecedor();
	}
	
	
	
	

//	public class OuvinteFiltrarTabela implements ItemListener {
//
//		private TelaListarFornecedores tela;
//		private ArrayList<Fornecedor> fornecedores;
//
//		public OuvinteFiltrarTabela(TelaListarFornecedores tela) {
//			this.tela = tela;
//		}

//		public void itemStateChanged(ItemEvent e) {
//			FornecedorFisico fornecedorFisico = new FornecedorFisico(getName(), getTitle(), getWarningString(),
//					getName(), ABORT, null);
//
//			fornecedores = new ArrayList<>();
//			p = new Persistencia();
//			central = p.recuperarCentral("central");
//
//			boolean filtroFisica = tela.getrdPessoaFisica().isSelected();
//		
//			if (!filtroFisica) {
//				System.out.println("entrou");
//				for (Fornecedor f : fornecedores) {
//					System.out.println(f);
//					if (f.getTipo().equals(fornecedorFisico.getTipo())) {
//					
//						
//						System.out.println(f.getTipo());
//						addLinha(modelo, f);
//
//					}
//				}
//
//			}
//
//			modelo.setRowCount(0);
//			scrol.repaint();
//		}
//
//	}

	public void popularTabelaFornecedor() {
		p = new Persistencia();
		central = p.recuperarCentral("central");

		for (Fornecedor f : central.getTodoOsFornecedores()) {
			addLinha(modelo, f);
		}
		scrol.repaint();
	}

	private void addLinha(DefaultTableModel modelo, Fornecedor f) {
		Object[] linhas = new Object[2];
		linhas[0] = f.getNome();
		linhas[1] = f.getTipo();
		modelo.addRow(linhas);
	}

	private void configTabela() {

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Fornecedor", "Tipo " });
		tabelaFornecedores = new JTable(modelo);
		tabelaFornecedores.setFont(new Font("Arial", 1, 15));
		tabelaFornecedores.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaFornecedores.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaFornecedores.getTableHeader().setForeground(FabricasColors.CorRoxo);
		scrol = new JScrollPane(tabelaFornecedores);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(90, 120, 500, 260);

		background.add(scrol);
	}

	public void configTela() {
//		OuvinteFiltrarTabela ouvinteFiltro = new OuvinteFiltrarTabela(this);
//		OuvinteBotaoFundoBranco ouvinte = new OuvinteBotaoFundoBranco();
		
		JLabel lblListaDeFornecedores = FabricaJLabel.criarJLabel("Lista De Fornecedores", 210, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel lblInfor = FabricaJLabel.criarJLabel(
				"Digite no campos abaixo o que deseja Filtrar", 95, 50, 480, 40,
				FabricasColors.corLabelBranca, 13);
		txtFiltro = FabricaJText.criarJTextField(95, 90, 300, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca,"Física", 16);

		btnDetalhes = FabricaJButton.criarJButton("Ver Detalhes", 280, 390, 120, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);

		
		background.add(lblInfor);
		background.add(txtFiltro);
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
