package Middleware;

import java.util.Date;

public class Tool {

    public static String dateToSQLstr(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate.toString();
    }
    
    public static Date SQLstrToDate(String sqlDate) {
        return null;
    }
    
}
