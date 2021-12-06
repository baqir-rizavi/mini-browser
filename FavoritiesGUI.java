import java.awt.BorderLayout;
import java.util.Stack;
import javafx.util.Pair;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Baqir 4.0.2
 */

public class FavoritiesGUI extends JFrame{
    DefaultListModel<String> model;
    JList<String> fav;
    Stack<Pair<String, String>> fstack;
    JPanel listpan;
    
    
    public FavoritiesGUI(Stack<Pair<String, String>> st) {
        fstack = st;
        initGUI();
    }
    
    public void initGUI()
    {
        setTitle("BROWSER FAVORITIES");
        
        setListpan();
        add(listpan);
        
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    void setListpan(){
        listpan = new JPanel();
        Stack<Pair<String, String>>  temp = new Stack<Pair<String, String>>();
        model = new DefaultListModel<>();
        fav = new JList<String>(model);
        
        while (!fstack.empty())
        {
            model.addElement(fstack.peek().getKey() + " - " + fstack.peek().getValue());
            temp.push(fstack.pop());
        }
        while (!temp.empty())
        {
            fstack.push(temp.pop());
        }
        listpan.add(fav, BorderLayout.CENTER);
        listpan.add(new JScrollPane(fav));
    }
}
