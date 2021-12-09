import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Baqir 4.2.0
 */
public class BtnHandler implements ActionListener {

    MainGUI gui;
    MainGUIController mainCont;

    public BtnHandler(MainGUI gui, MainGUIController mainCont) {
        this.gui = gui;
        this.mainCont = mainCont;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
        if (ae.getActionCommand().equals("GO") || ae.getActionCommand().equals("address"))
            mainCont.goAndAddressPressed(gui.tfAddres.getText());
        if (ae.getActionCommand().equals("back"))
            mainCont.back();
        if (ae.getActionCommand().equals("forward"))
            mainCont.forward();
        if (ae.getActionCommand().equals("addfav"))
            mainCont.addFav();
        if (ae.getActionCommand().equals("home"))
            mainCont.home();
        if (ae.getActionCommand().equals("refresh"))
            mainCont.refresh();
        if (ae.getActionCommand().equals("history"))
            mainCont.history();
        if (ae.getActionCommand().equals("favorities"))
            mainCont.favorities();
        if (ae.getActionCommand().equals("Set Homepage"))
            mainCont.setHome();
        if (ae.getActionCommand().equals("firewall"))
            mainCont.addFirewall();
        if (ae.getActionCommand().equals("manage firewall"))
            mainCont.manageFirewall();
        if (ae.getActionCommand().equals("search"))
            mainCont.search();
    }
}
