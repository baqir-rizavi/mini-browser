
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Baqir 4.2.0
 */
public class HyperLinkHandler implements HyperlinkListener {

    PageHolder ph;

    public HyperLinkHandler(PageHolder ph) {
        this.ph = ph;
    }
    
    
    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
            ph.setPage(e.getURL().toString());
        }
    }
    
}
