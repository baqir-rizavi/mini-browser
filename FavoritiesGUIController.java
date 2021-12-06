
import java.util.Stack;
import javafx.util.Pair;


/**
 *
 * @author Baqir 4.0.2
 */
public class FavoritiesGUIController {
    FavoritiesGUI gui;
    MouseHandler mhnd;
    MainGUIController mainCont;
    
    public FavoritiesGUIController(Stack<Pair<String, String>> fav,MainGUIController mainCont){
        this.mainCont = mainCont;
        gui = new FavoritiesGUI(fav);
        attachHandler();
    }
    
    void attachHandler(){
        mhnd = new MouseHandler(gui.fav, mainCont);
        gui.fav.addMouseListener(mhnd);
    }
}
