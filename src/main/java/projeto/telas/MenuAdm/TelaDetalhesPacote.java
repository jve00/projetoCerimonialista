package projeto.telas.MenuAdm;

import javax.swing.JButton;
import javax.swing.JLabel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelos.Pacote;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaDetalhesPacote extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnSeta;

	public TelaDetalhesPacote(String titulo) {
		super(titulo);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		adicionarComponentes();
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public void adicionarComponentes() {
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		Persistencia p = new Persistencia();
		CentralDeInformacoes c = p.recuperarCentral("central");

		int linha = TelaListarPacotes.getLinhaSelecionada();
		String nome = (String) TelaListarPacotes.getTabelaPacotes().getValueAt(linha, 0);
		Pacote pacote = c.recuperarPacote(nome);

		JLabel jlTitulo = FabricaJLabel.criarJLabel("Detalhes do pacote", 200, 10, 300, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel jlNome = FabricaJLabel.criarJLabel("Nome: " + pacote.getNome(), 10, 70, 600, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel jlFornecedores = FabricaJLabel.criarJLabel("Fornecedores: " + pacote.getFornecedores(), 10, 140, 600, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel jlServicos = FabricaJLabel.criarJLabel("Servicos: " + pacote.getServicos(), 10, 220, 600, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel jlPreco = FabricaJLabel.criarJLabel("Preco: " + pacote.getPreco(), 10, 300, 600, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel jlDescricao = FabricaJLabel.criarJLabel("Descricao: " + pacote.getDescricao(), 10, 380, 600, 40,
				FabricasColors.corLabelBranca, 25);

		

		background.add(jlTitulo);
		background.add(jlNome);
		background.add(jlFornecedores);
		background.add(jlServicos);
		background.add(jlPreco);
		background.add(jlDescricao);
	}

}
