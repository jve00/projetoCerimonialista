package projeto.telas.MenuAdm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.TelaPadrao;
import projeto.modelos.Pacote;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;


public class TelaListarPacotes extends TelaPadrao{

	private ImagemDeFundo background;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private static JTable tabelaPacotes;
	private Persistencia persistencia;
	private CentralDeInformacoes central;
	private static int linhaSelecionada;
	
	
	public TelaListarPacotes(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public void configurarComponentes() {
		configImagemFundo();
		adicionarComponentes();
		configTabela();
		popularTabelaPacotes();
	}
	
	public void configTabela() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] {"Nome","Fornecedores","Servicos","Preco"});;
		tabelaPacotes = new JTable(modelo);
		tabelaPacotes.setFont(new Font("Arial", 1, 15));
		tabelaPacotes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tabelaPacotes.getTableHeader().setBackground(FabricasColors.corLabelBranca);
		tabelaPacotes.getTableHeader().setForeground(FabricasColors.CorRoxo);
		tabelaPacotes.setAutoCreateRowSorter(true);
		scrol = new JScrollPane(tabelaPacotes);
		scrol.getViewport().setBackground(FabricasColors.CorRoxo);
		scrol.setBounds(60,60,580,300);
		background.add(scrol);
	}
	
	public void popularTabelaPacotes() {
		persistencia = new Persistencia();
		central = persistencia.recuperarCentral("central");
		
		for (Pacote p : central.getTodosOsPacotes()) {
			addLinha(modelo, p);
		}
		scrol.repaint();
	}
	
	private void addLinha(DefaultTableModel modelo, Pacote p) {
		Object[] linhas = new Object[4];
		linhas[0] = p.getNome();
		linhas[1] = p.getFornecedores();
		linhas[2] = p.getServicos();
		linhas[3] = p.getPreco();
		modelo.addRow(linhas);
	}
	
	private class OuvinteBotaoDetalhesTelaListarPacotes implements ActionListener{
			
		private TelaListarPacotes tela;
		
		public OuvinteBotaoDetalhesTelaListarPacotes(TelaListarPacotes tela) {
			this.tela = tela;
		}	
		
			public void actionPerformed(ActionEvent e) {
				
				if (linhaSelecionada == -1) {
					FabricaJOptionPane.criarMsgErro("Selecione uma linha");
				}else {
					Object componete = e.getSource();
					linhaSelecionada = tela.getTabelaPacotes().getSelectedRow();
					String nome = (String)(tela.getTabelaPacotes().getValueAt(linhaSelecionada,0));
					Pacote pacote = central.recuperarPacote(nome);
					new TelaDetalhesPacote("Detalhes do Pacote");
					
				}				
			}
		}
	
	
	
	private class OuvinteBotaoAdicionarPacote implements ActionListener{
		
		private TelaListarPacotes tela;
		
		public OuvinteBotaoAdicionarPacote(TelaListarPacotes tela) {
			this.tela = tela;
		}
		
		public void actionPerformed(ActionEvent e) {
			tela.dispose();
			TelaCadastrarPacotes tela = new TelaCadastrarPacotes("Cadastrar Pacotes");
		}
	}
	
	private class OuvinteBotaoRemoverPacote implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (linhaSelecionada == -1) {
				FabricaJOptionPane.criarMsgErro("Selecione uma linha");
			}else {
				modelo.removeRow(linhaSelecionada);
				tabelaPacotes.repaint();
				
				String nome = (String)(getTabelaPacotes().getValueAt(linhaSelecionada,0));
				Pacote pacote = central.recuperarPacote(nome);
				central.getTodosOsPacotes().remove(pacote);
				persistencia.salvarCentral(central, "central");
			}
			
		}
	}
	
	public void adicionarComponentes() {
		OuvinteBotaoDetalhesTelaListarPacotes ouvinteDetalhe = new OuvinteBotaoDetalhesTelaListarPacotes(this);
		OuvinteBotaoAdicionarPacote ouvinteAdicionar = new OuvinteBotaoAdicionarPacote(this);
		OuvinteBotaoRemoverPacote ouvinteRemover = new OuvinteBotaoRemoverPacote();
		
		JLabel jlTitulo = FabricaJLabel.criarJLabel("Lista de Pacotes",60,10, 200, 60, FabricasColors.corLabelBranca,25);
		JButton jbBotaoDetalhes = FabricaJButton.criarJButton("Exibir Detalhes", 440, 10, 200, 40, FabricasColors.corTxtField,
				FabricasColors.CorRoxo, "Clique aqui para mostrar os detalhes do pacote", 20);
		JButton jbBotaoAdicionarPacote = FabricaJButton.criarJButton("Adicionar Pacotes", 60, 380, 200, 40, FabricasColors.corTxtField,
				FabricasColors.CorRoxo, "Clique aqui para adicionar um novo pacote", 20);
		JButton jbBotaoRemoverPacote = FabricaJButton.criarJButton("Remover Pacotes", 440, 380, 200, 40, FabricasColors.corTxtField,
				FabricasColors.CorRoxo, "Clique aqui para remover um pacote", 20);
	
		jbBotaoDetalhes.addActionListener(ouvinteDetalhe);
		jbBotaoAdicionarPacote.addActionListener(ouvinteAdicionar);
		jbBotaoRemoverPacote.addActionListener(ouvinteRemover);
		
		background.add(jlTitulo);
		background.add(jbBotaoDetalhes);
		background.add(jbBotaoAdicionarPacote);
		background.add(jbBotaoRemoverPacote);
	}
	
	
	public static void main(String[] args) {
		TelaListarPacotes t = new TelaListarPacotes("Tela Listar Pacotes");
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JScrollPane getScrol() {
		return scrol;
	}

	public void setScrol(JScrollPane scrol) {
		this.scrol = scrol;
	}

	public static JTable getTabelaPacotes() {
		return tabelaPacotes;
	}

	public static void setTabelaPacotes(JTable tabelaPacotes) {
		TelaListarPacotes.tabelaPacotes = tabelaPacotes;
	}

	public Persistencia getPersistencia() {
		return persistencia;
	}

	public void setPersistencia(Persistencia persistencia) {
		this.persistencia = persistencia;
	}

	public CentralDeInformacoes getCentral() {
		return central;
	}

	public void setCentral(CentralDeInformacoes central) {
		this.central = central;
	}

	public static int getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public static void setLinhaSelecionada(int linhaSelecionada) {
		TelaListarPacotes.linhaSelecionada = linhaSelecionada;
	}

	
}
