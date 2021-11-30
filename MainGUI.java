
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Baqir 4.2.0
 */
public class MainGUI extends JFrame {
    JTextField tfAddress;
    JButton GOBtn;
    BtnHandler btnHnd;
    HyperLinkHandler linkHnd;
    PageHolder pghold;

    public MainGUI() {
        initGUI();
    }
    
    public void initGUI(){
        setLayout(new FlowLayout());
        
        btnHnd = new BtnHandler(this);
        tfAddress = new JTextField();
        GOBtn = new JButton("GO");
        pghold = new PageHolder();
        linkHnd = new HyperLinkHandler(pghold);
        
        pghold.addHyperlinkListener(linkHnd);
        tfAddress.addActionListener(btnHnd);
        GOBtn.addActionListener(btnHnd);
        
        getContentPane().setLayout(new FlowLayout());
        
        add(tfAddress);
        add(GOBtn);
        add(pghold);
        add(new JScrollPane(pghold));
        
        tfAddress.setSize(70, 30);
        
        setSize(550,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
