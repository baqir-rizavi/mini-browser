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
    MainGUI gui;
    
    Stack<String> back;
    Stack<String> forward;
    ArrayList<String> firewall;
    Stack<Pair<String, String>> history;
    Stack<Pair<String, String>> favorities;
    String homeURL;
    
    HistoryGUIController hisCont;
    FavoritiesGUIController favCont;
    
    BtnHandler btnHnd;

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
            c =  gui.pghold.loadPage(back.peek());
                forward.push(back.pop());
        }
    }
    void forward(){
        boolean c;
        if (!forward.empty()){
            c = gui.pghold.loadPage(forward.peek());
                back.push(forward.pop());
        }
    }
    void goAndAddressPressed(String url){
        for (String key : firewall) {
            if (url.contains(key))
            {
                JOptionPane.showMessageDialog(null,"page not found","url blocked",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        boolean c = gui.pghold.loadPage(url);
        if (c){
            back.push(url);
            history.push(new Pair(url, getTime()));
        }    
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
    
    //void search() {
//        try{
//      URL url = new URL("http://www.google.com/");
//      //Retrieving the contents of the specified page
//        Scanner sc = new Scanner(url.openStream());
//      //Instantiating the StringBuffer class to hold the result
//      StringBuffer sb = new StringBuffer();
//      while(sc.hasNext()) {
//         sb.append(sc.next());
//         //System.out.println(sc.next());
//      }
//      //Retrieving the String from the String Buffer object
//      String result = sb.toString();
//      System.out.println(result = result.replaceAll("<[^>]*>", ""));
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    
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
        gui.items[0].addActionListener(btnHnd);
        gui.items[1].addActionListener(btnHnd);
        gui.items[2].addActionListener(btnHnd);
    }
    
    void writeData(){
        FileManager.writeIn(FileManager.FileNames.HISTORY, history);
        FileManager.writeIn(FileManager.FileNames.FAVORITIES, favorities);
        FileManager.writeIn(FileManager.FileNames.HOME, homeURL);
        FileManager.writeIn(FileManager.FileNames.FIREWALL, firewall);
        System.out.println("written   hahahahahahahhaha");
    }
    
    void loadData(){
        history = (Stack<Pair<String, String>>)FileManager.readFrom(FileManager.FileNames.HISTORY);
        favorities = (Stack<Pair<String, String>>)FileManager.readFrom(FileManager.FileNames.FAVORITIES);
        homeURL = (String)FileManager.readFrom(FileManager.FileNames.HOME);
        firewall = (ArrayList<String>)FileManager.readFrom(FileManager.FileNames.FIREWALL);
        
        if (history == null){
            history = new Stack<Pair<String, String>>();
        }
        if (favorities == null){
            favorities = new Stack<Pair<String, String>>();
        }
        if (firewall == null){
            firewall = new ArrayList<String>();
        }
        // homeURL can never be null
        System.out.println("Read    hahahhahahahahaha");
    }
}