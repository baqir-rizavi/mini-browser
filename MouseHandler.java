
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;

/**
 *
 * @author Baqir 4.0.2
 */
public class MouseHandler implements MouseListener {

    JList<String> list;
    MainGUIController mainCont;

    public MouseHandler(JList<String> list, MainGUIController mainCont) {
        this.list = list;
        this.mainCont = mainCont;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        String url = (((String)list.getModel().getElementAt(list.locationToIndex(e.getPoint()))).split(" "))[0]; // get url from list
        mainCont.goAndAddressPressed(url);
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
