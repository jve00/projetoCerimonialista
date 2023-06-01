package projeto.telas.ListarFornecedores;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.TelaPadrao;

import projeto.modelos.Fornecedor;
import projeto.modelos.FornecedorFisico;
import projeto.modelos.PessoaFisica;
import projeto.modelos.PessoaJuridica;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJRadionButton;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaListarFornecedores extends TelaPadrao {

	private ImagemDeFundo background;

	private JRadioButton rdPessoaFisica;
	private JRadioButton rdPessoaJuridica;
	private JButton btnDetalhes;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private JTable tabelaFornecedores;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");

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
				"Escolha uma das opcões acima para filtrar os forncedores pelo tipo", 110, 90, 480, 40,
				FabricasColors.corLabelBranca, 13);

		rdPessoaFisica = FabricaJRadionButton.criarRadionButton("Pessoa Fisica", 140, 50, 130, 50,
				FabricasColors.corLabelBranca, "Clique aqui para filtrar por pessoas fisicas", 15);

		rdPessoaJuridica = FabricaJRadionButton.criarRadionButton("Pessoa Fisica", 400, 50, 130, 50,
				FabricasColors.corLabelBranca, "Clique aqui para filtrar por pessoas Juridicas", 15);

		btnDetalhes = FabricaJButton.criarJButton("Ver Detalhes", 280, 390, 120, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);

//		rdPessoaFisica.addItemListener(ouvinteFiltro);
//		rdPessoaFisica.addMouseListener(ouvinte);
//		rdPessoaJuridica.addItemListener(ouvinteFiltro);
//		rdPessoaJuridica.addMouseListener(ouvinte);
		
		background.add(lblInfor);
		background.add(btnDetalhes);
		background.add(rdPessoaFisica);
		background.add(rdPessoaJuridica);
		background.add(lblListaDeFornecedores);
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);

	}

	public JRadioButton getrdPessoaFisica() {
		return rdPessoaFisica;
	}

	public JRadioButton getrdPessoaJuridica() {
		return rdPessoaJuridica;
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
