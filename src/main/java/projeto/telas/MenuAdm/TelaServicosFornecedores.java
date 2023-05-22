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
import projeto.modelos.Fornecedor;
import projeto.modelos.enuns.TipoDeServico;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoApagarTelaServicosFornecedores;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoEditarTelaServicosFornecedores;
import projeto.telas.MenuAdm.ouvintes.OuvinteBotaoSalvarTelaServicosFornecedores;
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

	public TelaServicosFornecedores(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTabelaServicos();
		configTela();

	}

	public void configTela() {
		OuvinteBotaoApagarTelaServicosFornecedores ouvinteApagar = new OuvinteBotaoApagarTelaServicosFornecedores(this);
		OuvinteBotaoEditarTelaServicosFornecedores ouvinteEditar = new OuvinteBotaoEditarTelaServicosFornecedores(this);
		OuvinteBotaoSalvarTelaServicosFornecedores ouvinteSalvar = new OuvinteBotaoSalvarTelaServicosFornecedores(this);
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
		tabelaServicos.setFont(new Font("Arial", 1, 20));
		tabelaServicos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
		tabelaServicos.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaServicos.getTableHeader().setForeground(FabricasColors.CorRoxo);
		scrol = new JScrollPane(tabelaServicos);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(140, 110, 390, 250);

		background.add(scrol);

	}

	private void popularTabela() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

//		try {
//			ArrayList<Corrida> corridasDoPassageiro = central
//					.recuperarCorridasDeUmPassageiro(TelaPadrao.passageiroLogado.getEmail());
//			for (Corrida c : corridasDoPassageiro) {
//				addLinha(modelo, c);
//			}
//		} catch (UsuarioNaoExisteException e) {
//		}
//
	}

	private void addLinha(DefaultTableModel modelo, Fornecedor f) {

		Object[] linha = new Object[0];
		linha[0] = f.getTipoDeServicos();

		modelo.addRow(linha);
		scrol.repaint();

	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
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

	public static void main(String[] args) {
		new TelaServicosFornecedores("Cadastrar ou editar Servicos");
	}
}
