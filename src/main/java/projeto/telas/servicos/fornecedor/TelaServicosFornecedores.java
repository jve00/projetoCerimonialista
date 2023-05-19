package projeto.telas.servicos.fornecedor;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.TelaPadrao;
import projeto.modelos.Fornecedor;
import projeto.modelos.enuns.TipoDeServico;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaServicosFornecedores extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnApagar;
	private JTable tabelaServicos;
	private ArrayList<TipoDeServico> servicosExibidos;

	private JScrollPane scrol;
	private DefaultTableModel modelo;

	public TelaServicosFornecedores(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTabelaServicos();

	}

	public void configTela() {
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome", 100, 20, 460, 40, FabricasColors.corLabelBranca, 25);
		btnSalvar = FabricaJButton.criarJButton("Cadastrar", 300, 300, 90, 40, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para confimar o seu cadastro", 16);
	}

	private void configTabelaServicos() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] {"Servicos"});
		tabelaServicos = new JTable(modelo);
		tabelaServicos.setFont(new Font("Arial", 1, 20));
		tabelaServicos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
		tabelaServicos.getTableHeader().setBackground(FabricasColors.corLabelBranca);   
		tabelaServicos.getTableHeader().setForeground(FabricasColors.CorRoxo);
		scrol = new JScrollPane(tabelaServicos);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(140, 100, 400, 300);
		
		background.add(scrol);

	}

	private void popularTabela() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
//
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
		linha[0] = f.getTipoDeServico();

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
