
package Utility;

import Controller.Private.CategoryDeleteController;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.MapType;

public class Ajax {
    public static String toJson(Object obj) {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(obj);
            json = mapper.writeValueAsString(json);
        } catch (IOException ex) {
            Logger.getLogger(Ajax.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    
    public static Map<String, Object> processXhr(HttpServletRequest req, HttpServletResponse resp) {
        InputStream is = null;
        try {
            is = req.getInputStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buf = new byte[32];
            int r = 0;
            while (r >= 0) {
                r = is.read(buf);
                if (r >= 0) {
                    os.write(buf, 0, r);
                }
            }
            String s = new String(os.toByteArray(), "UTF-8");
            String decoded = URLDecoder.decode(s, "UTF-8");

            final ObjectMapper mapper = new ObjectMapper();
            final MapType type = mapper.getTypeFactory().constructMapType(
                Map.class, String.class, Object.class);
            final Map<String, Object> data = mapper.readValue(decoded, type);
            return data;
        } catch (IOException ex) {
            Logger.getLogger(CategoryDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
