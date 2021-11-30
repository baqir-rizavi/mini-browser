
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Baqir 4.2.0
 */
public class BtnHandler implements ActionListener {

    MainGUI gui;

    public BtnHandler(MainGUI gui) {
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        gui.pghold.setPage(gui.tfAddress.getText());
    }
    
}
