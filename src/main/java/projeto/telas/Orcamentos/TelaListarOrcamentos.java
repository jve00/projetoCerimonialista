package projeto.telas.Orcamentos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.exceptions.EsseClienteNaoTemEventoException;
import projeto.modelos.Orcamento;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaListarOrcamentos extends TelaPadrao {

	public static JTable tabelaDeOrcamentos;
	private ImagemDeFundo background;
	private JScrollPane scrol;
	private DefaultTableModel modelo;
	private ArrayList<Orcamento> orcamentos;
	private JButton btnAgendarReuniao;
	private JButton btnCadastrar;
	private JMenuItem itemExportarInfo;
	private JMenuItem itemGerarFinancas;
	private JMenuItem itemDetalhes;
	private Persistencia persistencia;
	private CentralDeInformacoes central;
	private static int linhaselecionada;

	public TelaListarOrcamentos(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTela();
		configMenu();
		configTabelaServicos();
		popularTabela();

	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);

	}

	private void popularTabela() {
		persistencia = new Persistencia();
		central = persistencia.recuperarCentral("central");

		orcamentos = central.getTodosOsOrcamentos();

		for (Orcamento o : orcamentos) {
			addLinha(modelo, o);

		}
		scrol.repaint();
	}

	private void addLinha(DefaultTableModel modelo, Orcamento o) {
		Object[] linhas = new Object[6];
		linhas[0] = o.getEmailDoCliente();
		linhas[1] = o.getEvento();
		linhas[2] = o.getLocacao();
		linhas[3] = o.getHora();
		linhas[4] = o.getData();
		linhas[5] = o.getPrecoTotal();

		modelo.addRow(linhas);
	}

	public class OuvinteDoMenuTelaListarOrcamento implements ActionListener {

		private TelaListarOrcamentos tela;

		public OuvinteDoMenuTelaListarOrcamento(TelaListarOrcamentos tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			Object componente = e.getSource();
			String emailSelecionado = (String) TelaListarOrcamentos.getTabelaDeOrcamentos()
					.getValueAt(TelaListarOrcamentos.getLinhaselecionada(), 0);

			if (itemDetalhes == componente) {
				TelaEditarDadosDoOrcamento telaEditar = new TelaEditarDadosDoOrcamento(
						"Detalhamento dos dados do orcamento");
				try {
					ArrayList<Orcamento> c = central.recuperarEventosCliente(emailSelecionado);
					Orcamento eventoDoclienteAssociado = c.get(TelaListarOrcamentos.getLinhaselecionada());
					telaEditar.getTxtEvento().setText(eventoDoclienteAssociado.getEvento());
					telaEditar.getTxtHora().setText(String.valueOf(eventoDoclienteAssociado.getHora()));
					telaEditar.getTxtLocacao().setText(eventoDoclienteAssociado.getLocacao());
					telaEditar.getTxtTamanho().setText(eventoDoclienteAssociado.getTamanho());
					telaEditar.getChooser().setDateFormatString(eventoDoclienteAssociado.getData());
					telaEditar.getTxtOrcamento().setText(String.valueOf(eventoDoclienteAssociado.getPrecoTotal()));
					telaEditar.getChooser().getDate();
					dispose();
				} catch (EsseClienteNaoTemEventoException e1) {
					FabricaJOptionPane.criarMsgErro(e1.getMessage());
				}
			}

		}
	}

	private void configMenu() {
		OuvinteDoMenuTelaListarOrcamento ouvinte = new OuvinteDoMenuTelaListarOrcamento(this);

		JLabel menu = FabricaJLabel.criarJLabel(10, 160, 500, 450, FabricasColors.corLabelBranca, 4);
		menu.setBackground(FabricasColors.CorRoxo);

		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Opções");
		itemExportarInfo = new JMenuItem("Exportar Informacoes");
		itemGerarFinancas = new JMenuItem("Gerar Financas");
		itemDetalhes = new JMenuItem("Detalhes do Orcamento");

		itemExportarInfo.addActionListener(ouvinte);
		itemGerarFinancas.addActionListener(ouvinte);
		itemDetalhes.addActionListener(ouvinte);

		menuBar.add(menuOpcoes);
		menuOpcoes.add(itemExportarInfo);
		menuOpcoes.add(itemGerarFinancas);
		menuOpcoes.add(itemDetalhes);
		setJMenuBar(menuBar);
	}

	private void configTabelaServicos() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { " Cliente", "Evento", "Locacao", "Hora", "Data", "Orcamento" });
		tabelaDeOrcamentos = new JTable(modelo);
		tabelaDeOrcamentos.setFont(new Font("Arial", 1, 13));
		tabelaDeOrcamentos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaDeOrcamentos.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaDeOrcamentos.getTableHeader().setForeground(FabricasColors.CorRoxo);
		scrol = new JScrollPane(tabelaDeOrcamentos);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(-5, 110, 700, 250);
		background.add(scrol);

	}

	private void configTela() {
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		JLabel lblTitulo = FabricaJLabel.criarJLabel("Lista de Contratos e Orcamentos.", 180, -10, 400, 100,
				FabricasColors.corLabelBranca, 20);
		btnAgendarReuniao = FabricaJButton.criarJButton("Agendar Reuniao", 370, 390, 120, 30,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo,
				"Clique aqui para agendar a reuniao com o cliente desejado", 13);
		btnCadastrar = FabricaJButton.criarJButton("Cadastrar Orcamento", 180, 390, 140, 30,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo, "Clique aqui para cadastrar um novo orcamento",
				13);

		btnAgendarReuniao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaAgendarReuniao("Agenda de reunioes");
			}
		});

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCadastrarOrcamento("Cadastre um novo Orcamento.");
			}
		});

		btnAgendarReuniao.addMouseListener(ouvinte);
		btnCadastrar.addMouseListener(ouvinte);
		background.add(btnAgendarReuniao);
		background.add(btnCadastrar);
		background.add(lblTitulo);
	}

	public static void main(String[] args) {
		new TelaListarOrcamentos("");
	}

	public static JTable getTabelaDeOrcamentos() {
		return tabelaDeOrcamentos;
	}

	public static int getLinhaselecionada() {
		return linhaselecionada;
	}

}
