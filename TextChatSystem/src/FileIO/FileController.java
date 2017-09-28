package FileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileController {

    public <T> void write(ArrayList<T> objects, String fn) {
        
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream(fn);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objects);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    public Object read(String fn) {
        Object data = null;
        try {
            
            FileInputStream fis = null;
            fis = new FileInputStream(fn);
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = ois.readObject();
            ois.close();
            fis.close();
            
            return data;
        } catch (FileNotFoundException ex) {
            System.out.println("File " + fn + " not found.");
        } catch (IOException ex) {
            System.out.println("Unable to read file.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
