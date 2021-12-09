import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import jdk.management.resource.internal.ApproverGroup;

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
    JRadioButton enableCheck;

    public FirewallGUI(ArrayList<String> st) {
        firewall = st;
        initGUI();
    }
    
    public void initGUI()
    {
        setTitle("BROWSER FIREWALL KEYS");
        setLayout(new FlowLayout());
        deleteCheck = new JRadioButton("<- delete?");
        enableCheck = new JRadioButton("<- enable/disable", (boolean)FileManager.readFrom(FileManager.FileNames.ENABLE_FIREWALL_CHECK));
        setCheckHandler();
        add(deleteCheck, BorderLayout.NORTH);        
        add(enableCheck, BorderLayout.NORTH);        
        
        setListpan();
        add(listpan, BorderLayout.CENTER);
        
        add(new JLabel("that is your blockList\n [check the \"delete\" option to delete any keywords]"));
        
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
    void setCheckHandler(){
        enableCheck.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                    FileManager.writeIn(FileManager.FileNames.ENABLE_FIREWALL_CHECK, true);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    FileManager.writeIn(FileManager.FileNames.ENABLE_FIREWALL_CHECK, false);
                    System.out.println("fucku");

                }
            }
        });
    }
}