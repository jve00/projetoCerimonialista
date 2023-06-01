package ultilidades.fabricas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

public class FabricaJRadionButton {

	public static JRadioButton criarRadionButton(String texto, int x, int y, int largura, int altura,
			Color corLetra, String msgTexto, int tamanhoLetra) {
		JRadioButton jradioButton = new JRadioButton();
		jradioButton.setText(texto);
		jradioButton.setBounds(x, y, largura, altura);
		jradioButton.setFont(new Font("Arial", 1, tamanhoLetra));
		jradioButton.setForeground(corLetra);
		jradioButton.setFocusable(true);
		jradioButton.setBorder(null);
		jradioButton.setToolTipText(msgTexto);

		return jradioButton;
	}

}
