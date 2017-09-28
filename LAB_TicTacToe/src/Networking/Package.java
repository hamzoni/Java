
package Networking;

import java.io.Serializable;

public class Package implements Serializable {
    public String sender;
    public String receiver;
    
    public Object data;
    public int command;
    
    public static final int CONNECT = 0;
    public static final int USERLIST = 1;
    public static final int INVITE = 2;
    public static final int ACCEPT_INVITE = 3;
    public static final int MAKE_MOVE = 4;
    public static final int EXIT_GAME = 5;
    public static final int CLOSE_CLIENT = 6;
    public static final int CLOSE_SERVER = 7;
    
}
