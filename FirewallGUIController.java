
import java.util.ArrayList;


/**
 *
 * @author Baqir 4.0.2
 */

public class FirewallGUIController {
    FirewallGUI gui;
    ArrayList<String> arrf;
    FirewallMouseHandler mhnd;
    
    
    public FirewallGUIController(ArrayList<String> arrf) {
        this.arrf = arrf;
        initCont();
    }
    
    void initCont()
    {
        gui = new FirewallGUI(arrf);
        mhnd = new FirewallMouseHandler(gui.blocklist, this);
        attachHandler();
    }
    
    void attachHandler(){
        gui.blocklist.addMouseListener(mhnd);
    }
    
    void actionOnKeyword(String key){
        if (gui.deleteCheck.isSelected()){
            arrf.remove(key);
            gui.model.removeElement(key);
            System.out.println("sould be removed");
        }
            
    }
}
