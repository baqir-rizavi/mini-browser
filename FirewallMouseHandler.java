
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;


/**
 *
 * @author Baqir 4.0.2
 */
public class FirewallMouseHandler implements MouseListener {

    JList<String> list;
    FirewallGUIController fireCont;

    public FirewallMouseHandler(JList<String> list, FirewallGUIController fireCont) {
        this.list = list;
        this.fireCont = fireCont;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String keyword = ((String)list.getModel().getElementAt(list.locationToIndex(e.getPoint())));
        fireCont.actionOnKeyword(keyword);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
