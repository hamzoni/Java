package Utility;

import Config.PathConfig;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FileUpload {
    
    public static boolean delete(HttpServletRequest request, String rp) {
        String ap = request.getServletContext().getRealPath(rp);
        try {
            File f = new File(ap) ;
            if(f.exists()) return f.delete();
        } catch (Exception e) {};
        return false;
    }
    
    public static String upload(HttpServletRequest request, String field, String rp)
            throws ServletException, IOException {
        final Part fp = request.getPart(field);
        final String fn = randID() + ".jpg";

        OutputStream os = null;
        InputStream is = null;

        try {
            String ap = request.getServletContext().getRealPath(rp);
            
            os = new FileOutputStream(new File(ap,  fn));
            is = fp.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = is.read(bytes)) != -1)
                os.write(bytes, 0, read);
        
        } catch (FileNotFoundException fne) {
          
        } finally {
            if (os != null) os.close();
            if (is != null) is.close();
        }
        return rp + "/" + fn;
    }

    private static int randID() {
        int randInt = (int) new Date().getTime();
        randInt = (int) (randInt * Math.random() + randInt % 13);
        return Math.abs(randInt);
    }

}
