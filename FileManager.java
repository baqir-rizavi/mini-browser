import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author Baqir 4.0.2
 */

public class FileManager {
    
    static class FileNames {
        static String HOME = "home.txt";
        static String HISTORY = "history.txt";
        static String FAVORITIES = "favorities.txt";
        static String FIREWALL = "firewall.txt";
    }
    
    private static String DEFAULT_HOME_URL = "http://rizavi.yolasite.com/";
    
    public static void initFiles()
    {
        if(!new File(FileNames.HOME).exists() || !new File(FileNames.HISTORY).exists() || !new File(FileNames.FAVORITIES).exists())
        {
            writeIn(FileNames.HOME, DEFAULT_HOME_URL);
            writeIn(FileNames.HISTORY, null);
            writeIn(FileNames.FAVORITIES, null);
        }
    }
    
    public static void writeIn(String name, Object o)
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(name)));
            oos.writeObject(o);
            oos.close();
        } 
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Object readFrom(String name)
    {
        Object temp = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(name)));
            temp = ois.readObject(); 
            ois.close();
        } 
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return temp;
    }
    
}