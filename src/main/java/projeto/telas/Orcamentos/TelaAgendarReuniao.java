package projeto.telas.Orcamentos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import ultilidades.fabricas.FabricaJButton;
import ultilidades.fabricas.FabricaJFormatted;
import ultilidades.fabricas.FabricaJLabel;
import ultilidades.fabricas.FabricaJTextArea;
import ultilidades.fabricas.FabricasColors;

public class TelaAgendarReuniao extends TelaPadrao {

	private ImagemDeFundo background;
	private JLabel lblChooser;
	private JDateChooser chooser;
	private JTextField txtHora;
	private JButton btnEnviarEmail;
	private JTextArea txtAreaAssunto;

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

	public void configTela() {
		OuvinteBotaoFundoPreto ouvinte = new OuvinteBotaoFundoPreto();
		JLabel lblTitulo = FabricaJLabel.criarJLabel("Agendar Reuniao. ", 235, 20, 250, 25,
				FabricasColors.corLabelBranca, 25);
		JLabel lblData = FabricaJLabel.criarJLabel("Data: ", 100, 120, 250, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora: ", 330, 120, 250, 25, FabricasColors.corLabelBranca, 20);
		JLabel lblAssunto = FabricaJLabel.criarJLabel("Assunto tratado na reuniao: ", 100, 215, 250, 25,
				FabricasColors.corLabelBranca, 17);

		txtAreaAssunto = FabricaJTextArea.criarJTextArea(100, 240, 450, 150, FabricasColors.corTxtField,
				FabricasColors.corLabelBranca);
		btnEnviarEmail = FabricaJButton.criarJButton("Enviar Email", 420, 160, 120, 35, FabricasColors.corLabelBranca,
				FabricasColors.CorRoxo, "Clique aqui para enviar um email para o cliente com as informacoes da reuniao",
				16);

		try {
			txtHora = FabricaJFormatted.criarJFormatted(165, 120, 80, 30, new MaskFormatter("##:##"),
					FabricasColors.corTxtField, FabricasColors.corLabelBranca, "Digite a hora do Evento aqui");
		} catch (Exception e) {
		}

		btnEnviarEmail.addMouseListener(ouvinte);
		btnEnviarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		background.add(btnEnviarEmail);
		background.add(lblTitulo);
		background.add(lblHora);
		background.add(lblChooser);
		background.add(lblData);
		background.add(txtAreaAssunto);
		background.add(lblAssunto);
		background.add(txtHora);
	}

	public static void main(String[] args) {
		new TelaAgendarReuniao("");
	}
}
