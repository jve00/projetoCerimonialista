package projeto;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import ultilidades.imagens.Imagens;

public abstract class TelaPadrao extends JFrame {

	public TelaPadrao(String titulo) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {

		}
		configTela(titulo);
		configurarComponentes();

	}

	public abstract void configurarComponentes();

	public ImagemDeFundo configImagemFundo(String caminho) {
		ImagemDeFundo background = new ImagemDeFundo(caminho);
		background.setLayout(null);
		background.setBounds(0, 0, 700, 500);
		return background;
	}
	private void configTela(String titulo) {
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(titulo);
	}
}