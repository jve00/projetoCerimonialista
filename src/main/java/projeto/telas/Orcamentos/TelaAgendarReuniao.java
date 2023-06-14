package projeto.telas.Orcamentos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.exceptions.ReuniaoJaCadastradaException;
import projeto.modelos.Reuniao;
import ulitilidades.persistencia.Persistencia;
import ulitlidades.email.Mensageiro;
import ulitlidades.validacao.Validador;
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJFormatted;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricasColors;
import ultilidades.reporsitorio.CentralDeInformacoes;

/**
 * @author User
 *
 */
public class TelaAgendarReuniao extends TelaPadrao {

	private ImagemDeFundo background;
	private JLabel lblChooser;
	private JDateChooser chooser;
	private JTextField txtHora;
	private JButton btnEnviarEmail;
	private JTextArea txtAreaAssunto;
	private JButton btnComecarReuniao;
	private JButton btnAdiconarAssunto;
	private Persistencia p;
	private CentralDeInformacoes central;

	public TelaAgendarReuniao(String titulo) {
		super(titulo);
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configurarDateChooser();
		configTela();
	}

	public void configImagemFundo() {
		background = super.configImagemFundo("background.png");
		add(background);

	}

	private void configurarDateChooser() {
		chooser = new JDateChooser(new Date());
		lblChooser = new JLabel();
		lblChooser.setLayout(null);
		lblChooser.setBounds(350, 113, 200, 40);
		chooser.setBounds(40, 10, 152, 25);
		chooser.setForeground(Color.black);
		chooser.setFont(new Font("Arial", 1, 13));

		lblChooser.add(chooser);
	}

	private class OuvinteBotaoEnviarEmail implements ActionListener {

		public OuvinteBotaoEnviarEmail(String titulo, TelaAgendarReuniao tela) {
			this.tela = tela;
		}

		private TelaAgendarReuniao tela;

		public void actionPerformed(ActionEvent e) {
			Object componente = e.getSource();
			Persistencia p = new Persistencia();
			central = p.recuperarCentral("central");
			String hora = getTxtHora().getText();
			Date data = getChooser().getDate();
			int linhaSelecionada = TelaListarOrcamentos.tabelaDeOrcamentos.getSelectedRow();
			String emailSelecionado = (String) TelaListarOrcamentos.tabelaDeOrcamentos.getValueAt(linhaSelecionada, 0);
			try {
				boolean horaValida = Validador.validarHora(hora);
				LocalTime horaAtual = LocalTime.now();
				LocalTime horaConvertida = LocalTime.parse(hora);

				if (horaValida && data != null) {
					central.adicionarReuniao(new Reuniao(data, horaConvertida, "", emailSelecionado));
					p.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Reuniao Cadastrada, Os dados foram enviados para o email do cliente.");
				} else {
					FabricaJOptionPane.criarMsgErro("Esse cliente nao existe no nosso sistema.");
				}
			} catch (Exception e1) {
				FabricaJOptionPane.criarMsgErro(e1.getMessage());
			}
		}
	}

	public void configTela() {
		OuvinteBotaoEnviarEmail ouvinteEnviarEmail = new OuvinteBotaoEnviarEmail("", this);
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		JLabel lblTitulo = FabricaJLabel.criarJLabel("Agendar Reuniao. ", 235, 20, 250, 25,
				FabricasColors.corLabelBranca, 25);
		JLabel lblData = FabricaJLabel.criarJLabel("Data: ", 100, 120, 250, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora: ", 330, 120, 250, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblAssunto = FabricaJLabel.criarJLabel(
				"<html> Ao clicar no botao para comecar a reuniao, voce podera <br> especificar oque esta sendo tratado na reuniao<br> <html>",
				100, 270, 500, 35, FabricasColors.corLabelBranca, 13);

		btnEnviarEmail = FabricaJButton.criarJButton("Enviar Email", 410, 160, 120, 35, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para enviar um email para o cliente com as informacoes da reuniao",
				16);
		btnComecarReuniao = FabricaJButton.criarJButton("Comecar reuniao", 250, 410, 140, 35,
				FabricasColors.corLabelBranca, FabricasColors.CorRoxo, "Clique aqui para comecar a reuniao", 16);
		try {
			txtHora = FabricaJFormatted.criarJFormatted(165, 120, 80, 30, new MaskFormatter("##:##"),
					FabricasColors.corTxtField, FabricasColors.corLabelBranca, "Digite a hora do Evento aqui");
		} catch (Exception e) {
		}

		btnEnviarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = TelaListarOrcamentos.tabelaDeOrcamentos.getSelectedRow();
				String emailSelecionado = (String) TelaListarOrcamentos.tabelaDeOrcamentos.getValueAt(linhaSelecionada,
						0);
				if (linhaSelecionada != -1) {
					System.out.println(emailSelecionado);
					Mensageiro.enviarMensagemDados(central.recuperarClientePorEmail(emailSelecionado));
				} else {
					FabricaJOptionPane.criarMsgErro("Selecione uma linha");
				}
			}
		});
		btnComecarReuniao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object componente = e.getSource();
				String assunto = FabricaJOptionPane.criarInput("digite oque esta sendo tratado na reuniao");
				int linhaSelecionada = TelaListarOrcamentos.tabelaDeOrcamentos.getSelectedRow();
				String emailSelecionado = (String) TelaListarOrcamentos.tabelaDeOrcamentos.getValueAt(linhaSelecionada, 0);
				try {
					Thread.sleep(1 * 60 * 1000);
					String hora = getTxtHora().getText();
					Date data = getChooser().getDate();
					central.getTodasAsReunioes().remove(central.recuperarReuniao(emailSelecionado));
					central.adicionarReuniao(
							new Reuniao(getChooser().getDate(), LocalTime.parse(hora), assunto, emailSelecionado));
					p.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Dados doque foi tratado Salvo com Sucesso.");
					dispose();
				} catch (ReuniaoJaCadastradaException e1) {
					System.out.println(e1.getMessage());
				} catch (InterruptedException e1) {
					FabricaJOptionPane.criarMsgErro("Erro na execursao");
				}
			}
		});
		btnEnviarEmail.addActionListener(ouvinteEnviarEmail);
		btnEnviarEmail.addMouseListener(ouvinte);
		btnComecarReuniao.addMouseListener(ouvinte);
		background.add(btnEnviarEmail);
		background.add(btnComecarReuniao);
		background.add(lblTitulo);
		background.add(lblHora);
		background.add(lblChooser);
		background.add(lblData);
		background.add(lblAssunto);
		background.add(txtHora);
	}

	public static void main(String[] args) {
		new TelaAgendarReuniao("");
	}

	public JTextField getTxtHora() {
		return txtHora;
	}

	public JButton getBtnAdiconarAssunto() {
		return btnAdiconarAssunto;
	}

	public JTextArea getTxtAreaAssunto() {
		return txtAreaAssunto;
	}

	public JDateChooser getChooser() {
		return chooser;
	}

	public JButton getBtnComecarReuniao() {
		return btnComecarReuniao;
	}

	public void setTxtAreaAssunto(JTextArea txtAreaAssunto) {
		this.txtAreaAssunto = txtAreaAssunto;
	}

}
