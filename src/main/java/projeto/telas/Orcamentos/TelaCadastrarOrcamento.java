package projeto.telas.Orcamentos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
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
import projeto.modelos.Orcamento;
import projeto.modelos.Pacote;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJCheckBox;
import ultilidades.fabricas.FabricaJFormatted;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricaJRadionButton;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaCadastrarOrcamento extends TelaPadrao {

	private ImagemDeFundo background;
	private JTextField txtNomeDoCliente;
	private JTextField txtEvento;
	private JTextField txtLocacao;
	private JTextField txtTamanho;
	private JTextField txtOrcamento;
	private JButton btnAgendarReuniao;
	private JButton btnSalvar;
	private JLabel lblChooser;
	private JDateChooser chooser;
	private JFormattedTextField txtHora;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private JTable tabelaFornecedores;
	private ArrayList<Pacote> pacotes;
	private JRadioButton rdContrato;
	private JRadioButton rdCliente;

	public TelaCadastrarOrcamento(String titulo) {
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

		for (Pacote p : pacotes) {
			addLinha(modelo, p);
		}
		scrol.repaint();
	}

	private void addLinha(DefaultTableModel modelo, Pacote p) {
		Object[] linhas = new Object[3];
		linhas[0] = p.getNome();
		linhas[1] = p.getFornecedores();
		linhas[2] = p.getPreco();
		modelo.addRow(linhas);
	}

	private void configTabela() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Nome", "Pacote ou Individual ", "Valor" });
		tabelaFornecedores = new JTable(modelo);
		tabelaFornecedores.setFont(new Font("Arial", 1, 15));
		tabelaFornecedores.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaFornecedores.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaFornecedores.getTableHeader().setForeground(FabricasColors.CorRoxo);
		tabelaFornecedores.setAutoCreateRowSorter(true);
		scrol = new JScrollPane(tabelaFornecedores);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(96, 230, 460, 150);
		background.add(scrol);

	}

	public void configTela() {
		OuvinteBotaoSalvar ouvinteSalvar = new OuvinteBotaoSalvar(this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();

		JLabel lblTitulo = FabricaJLabel.criarJLabel("Cadastrar Orcamento", 180, 10, 460, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel lblNomeDoCliente = FabricaJLabel.criarJLabel("Nome do Cliente:", 100, 70, 200, 25,
				FabricasColors.corLabelBranca, 20);
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

		txtOrcamento = FabricaJText.criarJTextField(380, 200, 50, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "valor do orcamento", 16);

		txtNomeDoCliente = FabricaJText.criarJTextField(265, 70, 282, 25, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o nome do Cliente aqui", 16);
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
		try {
			txtHora = FabricaJFormatted.criarJFormatted(165, 195, 80, 30, new MaskFormatter("##:##:##"),
					FabricasColors.corTxtField, FabricasColors.corLabelBranca, "Digite a hora do Evento aqui");
		} catch (Exception e) {
		}
		btnAgendarReuniao = FabricaJButton.criarJButton("Agendar Reuniao", 443, 200, 110, 30,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo,
				"Clique aqui para Agendar a reuniao com o cliente", 10);
		btnSalvar = FabricaJButton.criarJButton("Salvar", 460, 410, 90, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para Salvar o servico", 16);

		btnAgendarReuniao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaAgendarReuniao("Agendar Reuniao");
			}
		});

		btnAgendarReuniao.addMouseListener(ouvinte);
		btnSalvar.addActionListener(ouvinteSalvar);
		btnSalvar.addMouseListener(ouvinte);

		background.add(lblTitulo);
		background.add(lblNomeDoCliente);
		background.add(lblEvento);
		background.add(lblLocacao);
		background.add(lblTamanho);
		background.add(lblData);
		background.add(lblHora);
		background.add(lblOrcamento);
		background.add(lblInfo);
		background.add(txtNomeDoCliente);
		background.add(txtEvento);
		background.add(txtLocacao);
		background.add(txtTamanho);
		background.add(lblChooser);
		background.add(txtHora);
		background.add(txtOrcamento);
		background.add(btnAgendarReuniao);
		background.add(btnSalvar);
		background.add(rdCliente);
		background.add(rdContrato);
	}

	public class OuvinteBotaoSalvar implements ActionListener {

		private TelaCadastrarOrcamento tela;

		public OuvinteBotaoSalvar(TelaCadastrarOrcamento tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			Persistencia persistencia = new Persistencia();
			CentralDeInformacoes central = persistencia.recuperarCentral("central");
			Object componente = e.getSource();
			String nomeCliente = tela.getTxtNomeDoCliente().getText();
			String evento = tela.getTxtEvento().getText();
			String locacao = tela.getTxtLocacao().getText();
			String tamanho = tela.getTxtTamanho().getText();
			Date data = tela.getChooser().getDate();
			String hora = tela.getTxtHora().getText();
			String orcamento = tela.getTxtOrcamento().getText();
			String tipoDePagamento = "avista";
			LocalTime horaConvertida = LocalTime.parse(hora);
			try {
				boolean valido = Validador.validarCadastroOrcamento(nomeCliente, evento, locacao, tamanho, hora);
				if (valido) {
					Date dataAtual = new Date();
					if (data != null && data.after(dataAtual)) {
						if (horaConvertida.isAfter(LocalTime.MIDNIGHT)
								&& horaConvertida.isBefore(LocalTime.of(23, 59))) {
							central.adicionarOrcamento(new Orcamento(nomeCliente, evento, locacao, tamanho,
									String.valueOf(data), horaConvertida, tipoDePagamento));
						} else {
							FabricaJOptionPane.criarMsgErro("Hora invalida, passe uma hora valida");
						}
					} else if (data == null || data.before(dataAtual)) {
						FabricaJOptionPane.criarMsgErro("data Invalida, passe uma data valida");
					}
				}
			} catch (Exception e1) {
				FabricaJOptionPane.criarMsgErro(e1.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		new TelaCadastrarOrcamento("");
	}

	public JTextField getTxtNomeDoCliente() {
		return txtNomeDoCliente;
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

}
