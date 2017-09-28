
package Networking;

import Controller.Controller;
import Controller.GameConfig;
import Controller.GameData;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {
    
    private Controller c;
    private String username;
    private Socket socket;
    private boolean alive;
    
    public Client(String username) {
        this.username = username;
        this.alive = true;
        try {
            socket = new Socket(Config.SERVER_ADDR, Config.PORT);
            send(null, null, Package.CONNECT);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setController(Controller c) {
        this.c = c;
    }
    
    public void send(String receiver, Object data, int cmd) {
        if (!alive) return;
        try {
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
            Package pkg = new Package();
            pkg.sender = username;
            pkg.data = data;
            pkg.receiver = receiver;
            pkg.command = cmd;
             
            oos.writeObject(pkg);
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while (alive) {
            try {
                
                ObjectInputStream oos = new ObjectInputStream(socket.getInputStream());
                Package pkg = (Package) oos.readObject();
                
                switch (pkg.command) {
                    case Package.USERLIST:
                        ArrayList<String> users = (ArrayList<String>) pkg.data;
                        c.updateUsersList(users);
                        break;
                    case Package.INVITE:
                        c.showInvitation(pkg.sender, (GameConfig) pkg.data);
                        break;
                    case Package.ACCEPT_INVITE:
                        c.receiveAcceptance((GameData) pkg.data, pkg.sender);
                        break;
                    case Package.MAKE_MOVE:
                        c.receiveNewMove((GameData) pkg.data, pkg.sender);
                        break;
                    case Package.EXIT_GAME:
                        c.receiveExitAnnounce((GameData) pkg.data, pkg.sender);
                        break;
                    case Package.CLOSE_CLIENT:
                        users = (ArrayList<String>) pkg.data;
                        if (pkg.sender.equals(username)) {
                            alive = false;
                            socket.close();
                        } else {
                            c.updateUsersList(users);
                            c.clearUserBoards(pkg.sender);
                            break;
                        }
                        break;
                    case Package.CLOSE_SERVER:
                        
                        c.updateUsersList(null);
                        c.client = null;
                        c.server.setSocket(null);
                        
                        socket.close();
                        alive = false;
                        break;
                }
                
            } catch (IOException ex) {
                try {
                    socket.close();
                    System.out.println("Server closed.");
                } catch (IOException ex1) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
                }
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
