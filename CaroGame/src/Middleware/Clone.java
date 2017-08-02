
package Middleware;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clone<T> implements Serializable {
    public static <T> T clone(T x) {
        T y = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.flush();
            out.writeObject(x);
            
            ByteArrayInputStream bis = new   ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            y = (T) in.readObject();
            
            return y;
        } catch (IOException ex) {
            Logger.getLogger(Clone.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return y;
    }
}
