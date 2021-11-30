import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Baqir 4.2.0
 */

public class PageHolder extends JEditorPane {

    public PageHolder() {
        setEditable(false);
        setPreferredSize(new Dimension(1900, 1080));
    }
    
    @Override
    public void setPage(String url){
        try {
                super.setPage(url);
            }
            catch(IOException ioexp){
                JOptionPane.showMessageDialog(null,"page not found","bad url",JOptionPane.ERROR_MESSAGE);    
            }
    }
}
