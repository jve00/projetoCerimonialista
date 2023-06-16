package projeto.telas.MenuAdm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.exceptions.PacoteJaExisteException;
import projeto.modelos.Fornecedor;
import projeto.modelos.Pacote;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricaJTextArea;
import ultilidades.fabricas.FabricasColors;
import ultilidades.imagens.Imagens;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaCadastrarPacotes extends TelaPadrao {

	private ImagemDeFundo background;
	private JTextField txtNome;
	private JList<String> jlservicos;
	private JList<Fornecedor> jlfornecedores;
	private JTextField txtpreco;
	private JTextArea txtdescricao;
	private JButton btnCadastrar;
	private JButton btnAdicionarFornecedor;
	private JButton bntAdicionarServico;
	private ArrayList<String> servicosDoFornecedor;
	private String[] servicosArray;
	private Fornecedor[] fornecedoresArray;
	private JButton btnSeta;

	public TelaCadastrarPacotes(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configTela();
	}

	public void configTela() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		OuvinteBotaoCadastrarTelaCadastrarPacote ouvinteCadastro = new OuvinteBotaoCadastrarTelaCadastrarPacote(this);

		// OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome:", 100, 10, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblfornecedores = FabricaJLabel.criarJLabel("Fornecedores:", 100, 90, 175, 40,
				FabricasColors.corLabelBranca, 25);
		JLabel lblservicos = FabricaJLabel.criarJLabel("Servicos:", 380, 90, 170, 40, FabricasColors.corLabelBranca,
				25);
		JLabel lblValor = FabricaJLabel.criarJLabel("Valor:", 100, 270, 70, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblDetalhePacote = FabricaJLabel.criarJLabel("Detalhes do pacote:", 100, 320, 460, 40,
				FabricasColors.corLabelBranca, 25);

		txtNome = FabricaJText.criarJTextField(100, 50, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Nome aqui", 20);
		txtpreco = FabricaJText.criarJTextField(175, 270, 200, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o preco aqui", 20);
		txtdescricao = FabricaJTextArea.criarJTextArea(100, 370, 460, 80, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca);

		btnCadastrar = FabricaJButton.criarJButton("Cadastrar Pacote", 380, 270, 200, 40, FabricasColors.corTxtField,
				FabricasColors.CorRoxo, "Clique aqui para concluir o cadastro", 20);
		// btnAdicionarFornecedor

		// Adicionando JList servicos
		servicosDoFornecedor = new ArrayList<String>();
		ArrayList<String> servicos = central.getServicos();
		servicosArray = servicos.toArray(new String[servicos.size()]);

		jlservicos = new JList<>(servicosArray);
		jlservicos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPaneServicos = new JScrollPane(jlservicos);
		scrollPaneServicos.setBounds(370, 125, 200, 120);

		// Adicionando JList fornecedores
		ArrayList<Fornecedor> arrayFor = central.getTodoOsFornecedores();
		fornecedoresArray = arrayFor.toArray(new Fornecedor[arrayFor.size()]);

		jlfornecedores = new JList<>(fornecedoresArray);
		jlfornecedores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPaneFornecedores = new JScrollPane(jlfornecedores);
		scrollPaneFornecedores.setBounds(90, 125, 200, 120);

		ListSelectionListener ouvinteJLFornecedores = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int indiceSelecionado = jlfornecedores.getSelectedIndex();
					if (indiceSelecionado >= 0) {
						ArrayList<Fornecedor> fornecedoresSelecionados = new ArrayList<Fornecedor>(
								jlfornecedores.getSelectedValuesList());
						for (Fornecedor f : fornecedoresSelecionados) {
							for (String s : f.getTipoDeServicos()) {
								if (!servicosDoFornecedor.contains(s)) {
									servicosDoFornecedor.add(s);
								}

							}
						}
						System.out.println("Elemento selecionado: " + servicosDoFornecedor);
						jlservicos.repaint();
					}
				} else {
					servicosDoFornecedor = new ArrayList<String>();
				}
			}
		};
		jlfornecedores.addListSelectionListener(ouvinteJLFornecedores);

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50, "clique aqui para voltar");
		btnSeta.addMouseListener(ouvinte);
		btnSeta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaListarPacotes("Listagem de pacotes");
			}
		});

		btnCadastrar.addActionListener(ouvinteCadastro);
		// btnCadastrar.addMouseListener(ouvinte);
		background.add(lblNome);
		background.add(lblfornecedores);
		background.add(lblservicos);
		background.add(scrollPaneServicos);
		background.add(scrollPaneFornecedores);
		background.add(lblValor);
		background.add(lblDetalhePacote);
		background.add(txtNome);
		background.add(txtpreco);
		background.add(txtdescricao);
		background.add(btnCadastrar);
		background.add(btnSeta);

	}

	private class OuvinteBotaoCadastrarTelaCadastrarPacote implements ActionListener {
		private TelaCadastrarPacotes tela;

		public OuvinteBotaoCadastrarTelaCadastrarPacote(TelaCadastrarPacotes tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			Persistencia persistencia = new Persistencia();
			CentralDeInformacoes central = persistencia.recuperarCentral("central");
			String nome = txtNome.getText();
			float preco = 0;
			String descricao = txtdescricao.getText();
			ArrayList<String> servicos = new ArrayList<String>(jlservicos.getSelectedValuesList());
			ArrayList<Fornecedor> fornecedor = new ArrayList<Fornecedor>(jlfornecedores.getSelectedValuesList());

			try {
				preco = Float.parseFloat(txtpreco.getText());
				Pacote pacote = new Pacote(nome, fornecedor, servicos, preco, descricao);
				central.adicionarPacote(pacote);
				persistencia.salvarCentral(central, "central");
				FabricaJOptionPane.criarMsg("Cadastro Confirmado.");
				tela.dispose();
				TelaMenuADM tela = new TelaMenuADM("Tela Menu");
			} catch (PacoteJaExisteException erro) {
				FabricaJOptionPane.criarMsgErro(erro.getMessage());
			} catch (NumberFormatException floatErro) {
				FabricaJOptionPane.criarMsgErro("Valor invalido digitado");
			}
		}
	}

	public static void main(String[] args) {
		TelaCadastrarPacotes tela = new TelaCadastrarPacotes("TelaCadastro");
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JList<String> getJlservicos() {
		return jlservicos;
	}

	public JList<Fornecedor> getJlfornecedores() {
		return jlfornecedores;
	}

	public JTextField getTxtpreco() {
		return txtpreco;
	}

	public JTextArea getTxtdescricao() {
		return txtdescricao;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnAdicionarFornecedor() {
		return btnAdicionarFornecedor;
	}

	public JButton getBntAdicionarServico() {
		return bntAdicionarServico;
	}

	public ArrayList<String> getServicosDoFornecedor() {
		return servicosDoFornecedor;
	}

	public String[] getServicosArray() {
		return servicosArray;
	}

	public Fornecedor[] getFornecedoresArray() {
		return fornecedoresArray;
	}

}
