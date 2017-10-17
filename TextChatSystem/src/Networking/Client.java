
package Networking;

import Controller.Controller;
import Entities.User;
import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {
    
    private Controller c;
    
    private Socket socket;
    
    private String hostAddr;
    private int clientID;

    private OutputStream os;
    private ObjectOutputStream oos;
    
    private InputStream is;
    private ObjectInputStream ois;
    
    public Client(Controller c) {
        this.c = c;
        this.clientID = randID();
        
    }
    
    public int randID() {
        int randInt = (int) new Date().getTime();
        randInt = (int) (randInt * Math.random() + randInt % 13);
        return Math.abs(randInt);
    }
    
    private Package packaging(Object data, User target, int cmd) {
        Package pkg = new Package();
        pkg.data = data;
        pkg.source = c.getData().getaUser();
        pkg.target = target;
        pkg.senderID = clientID;
        pkg.command = cmd;
        return pkg;
    }
    
    private void submit(Package pkg) {
        try {
            oos.writeObject(pkg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setupStream() {
        try {
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        
        try {
            socket = new Socket(hostAddr, Server.PORT);
            c.serverAlive = true;
            setupStream();
            
            // send first request
            submit(packaging(null, null, Package.CONNECT_SERVER));
            
            while (true) {
                Package pkg = (Package) ois.readObject();
                switch (pkg.command) {
                    case Package.CREATE_ACCOUNT:
                        c.getData().refresh();
                        break;
                    case Package.LOGIN_ACCOUNT:
                        if (pkg.source != null) {
                            c.getData().setaUser(pkg.source);
                            c.getData().setUsersOnline(pkg.usersList, pkg.source);
                            c.getUserListCtrl().updateList();
                            c.getLoginCtrl().loginSuccess();
                        } else {
                            c.getLoginCtrl().loginFail();
                        }
                        break;
                    case Package.USER_LIST_SERVER:
                        c.getData().setUsersOnline(pkg.usersList, pkg.source);
                        c.getUserListCtrl().updateList();
                        break;
                    case Package.REQUEST_CHAT:
                        c.showChatBox(pkg.source, null);
                        break;
                    case Package.SEND_MESSAGE:
                        c.updateChatBox(pkg.source, (String) pkg.data);
                        break;
                    case Package.CANCEL_CHAT:
                        c.removeChatbox(pkg.source, true);
                        break;
                    case Package.CLIENT_CLOSING:
                        c.removeChatbox(pkg.source, true);
                        c.getData().setUsersOnline(pkg.usersList, pkg.source);
                        c.getUserListCtrl().updateList();
                        break;
                    case Package.SERVER_CLOSING:
                        
                        break;
                }
            }
            
        } catch (IOException ex) {
            try {
                System.out.println("Client close connection.");
                closeServer();
                socket.close();
                return;
            } catch (IOException ex1) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeServer() {
        c.getData().setUsersOnline(null, null);
        c.getUserListCtrl().updateList();
        c.emptyChatboxes();
        c.getUserListCtrl().updateServerStatus(false);
        c.serverAlive = false;
    }
    public void sendMessage(User target, String message) {
        submit(packaging(message, target, Package.SEND_MESSAGE));
    }

    public void login(User user) {
        c.getData().setaUser(user);
        submit(packaging(null, null, Package.LOGIN_ACCOUNT));
    }

    public void close() {
        submit(packaging(null, null, Package.CLIENT_CLOSING));
    }

    public void registerAccount(User user) {
        submit(packaging(user, null, Package.CREATE_ACCOUNT));
    }

    public void requestChat(User targetUser) {
        submit(packaging(null, targetUser, Package.REQUEST_CHAT));
    }

    public void cancelChat(User receiver) {
        submit(packaging(null, receiver, Package.CANCEL_CHAT));
    }

    public Socket getSocket() {
        return socket;
    }
    
}
