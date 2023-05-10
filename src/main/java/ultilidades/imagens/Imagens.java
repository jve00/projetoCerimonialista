package ultilidades.imagens;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagens {

  private static Icon importarImagem(String caminho) {
	  ImageIcon icone = new ImageIcon(caminho);
	  return icone;
  }
  public static final ImageIcon SETA = (ImageIcon) Imagens.importarImagem("img/seta.png");
  public static final ImageIcon CADASTROS = (ImageIcon) Imagens.importarImagem("img/btnCadastrar.png");
  public static final ImageIcon FORNECEDORES = (ImageIcon) Imagens.importarImagem("img/btnFornecedores.png");
  public static final ImageIcon SERVICOS = (ImageIcon) Imagens.importarImagem("img/btnEditarServicos.png");

}
 