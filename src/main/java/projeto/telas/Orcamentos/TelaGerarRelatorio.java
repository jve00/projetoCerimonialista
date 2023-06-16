package projeto.telas.Orcamentos;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJCheckBox;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaGerarRelatorio extends TelaPadrao {

	private ImagemDeFundo background;
	private JCheckBox cbNome;
	private JCheckBox cbEvento;
	private JCheckBox cbDataHora;
	private JCheckBox cbPacotes;
	private JCheckBox cbFornecedoresIndividuais;
	private JCheckBox cbOrcamento;
	private JButton btnEnviar;

	

	public TelaGerarRelatorio(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTela();
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);

	}

	private void configTela() {
//		OuvinteCbNome ouvinteEnviar = new OuvinteCbNome(this);
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		JLabel lblTitulo = FabricaJLabel.criarJLabel("Relatorio.", 280, 50, 460, 40, FabricasColors.corLabelBranca, 25);

		cbNome = FabricaJCheckBox.criarJCheckBox(150, 160, 150, 30, "Nome do Cliente", FabricasColors.corLabelBranca,
				"asdasdasdas", 50);
		cbEvento = FabricaJCheckBox.criarJCheckBox(150, 190, 250, 30, "Nome e tamanho do Evento",
				FabricasColors.corLabelBranca, "clique aqui para selecionar a opcao", 50);
		cbDataHora = FabricaJCheckBox.criarJCheckBox(150, 220, 250, 30, "Local, Data e hora.",
				FabricasColors.corLabelBranca, "clique aqui para selecionar a opcao", 50);
		cbPacotes = FabricaJCheckBox.criarJCheckBox(150, 250, 250, 30, "Pacotes", FabricasColors.corLabelBranca,
				"clique aqui para selecionar a opcao", 15);
		cbFornecedoresIndividuais = FabricaJCheckBox.criarJCheckBox(150, 280, 250, 30, "Fornecedores Individuais",
				FabricasColors.corLabelBranca, "clique aqui para selecionar a opcao", 50);
		cbOrcamento = FabricaJCheckBox.criarJCheckBox(150, 310, 250, 30, "Orcamentos", FabricasColors.corLabelBranca,
				"clique aqui para selecionar a opcao", 50);

		btnEnviar = FabricaJButton.criarJButton("Enviar Relatorio", 270, 400, 150, 30, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo,
				"ao clicar aqui, vc enviara um relatorio contendo os dados do orcamento para o seu email.", 15);

//		cbNome.addActionListener(ouvinteEnviar);
//		btnEnviar.addActionListener(ouvinteEnviar);
		btnEnviar.addMouseListener(ouvinte);

		background.add(lblTitulo);
		background.add(cbNome);
		background.add(cbEvento);
		background.add(cbDataHora);
		background.add(cbPacotes);
		background.add(cbFornecedoresIndividuais);
		background.add(cbOrcamento);
		background.add(btnEnviar);

	}


	public static void main(String[] args) {
		new TelaGerarRelatorio("Gerar");
	}

	public JCheckBox getCbnome() {
		return cbNome;
	}

	public JCheckBox getCbEvento() {
		return cbEvento;
	}

	public JCheckBox getCbDataHora() {
		return cbDataHora;
	}

	public JCheckBox getCbPacotes() {
		return cbPacotes;
	}

	public JCheckBox getCbFornecedoresIndividuais() {
		return cbFornecedoresIndividuais;
	}

	public JCheckBox getCbOrcamento() {
		return cbOrcamento;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

}
