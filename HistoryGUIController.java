
import java.util.Stack;
import javafx.util.Pair;


/**
 *
 * @author Baqir 4.0.2
 */
public class HistoryGUIController {
    HistoryGUI gui;
    MouseHandler mhnd;
    MainGUIController mainCont;
    
    public HistoryGUIController(Stack<Pair<String, String>> st, MainGUIController mainCont){
        this.mainCont = mainCont;
        gui = new HistoryGUI(st);
        attachHandler();
    }
    
    void attachHandler(){
        mhnd = new MouseHandler(gui.hist, mainCont);
        gui.hist.addMouseListener(mhnd);
    }
}
