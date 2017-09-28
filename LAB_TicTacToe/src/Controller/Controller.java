
package Controller;

import Action.*;
import GUI.*;
import Networking.Client;
import Networking.Package;
import Networking.Server;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller extends Thread {
    
    public String me;
    
    private UserList home;
    private DialogLogin dlgLg;
    
    private DialogLoginEvents dlgLgCtrl;
    private UserListEvents homeCtrl;
    public HashMap<Integer, DialogInviteEvents> dlgInvCtrls;
    public HashMap<Integer, DialogPlayEvents> dlgPlayCtrls;
    
    public Server server;
    public Client client;
    
    private static ArrayList<String> usersList;
    
    public static void main(String[] args) {
        new Controller().start();
    }

    public Controller() {
        setDAT();
        setGUI();
    }
    
    public void run() {
        dlgLg.setVisible(true);
    }
    
    private void setDAT() {
        usersList = new ArrayList<String>();
    }
    
    private void setGUI() {
        home = new UserList();
        dlgLg = new DialogLogin();
        dlgInvCtrls = new HashMap<Integer, DialogInviteEvents>();
        dlgPlayCtrls = new HashMap<Integer, DialogPlayEvents>();
        
        dlgLgCtrl = new DialogLoginEvents<DialogLogin>(this, dlgLg);
        homeCtrl = new UserListEvents<UserList>(this, home);
    }
    
    /* Action coming from UI */
    public void exitGame() { // System exit
        if (server.getSocket() != null) {
            server.close();
        } else {
            if (client != null) {
                client.send(null, null, Package.CLOSE_CLIENT);
            }
        }
    }
    
    public void exitGame(String receiver, GameData game) { // Game exit
        if (client != null) {
            client.send(receiver, game, Package.EXIT_GAME);
        }
    }
    
    public void playerMove(String receiver, GameData game) {
        client.send(receiver, game, Package.MAKE_MOVE);
    }
    
    // Call from dialog invite events
    public void acceptInvite(String sender, int cols, int rows) {
        GameData game = new GameData(cols, rows);
        game.setPlayerA(sender);
        game.setPlayerB(me);
        game.setGameID(randID());
        
        createBoard(GameData.TURNO, game, sender);
        
        client.send(sender, game, Package.ACCEPT_INVITE);
    }
    
    public void createBoard(int turn, GameData game, String opponent) {
        DialogPlay dlgPl = new DialogPlay();
        DialogPlayEvents dlgPlC = new DialogPlayEvents(this, dlgPl);

        dlgPlC.setGame(game);
        dlgPlC.setTurn(turn);
        dlgPlC.setOpponent(opponent);
        dlgPlC.setComponent();
        
        dlgPlayCtrls.put(game.getGameID(), dlgPlC);
        dlgPl.setVisible(true);
    }
    
    public void invitePlayer(String receiver, GameConfig gcf) {
        client.send(receiver, gcf, Package.INVITE);
    }
    
    public void setNWC(String username) {
        this.me = username;
        
        server = new Server();
        client = new Client(username);
        client.setController(this);
        
        new Thread(server).start();
        new Thread(client).start();
        
        dlgLg.setVisible(false);
        home.setVisible(true);
    }
    
    /* Action coming from Client socket */
    public void clearUserBoards(String sender) {
        // Remove current active invitations
        Iterator it = dlgInvCtrls.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int gameID = (int) pair.getKey();
            DialogInviteEvents dlgi = (DialogInviteEvents) pair.getValue();
            if (dlgi.getSender().equals(sender)) {
                dlgi.closeGUI();
                it.remove();
            }
        }
        // Remove current active boards
        it = dlgPlayCtrls.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int gameID = (int) pair.getKey();
            DialogPlayEvents dlgc = (DialogPlayEvents) pair.getValue();
            if (dlgc.getOpponent().equals(sender)) {
                dlgc.closeGUI();
                it.remove();
            }
        }
    }
    
    public void receiveExitAnnounce(GameData game, String sender) {
        DialogPlayEvents playDlg = dlgPlayCtrls.get(game.getGameID());
        if (playDlg != null) {
            playDlg.closeGUI();
            dlgPlayCtrls.remove(game.getGameID());
        }
    }
    public void receiveNewMove(GameData game, String sender) {
        DialogPlayEvents playDlg = dlgPlayCtrls.get(game.getGameID());
        playDlg.setGame(game);
    }
    
    public void receiveAcceptance(GameData game, String sender) {
        createBoard(GameData.TURNX, game, sender);
    }
    
    public void updateUsersList(ArrayList<String> usersList) {
        homeCtrl.updateUsersList(usersList);
    }
    
    public void showInvitation(String sender, GameConfig cfg) {
        DialogInvite dlgInv = new DialogInvite();
        DialogInviteEvents dlgInvC = new DialogInviteEvents(this, dlgInv);
        
        int rid = randID();
        dlgInvC.setDlgID(rid);
        dlgInvC.setGcf(cfg);
        dlgInvC.setSender(sender);
        dlgInvCtrls.put(rid, dlgInvC);
        
        dlgInv.setVisible(true);
        
    }
    
    public int randID() {
        int randInt = (int) new Date().getTime();
        randInt = (int) (randInt * Math.random() + randInt % 13);
        return Math.abs(randInt);
    }
}
