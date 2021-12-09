import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;
import javafx.util.Pair;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Baqir 4.2.0
 */

public class MainGUIController {
    ApplicationController appCont;
    HistoryGUIController hisCont;
    FavoritiesGUIController favCont;
    FirewallGUIController fireCont;
    
    MainGUI gui;
    BtnHandler btnHnd;
    String homeURL;
    
    Stack<String> back;
    Stack<String> forward;
    ArrayList<String> firewall;
    Stack<Pair<String, String>> history;
    Stack<Pair<String, String>> favorities;
    

    public MainGUIController(ApplicationController appCont) {
        this.appCont = appCont;
        initCont();
        
    }
    void initCont(){
        gui = new MainGUI(this);
        gui.addWindowListener(new WindowHandler(appCont));
        attachBtnHandler();
        back = new Stack<String>();
        forward = new Stack<String>();
        firewall = new ArrayList<String>();
        history = new Stack<Pair<String, String>>();
        favorities = new Stack<Pair<String, String>>();
    }
    
    void back(){
        boolean c; 
        if (!back.empty()){
                forward.push(gui.pghold.currentURL);
                gui.forward.setEnabled(true);
            c =  gui.pghold.loadPage(back.pop());
            if (back.empty())
                gui.back.setEnabled(false);
        }
    }
    
    void forward(){
        boolean c;
        if (!forward.empty()){
                back.push(gui.pghold.currentURL);
                gui.back.setEnabled(true);
            c = gui.pghold.loadPage(forward.pop());
            if (forward.empty())
                gui.forward.setEnabled(false);
        }
    }
    
    void search(){
        String text = gui.pghold.getText().replaceAll("<[^>]*>", "").replaceAll("(?m)^[ \t]*\r?\n", "");
        String toSearch = JOptionPane.showInputDialog(null, "enter what you want to search:", "search the page", JOptionPane.QUESTION_MESSAGE);
        int occurrence = 0;
        if (toSearch != null){
            if (toSearch.length() != 0)
                occurrence = (text.length() - text.replaceAll(toSearch, "").length()) / toSearch.length();
            JOptionPane.showMessageDialog(null, occurrence + " ocurrences found", "FOUND", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void goAndAddressPressed(String url){
        
        String prevURL = gui.pghold.currentURL;
        
        if (prevURL.equals(url))
            return;
        
        boolean c = gui.pghold.loadPage(url);
        if (c){
            back.push(prevURL);
            gui.back.setEnabled(true);
            history.push(new Pair(url, getTime()));
        }
        else
        {
            System.out.println("unloadable site: " + url);
        }
    } 

    boolean firewallCheckURL(String url) {
        if (!(boolean)FileManager.readFrom(FileManager.FileNames.ENABLE_FIREWALL_CHECK))
            return false;
        for (String key : firewall) {
            if (url.contains(key)) {
                JOptionPane.showMessageDialog(null,"page was blocked by firewall","url blocked",JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }
    
    void addFav(){
        String input = JOptionPane.showInputDialog(null, "page added to favorities\nEnter title:", "add favorite", JOptionPane.QUESTION_MESSAGE);
        if (input != null){
            favorities.push(new Pair(gui.pghold.currentURL, input));
        }  
    } 
    
    void home(){
        goAndAddressPressed(homeURL);    
    }

    void refresh(){
        gui.pghold.loadPage(gui.pghold.currentURL);
    }
    
    String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);  
    }
        
    void history(){
        hisCont = new HistoryGUIController(history, this);
    }
    
    void favorities(){
        favCont = new FavoritiesGUIController(favorities, this);
    }
    
    void addFirewall(){
        String value = JOptionPane.showInputDialog(null, "Enter key word to block", "firewall", JOptionPane.QUESTION_MESSAGE);
        if (value != null && !value.equals(""))
        {
            firewall.add(value);
        }
    }
    
    void manageFirewall(){
        fireCont = new FirewallGUIController(firewall);
    }
    
    void setHome()
    {
        String value = JOptionPane.showInputDialog(null, "Enter URL of the page:", "Set Homepage", JOptionPane.QUESTION_MESSAGE);
        if (value != null && !value.equals(""))
        {
            homeURL = value;
        }
    }
    
    
    void attachBtnHandler()
    {
        btnHnd = new BtnHandler(gui, this);
        gui.back.addActionListener(btnHnd);
        gui.forward.addActionListener(btnHnd);
        gui.home.addActionListener(btnHnd);
        gui.refresh.addActionListener(btnHnd);
        gui.addFav.addActionListener(btnHnd);
        gui.tfAddres.addActionListener(btnHnd);
        gui.GObtn.addActionListener(btnHnd);
        gui.firewall.addActionListener(btnHnd);
        gui.search.addActionListener(btnHnd);
        
        gui.items[0].addActionListener(btnHnd);
        gui.items[1].addActionListener(btnHnd);
        gui.items[2].addActionListener(btnHnd);
        gui.items[3].addActionListener(btnHnd);
    }
    
    void writeData(){
        FileManager.writeIn(FileManager.FileNames.HISTORY, history);
        FileManager.writeIn(FileManager.FileNames.FAVORITIES, favorities);
        FileManager.writeIn(FileManager.FileNames.HOME, homeURL);
        FileManager.writeIn(FileManager.FileNames.FIREWALL, firewall);
    }
    
    void loadData(){
        history = (Stack<Pair<String, String>>)FileManager.readFrom(FileManager.FileNames.HISTORY);
        favorities = (Stack<Pair<String, String>>)FileManager.readFrom(FileManager.FileNames.FAVORITIES);
        homeURL = (String)FileManager.readFrom(FileManager.FileNames.HOME);
        firewall = (ArrayList<String>)FileManager.readFrom(FileManager.FileNames.FIREWALL);
        
        
        // these can be null when app is loaded for the first time
        if (history == null){
            history = new Stack<Pair<String, String>>();
        }
        if (favorities == null){
            favorities = new Stack<Pair<String, String>>();
        }
        if (firewall == null){
            firewall = new ArrayList<String>();
        }
        
        // homeURL can never be null (see FileManager class), so load it
        gui.pghold.loadPage(homeURL);
    }
}