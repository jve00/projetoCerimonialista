package projeto.telas.MenuAdm;

import java.awt.Event;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelos.Fornecedor;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJText;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class TelaCadastrarPacotes extends TelaPadrao{

	private ImagemDeFundo background;
	private JTextField txtNome;
	private JList<String> jlservicos;
	private JList<Fornecedor> jlfornecedores;
	private JTextField txtpreco;
	private JTextField txtdescricao;
	private JButton btnCadastrar;
	private JButton btnAdicionarFornecedor;
	private JButton bntAdicionarServico;
	private ArrayList<String> servicosDoFornecedor;
	private String[] servicosArray;
	private ArrayList<Fornecedor> fornecedores;
	private Fornecedor[] fornecedoresArray;
	
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
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome:", 100, 10, 460, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblfornecedores = FabricaJLabel.criarJLabel("Fornecedores:", 100, 90, 175, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblservicos = FabricaJLabel.criarJLabel("Servicos:", 380, 90, 170, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblValor = FabricaJLabel.criarJLabel("Valor:", 100, 270, 70, 40, FabricasColors.corLabelBranca, 25);
		JLabel lblDetalhePacote = FabricaJLabel.criarJLabel("Detalhes do pacote:", 100, 320, 460, 40, FabricasColors.corLabelBranca, 25);
		
		txtNome = FabricaJText.criarJTextField(100, 50, 460, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o seu Nome aqui", 20);
		txtpreco = FabricaJText.criarJTextField(175, 270, 200, 40, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite o preco aqui", 20);
		txtdescricao = FabricaJText.criarJTextField(100, 370, 460, 80, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca, "Digite os detalhes do pacote aqui", 20);
		
		btnCadastrar = FabricaJButton.criarJButton("Cadastrar Pacote", 380, 270, 200, 40, FabricasColors.corTxtField, FabricasColors.CorRoxo, "Clique aqui para concluir o cadastro", 20);
		
		//Adicionando JList servicos
		servicosDoFornecedor = new ArrayList<String>();
		ArrayList<String> servicos = central.getServicos();
		servicosArray = servicos.toArray(new String[servicos.size()]);
		
		jlservicos = new JList<>(servicosArray);
		jlservicos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane scrollPaneServicos = new JScrollPane(jlservicos);
		scrollPaneServicos.setBounds(370,135,200,120);
		
		//Adicionando JList fornecedores
		fornecedores = new ArrayList<Fornecedor>();
		ArrayList<Fornecedor> arrayFor = central.getTodoOsFornecedores();
		fornecedoresArray = arrayFor.toArray(new Fornecedor[arrayFor.size()]);
		
		jlfornecedores = new JList<>(fornecedoresArray);
		jlfornecedores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane scrollPaneFornecedores = new JScrollPane(jlfornecedores);
		scrollPaneFornecedores.setBounds(100, 135,200 ,120 );
		
		btnCadastrar.addMouseListener(ouvinte);
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
	}
	
	
	
	
	public static void main(String[] args) {
		TelaCadastrarPacotes tela = new TelaCadastrarPacotes("TelaCadastro");
	}
	
	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public void setJlservicos(JList<String> jlservicos) {
		this.jlservicos = jlservicos;
	}

	public void setJlfornecedores(JList<Fornecedor> jlfornecedores) {
		this.jlfornecedores = jlfornecedores;
	}

	public void setTxtpreco(JTextField txtpreco) {
		this.txtpreco = txtpreco;
	}

	public void setTxtdetalhe(JTextField txtdetalhe) {
		this.txtdescricao = txtdetalhe;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public void setBtnAdicionarFornecedor(JButton btnAdicionarFornecedor) {
		this.btnAdicionarFornecedor = btnAdicionarFornecedor;
	}

	public void setBntAdicionarServico(JButton bntAdicionarServico) {
		this.bntAdicionarServico = bntAdicionarServico;
	}

	public void setServicosDoFornecedor(ArrayList<String> servicosDoFornecedor) {
		this.servicosDoFornecedor = servicosDoFornecedor;
	}

	public void setServicosArray(String[] servicosArray) {
		this.servicosArray = servicosArray;
	}

	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void setFornecedoresArray(Fornecedor[] fornecedoresArray) {
		this.fornecedoresArray = fornecedoresArray;
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

	public JTextField getTxtdescricao() {
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

	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public Fornecedor[] getFornecedoresArray() {
		return fornecedoresArray;
	}
}
