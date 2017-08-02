
package Networking;

import Entities.Caro;
import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable {
    public ArrayList<Credential> playersInfo;
    public int targetID;
    public int sourceID;
    public Credential target;
    public Credential source;
    public Caro map;
    public int command;
    
    // RETRIEVE PLAYER LIST TO NEW CONNECTED PLAYER
    public static final int REGISTER_TO_SERVER = 0;
    // SEND GAME DATA TO ALL OTHER PLAYERS
    public static final int SEND_DATA_TO_SERVER = 1;
    // UPDATE USER LIST FOR OTHER PLAYERS
    public static final int USER_LIST_SERVER = 2;
    // SEND PLAY REQUEST TO TARGETED PLAEYER
    public static final int REQUEST_PLAY = 3;
    // ACCEPT PLAY REQUEST FROM SOURCE PLAYER
    public static final int ACCEPT_PLAY = 4;
    // PLAYER STOP PLAYING
    public static final int GAME_END = 5;
    // SERVER ACTIVELY CLOSE CONNECTION
    public static final int CLOSE_SERVER = 6;
    // CLIENT ACTIVELY CLOSE CONNECTION
    public static final int EXIT_SERVER = -1;
}
