import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Baqir 4.2.0
 */

public class PageHolder extends JEditorPane {
    

    String currentURL = "";
    HyperLinkHandler linkHnd;
    MainGUIController mainCont;

    public PageHolder(MainGUIController mainCont) {
        this.mainCont = mainCont;
        setEditable(false);
        linkHnd = new HyperLinkHandler(mainCont);
        addHyperlinkListener(linkHnd);
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 20, 
                Toolkit.getDefaultToolkit().getScreenSize().height - 150));
    }
    
    public boolean loadPage(String url){
            try {
                mainCont.gui.tfAddres.setText(url);
                setPage(url);
                currentURL = url;
                
                addPropertyChangeListener(null);
                //mainCont.search();
                
            }
            catch(IOException ioexp){
                JOptionPane.showMessageDialog(null,"page not found","bad url",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
    }
}
