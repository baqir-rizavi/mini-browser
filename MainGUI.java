import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Baqir 4.2.0
 */ 
public class MainGUI extends JFrame {
    JPanel topArea, pageArea;
    
    JMenuBar bar;
    JMenu options;
    JMenuItem[] items;
    
    JTextField tfAddres;
   
    PageHolder pghold;
    
    JButton back,forward,refresh,home,GObtn, addFav, firewall;
    
    MainGUIController mainCont;

    public MainGUI(MainGUIController mainCont) {
        this.mainCont = mainCont;
        initGUI();
    }
    
    public void initGUI(){
        setTitle("BROWSER");
 
        setTopArea();
        add(topArea, BorderLayout.NORTH);
        
        setPageArea();
        add(pageArea, BorderLayout.CENTER);
        
        setMenuBar();
        setJMenuBar(bar);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void setTopArea(){
        topArea = new JPanel(new FlowLayout());
        
        // button icons
        topArea.add(back = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("arrow.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT))));
        topArea.add(forward = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("right-arrow.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT))));
        topArea.add(refresh = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("refresh.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT))));
        topArea.add(home = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("home.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT))));
        topArea.add(addFav = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("star.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT))));
        topArea.add(firewall = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("firewall.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT))));

        back.setPreferredSize(new Dimension(30,30));
        forward.setPreferredSize(new Dimension(30,30));
        home.setPreferredSize(new Dimension(30,30));
        refresh.setPreferredSize(new Dimension(30,30));
        addFav.setPreferredSize(new Dimension(30,30));
        firewall.setPreferredSize(new Dimension(30,30));
        
        back.setActionCommand("back");
        forward.setActionCommand("forward");
        home.setActionCommand("home");
        refresh.setActionCommand("refresh");
        addFav.setActionCommand("addfav");
        firewall.setActionCommand("firewall");
        //-----------
        
        // address bar
        topArea.add(tfAddres = new JTextField());
        tfAddres.setPreferredSize(new Dimension(400,30));
        tfAddres.setActionCommand("address");
        
        // go button
        topArea.add(GObtn = new JButton("GO"));
        
    }
    
    void setMenuBar(){
        bar = new JMenuBar();
        options = new JMenu("Options");
        items = new JMenuItem[3];
        
        items[0] = new JMenuItem("history");
        items[1] = new JMenuItem("favorities");
        items[2] = new JMenuItem("Set Homepage");
        
        bar.add(options);
        options.add(items[0]);
        options.add(items[1]);
        options.add(items[2]);
    }
    
    void setPageArea(){
        pageArea = new JPanel();
        pageArea.add(pghold = new PageHolder(mainCont));
        pageArea.add(new JScrollPane(pghold));
        
    }

}
