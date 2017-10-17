
package Networking;

import Entities.User;
import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable {
    public ArrayList<User> usersList;
    public int senderID;
    public int receiverID;
    public User target;
    public User source;
    public int command;
    public Object data;
    
    // CONNECT TO SERVER WHENEVER INITIATE PROGRAM
    public static final int CONNECT_SERVER = 0;
    
    // NOTIFY THE TARGET USER TO OPEN DIALOG AND START CHATTING
    public static final int REQUEST_CHAT = 1;
    
    // UPDATE USER LIST FOR OTHER PLAYERS
    public static final int USER_LIST_SERVER = 2;
    
    // SEND MESSAGE TO TARGET USER
    public static final int SEND_MESSAGE = 3;
    
    // ANNOUNCE SERVER CLOSING
    public static final int SERVER_CLOSING = 5;
    
    // ANNOUNCE CLIENT CLOSING
    public static final int CLIENT_CLOSING = 6;
    
    // CLOSE CHATBOX
    public static final int CANCEL_CHAT = 7;
    
    // REGISTER NEW ACCOUNT
    public static final int CREATE_ACCOUNT = 8;
    
    // REGISTER NEW ACCOUNT
    public static final int LOGIN_ACCOUNT = 9;
}
