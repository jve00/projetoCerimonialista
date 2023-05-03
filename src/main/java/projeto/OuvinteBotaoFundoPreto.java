package projeto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class OuvinteBotaoFundoPreto implements MouseListener{

  public void mouseClicked(MouseEvent e) {
    
  }

  public void mouseEntered(MouseEvent e) {
    e.getComponent().setForeground(Color.GRAY);
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

  public void mouseExited(MouseEvent e) {
    e.getComponent().setForeground(Color.WHITE);
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
 
  public void mousePressed(MouseEvent e) {
    
  }
  public void mouseReleased(MouseEvent e) {
  
  }
}
