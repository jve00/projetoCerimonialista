package projeto.telas.Orcamentos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelos.Cliente;
import projeto.modelos.Orcamento;
import projeto.modelos.Pacote;
import projeto.telas.Orcamentos.TelaCadastrarOrcamento.OuvinteBotaoSalvar;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJFormatted;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJRadionButton;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaEditarDadosDoOrcamento extends TelaPadrao {

	private ImagemDeFundo background;
	private static JTextField txtEmailDoCliente;
	private JTextField txtEvento;
	private JTextField txtLocacao;
	private JTextField txtTamanho;
	private JTextField txtOrcamento;
	private JButton btnSalvar;
	private JLabel lblChooser;
	private JButton btnEditar;
	private JDateChooser chooser;
	private JFormattedTextField txtHora;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private JTable tabelaFornecedores;
	private ArrayList<Pacote> pacotes;
	private ArrayList<Orcamento> orcamento;
	private JRadioButton rdContrato;
	private JRadioButton rdCliente;
	public static Cliente clienteRecuperado;

	public TelaEditarDadosDoOrcamento(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configurarDateChooser();
		configTela();
		configTabela();
		popularTabela();
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

	private void popularTabela() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		pacotes = central.getTodosOsPacotes();
		orcamento = central.getTodosOsOrcamentos();

		for (Pacote p : pacotes) {
			for (Orcamento o : orcamento) {
				addLinha(modelo, p, o);
			}
		}
		scrol.repaint();
	}

	private void addLinha(DefaultTableModel modelo, Pacote p, Orcamento o) {
		Object[] linhas = new Object[4];
		linhas[0] = p.getNome();
		linhas[1] = p.getFornecedores();
		linhas[2] = p.getPreco();
		linhas[3] = o.getTipoDePagamento();
		modelo.addRow(linhas);
	}

	private void configTabela() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Nome", "Pacote ou Individual ", "Valor", "Contrato|Cliente" });
		tabelaFornecedores = new JTable(modelo);
		tabelaFornecedores.setFont(new Font("Arial", 1, 15));
		tabelaFornecedores.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaFornecedores.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaFornecedores.getTableHeader().setForeground(FabricasColors.CorRoxo);
		tabelaFornecedores.setAutoCreateRowSorter(true);
		scrol = new JScrollPane(tabelaFornecedores);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(50, 230, 550, 150);
		background.add(scrol);

	}

	public void configTela() {
		OuvinteBtnSalvar ouvinteSalvar = new OuvinteBtnSalvar(this);

		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		JLabel lblTitulo = FabricaJLabel.criarJLabel("Detalhes Do Orcamento.", 180, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);

		JLabel lblEvento = FabricaJLabel.criarJLabel("Evento: ", 100, 100, 100, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblLocacao = FabricaJLabel.criarJLabel("Locacao:", 100, 130, 100, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblTamanho = FabricaJLabel.criarJLabel("Tamanho: ", 100, 160, 250, 25, FabricasColors.corLabelBranca,
				20);
		JLabel lblData = FabricaJLabel.criarJLabel("Data: ", 270, 160, 250, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora: ", 100, 200, 250, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblOrcamento = FabricaJLabel.criarJLabel("Orcamento: ", 260, 194, 460, 40, FabricasColors.corLabelBranca,
				20);
		JLabel lblInfo = FabricaJLabel.criarJLabel("Pagamento via : ", 100, 380, 460, 40, FabricasColors.corLabelBranca,
				15);

		txtOrcamento = FabricaJText.criarJTextField(380, 200, 70, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "valor do orcamento", 16);
		txtOrcamento.setEditable(false);

		txtEvento = FabricaJText.criarJTextField(200, 100, 347, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o nome do Evento aqui", 16);

		txtLocacao = FabricaJText.criarJTextField(200, 130, 347, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o local que o evento sera realizado. ", 16);

		txtTamanho = FabricaJText.criarJTextField(200, 160, 50, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite para quantas pessoas o evento sera fornecido", 16);

		rdCliente = FabricaJRadionButton.criarRadionButton("Cliente", 220, 385, 80, 30, FabricasColors.corLabelBranca,
				"clique aqui para o pagamento ser via cliente", 15);
		rdContrato = FabricaJRadionButton.criarRadionButton("Contrato", 300, 385, 90, 30, FabricasColors.corLabelBranca,
				"clique aqui para o pagamento ser via contrato", 15);

		btnEditar = FabricaJButton.criarJButton("Editar", 400, 410, 90, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para editar os dados do orcamento", 16);
		try {
			txtHora = FabricaJFormatted.criarJFormatted(165, 195, 80, 30, new MaskFormatter("##:##"),
					FabricasColors.corTxtField, FabricasColors.corLabelBranca, "Digite a hora do Evento aqui");
		} catch (Exception e) {
		}

		btnSalvar = FabricaJButton.criarJButton("Salvar", 500, 410, 90, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para Salvar o servico", 16);

		btnSalvar.addActionListener(ouvinteSalvar);
		btnSalvar.addMouseListener(ouvinte);
		btnEditar.addMouseListener(ouvinte);

		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object componente = e.getSource();
				setEnabled(true);
//				Object componente = e.getSource();
//				String evento = tela.getTxtEvento().getText();
//				String locacao = tela.getTxtLocacao().getText();
//				String tamanho = tela.getTxtTamanho().getText();
//				String emailSelecionado = (String) TelaListarOrcamentos.getTabelaDeOrcamentos()
//						.getValueAt(TelaListarOrcamentos.getLinhaselecionada(), 0);
//				System.out.println(emailSelecionado);
//				boolean selecionouContrato = tela.getRdCliente().isSelected();
//				TipoDePagamento opcaoDePagamento = (selecionouContrato ? TipoDePagamento.CLIENTE
//						: TipoDePagamento.CONTRATO);
//				ArrayList<Evento> c = central.recuperarEventosCliente(emailSelecionado);
//				Evento eventoDoclienteAssociado = c.get(TelaListarOrcamentos.getLinhaselecionada());
//				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//				getChooser().getDate();
//				getTxtHora().setText(eventoDoclienteAssociado.getData());

//				int[] linhasSelecionadas = tabelaFornecedores.getSelectedRows();
//				float soma = 0;
//				List<Object> valores = new ArrayList<>();
//				for (int linha : linhasSelecionadas) {
//					Object valorObj = tabelaFornecedores.getValueAt(linha, 2);
//					if (valorObj instanceof Float) {
//						float valor = (float) valorObj;
//						valores.add(valor);
//						soma += valor;

			}

		});
		background.add(lblTitulo);
		background.add(lblEvento);
		background.add(lblLocacao);
		background.add(lblTamanho);
		background.add(lblData);
		background.add(lblHora);
		background.add(lblOrcamento);
		background.add(lblInfo);
		background.add(txtEvento);
		background.add(txtLocacao);
		background.add(txtTamanho);
		background.add(lblChooser);
		background.add(txtHora);
		background.add(txtOrcamento);
		background.add(btnSalvar);
		background.add(btnEditar);
		background.add(rdCliente);
		background.add(rdContrato);
	}

	public class OuvinteBtnSalvar implements ActionListener {

		private TelaEditarDadosDoOrcamento tela;

		public OuvinteBtnSalvar(TelaEditarDadosDoOrcamento tela) {
			this.tela = tela;

		}

		public void actionPerformed(ActionEvent e) {
			Object componente = e.getSource();

		}

	}

	public static void main(String[] args) {
		new TelaEditarDadosDoOrcamento("");
	}

	public static JTextField getTxtEmailDoCliente() {
		return txtEmailDoCliente;
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

	public JTextField getTxtOrcamento() {
		return txtOrcamento;
	}

	public JLabel getLblChooser() {
		return lblChooser;
	}

	public JDateChooser getChooser() {
		return chooser;
	}

	public JRadioButton getRdContrato() {
		return rdContrato;
	}

	public JRadioButton getRdCliente() {
		return rdCliente;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setTxtOrcamento(JTextField txtOrcamento) {
		this.txtOrcamento = txtOrcamento;
	}

}