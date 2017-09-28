
package Networking;

import Entities.User;
import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable {
    public ArrayList<User> usersList;
    public User target;
    public User source;
    public int command;
    public Object data;
    
    // RETRIEVE PLAYER LIST TO NEW CONNECTED PLAYER
    public static final int REGISTER_TO_SERVER = 0;

    // NOTIFY THE TARGET USER TO OPEN DIALOG AND START CHATTING
    public static final int REQUEST_CHAT = 1;
    
    // UPDATE USER LIST FOR OTHER PLAYERS
    public static final int USER_LIST_SERVER = 2;
    
    // SEND MESSAGE TO TARGET USER
    public static final int SEND_MESSAGE = 3;
    
    // RECEIVE MESSAGE FROM SERVER
    public static final int RECEIVE_MESSAGE = 4;
    
    // ANNOUNCE SERVER CLOSING
    public static final int SERVER_CLOSING = 5;
    
    // ANNOUNCE CLIENT CLOSING
    public static final int CLIENT_CLOSING = 6;
}
