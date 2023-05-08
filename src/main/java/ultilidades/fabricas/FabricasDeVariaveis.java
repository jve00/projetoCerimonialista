package ultilidades.fabricas;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import projeto.ImagemDeFundo;

public abstract class FabricasDeVariaveis {
	
	 private static Icon importarImagem(String caminho) {
		  ImageIcon icone = new ImageIcon(caminho);
		  return icone;
	  }
	public static ImagemDeFundo background;
	public static final ImageIcon SETA = (ImageIcon) FabricasDeVariaveis.importarImagem("seta.png");
}
