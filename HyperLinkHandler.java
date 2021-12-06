
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author Baqir 4.2.0
 */
public class HyperLinkHandler implements HyperlinkListener {

    MainGUIController cont;

    public HyperLinkHandler(MainGUIController cont) {
        this.cont = cont;
    }
    
    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
            cont.goAndAddressPressed(e.getURL().toString());
        }
    }
    
}
