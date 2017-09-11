
package FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileController {
    private static final String FN = "data.dat";
    public Object read() {
        ObjectInputStream ios = null;
        try {
            FileInputStream fos = new FileInputStream(FN);
            ios = new ObjectInputStream(fos);
            Object obj = ios.readObject();
            ios.close();
            return obj;
        } catch (IOException ex) {
            try {
                new FileOutputStream(FN);
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean write(Object obj) {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(FN);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
