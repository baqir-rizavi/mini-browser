
/**
 *
 * @author Baqir 4.0.2
 */
public class ApplicationController {
    
    MainGUIController mc;
           
    
    public ApplicationController() {
        FileManager.initFiles();
        mc = new MainGUIController(this);
        loadData();
    }
    
    void loadData(){
        mc.loadData();
        
    }
    void writeData(){
        mc.writeData();
    }
}
