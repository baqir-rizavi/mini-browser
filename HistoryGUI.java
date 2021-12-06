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
public class HistoryGUI extends JFrame {

    DefaultListModel<String> model;
    JList<String> hist;
    Stack<Pair<String, String>> hstack;
    JPanel listpan;

    public HistoryGUI(Stack<Pair<String, String>> st) {
        hstack = st;
        initGUI();
    }
    
    public void initGUI()
    {
        setTitle("BROWSER HISTORY");
        
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
        hist = new JList<String>(model);
        while (!hstack.empty())
        {
            model.addElement(hstack.peek().getKey() + " - " + hstack.peek().getValue());
            temp.push(hstack.pop());
        }
        while (!temp.empty())
        {
            hstack.push(temp.pop());
        }
        listpan.add(hist, BorderLayout.CENTER);
        listpan.add(new JScrollPane(hist));
    }
    
    
}
