
package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIO {
    public <T> void write(T data, String fn) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(fn));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + fn);
        } catch (IOException ex) {
            System.out.println("Unable to write: " + fn);
        }
    }
    
    public <T> T read(String fn) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(fn));
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            T d =  (T) ois.readObject();
            ois.close();
            fis.close();
            
            return d;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + fn);
        } catch (IOException ex) {
            System.out.println("Unable to read: " + fn);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return null;
    }
    
}
