import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author Baqir 4.0.2
 */

public class FirewallGUI extends JFrame {
    DefaultListModel<String> model;
    JList<String> blocklist;
    ArrayList<String> firewall;// <---these are the keywords loaded from a file
    JPanel listpan;
    JRadioButton deleteCheck;

    public FirewallGUI(ArrayList<String> st) {
        firewall = st;
        initGUI();
    }
    
    public void initGUI()
    {
        setTitle("BROWSER FIREWALL KEYS");
        
        deleteCheck = new JRadioButton("<- delete?");
        add(deleteCheck, BorderLayout.NORTH);
        
        setListpan();
        add(listpan, BorderLayout.CENTER);
        
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    void setListpan(){
        listpan = new JPanel();
        model = new DefaultListModel<>();
        blocklist = new JList<String>(model);
        for (String key : firewall) { // for-each loop
            model.addElement(key);
        }
        listpan.add(blocklist, BorderLayout.CENTER);
        listpan.add(new JScrollPane(blocklist));
    }   
}