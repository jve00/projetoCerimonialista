package ultilidades.fabricas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public abstract class FabricaJText {

	public static JTextField criarJTextField(int x, int y, int largura, int altura,
		Color corFundo, Color corLetra, int tamanhoLetra) {
		
		JTextField txt = new JTextField();
	    txt.setBounds(x, y, largura, altura);
	    txt.setBackground(corFundo);
	    txt.setForeground(corLetra);
	    txt.setBorder(BorderFactory.createLineBorder(corLetra));
	    txt.setFont(new Font("Arial", 1, tamanhoLetra));
	    
	    return txt;
	}
	
	public static JPasswordField criarJPasswordField(int x, int y, int largura, int altura,
			Color corFundo, Color corLetra, int tamanhoLetra) {
		
		JPasswordField pass = new JPasswordField();
		pass.setBounds(x, y, largura, altura);
		pass.setBackground(corFundo);
		pass.setForeground(corLetra);
		pass.setBorder(BorderFactory.createLineBorder(corLetra));
		pass.setFont(new Font("Arial", 1, tamanhoLetra));
	    
		return pass;
	}
	
	
}
