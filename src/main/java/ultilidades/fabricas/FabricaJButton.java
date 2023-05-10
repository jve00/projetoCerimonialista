package ultilidades.fabricas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//Classe Fabrica para centralizar a cria��o de JButton
public abstract class FabricaJButton {

	//metodo estatico para criar um JButton recebendo os paramentros (texto, posi��o eixo x, posi��o eixo y, a largura, a altura, a cor de fundo,  )
	public static JButton criarJButton(String texto, int x, int y, int largura, int altura, Color corFundo,
			Color corLetra, String msgTexto,  int tamanhoLetra) {

		
		JButton btn = new JButton(texto);
		btn.setBounds(x, y, largura, altura);
		btn.setFont(new Font("Arial", 1, tamanhoLetra));
		btn.setBackground(corFundo);
		btn.setForeground(corLetra);
		btn.setFocusable(false);
		btn.setBorder(null);
		btn.setOpaque(true);
		btn.setToolTipText(msgTexto);

		return btn;
	}

	public static JButton criarJButton(String texto, ImageIcon img, int x, int y, int largura, int altura, String msgTexto) {

		JButton btn = new JButton();
		btn.setBounds(x, y, largura, altura);
		btn.setText(texto);
		btn.setIcon(img);
		btn.setContentAreaFilled(false);
		btn.setFocusable(false);
		btn.setBorder(null);
		btn.setOpaque(false);
		btn.setToolTipText(msgTexto);

		return btn;
	}
}
