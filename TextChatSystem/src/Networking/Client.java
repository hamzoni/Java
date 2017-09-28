
package Networking;

import Controller.Controller;
import Entities.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {
    private String host;
    private int port;
    private Socket socket;
    private User user;
    public ArrayList<User> users;
    private Controller c;
    
    public Client() {
    }
    
    public Client(String host, int port, User user) {
        this.users = new ArrayList<User>();
        this.user = user;
        this.host = host;
    }

    @Override
    public void run() {
        try {
            this.socket = new Socket(host, port);
            connect();
            new Thread(new ServerHandler(this)).start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect() {
        Package pkg = new Package();
        pkg.command = Package.REGISTER_TO_SERVER;
        pkg.source = this.user;
        submit(pkg);
    }
    
    public void close() {
        Package pkg = packaging(null, null, Package.CLIENT_CLOSING);
        submit(pkg);
    }
    
    private Package packaging(User target, Object data, int cmd) {
        Package pkg = new Package();
        pkg.source = user;
        pkg.target = target;
        pkg.data = data;
        pkg.command = cmd;
        return pkg;
    }
    
    private void submit(Package pkg) {
        ObjectOutputStream oos = null;
        try {
            OutputStream os = null;
            os = this.socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(pkg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void requestChat(User targetUser) {
        Package pkg = packaging(targetUser, null, Package.REQUEST_CHAT);
        submit(pkg);
    }

    public void sendMessage(User target, String message) {
        Package pkg = packaging(target, message, Package.SEND_MESSAGE);
        submit(pkg);
    }
    
    class ServerHandler implements Runnable {
        private Client client;
        
        public ServerHandler(Client client) {
            this.client = client;
        }
        
        @Override
        public void run() {
            boolean alive = true;
            InputStream is =  null;
            ObjectInputStream ois = null;
            while (alive) {
                try {
                    is = socket.getInputStream();
                    ois = new ObjectInputStream(is);
                    Package pkg = (Package) ois.readObject();
                    switch (pkg.command) {
                        case Package.REGISTER_TO_SERVER:
                            users = pkg.usersList;
                            c.getData().setUsersOnline(users, null);
                            c.getUserListCtrl().updateList();
                            break;
                        case Package.USER_LIST_SERVER:
                            users = pkg.usersList;
                            c.getData().setUsersOnline(users, pkg.source);
                            c.getUserListCtrl().updateList();
                            break;
                        case Package.REQUEST_CHAT:
                            c.showChatBox(pkg.source, null);
                            break;
                        case Package.RECEIVE_MESSAGE:
                            User sender = pkg.source;
                            String message = (String) pkg.data;
                            c.updateChatBox(sender, message);
                            break;
                        case Package.SERVER_CLOSING:
                            pkg.source = user;
                            // Turn offline with all users
                            alive = false;
                            c.getData().setUsersOnline(new ArrayList<User>(), null);
                            c.getUserListCtrl().updateList();
                            
                            // Close stream and terminate the client thread
                            submit(pkg);
                            
                            c.getUserListCtrl().updateServerStatus(false);
                            c.client = null;
                            break;
                    }
                } catch (IOException ex) {
                    System.out.println("Unable to transfer data");
                    break;
                } catch (ClassNotFoundException ex) {
                    break;
                }
                if (!alive) {
                    try {
                        is.close();
                        return;
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void setController(Controller c) {
        this.c = c;
    }
    
    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public Socket getSocket() {
        return socket;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
}

