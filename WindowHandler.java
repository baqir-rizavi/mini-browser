
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 *
 * @author Baqir 4.0.2
 */

public class WindowHandler extends WindowAdapter {
    
    ApplicationController appCont;

    public WindowHandler(ApplicationController appCont) {
        this.appCont = appCont;
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        appCont.writeData();
        super.windowClosing(e);
    }
}
