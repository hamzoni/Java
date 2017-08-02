
package Middleware;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Moment {
    public static String getTime(Date date) {
        return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(date);
    }
}
