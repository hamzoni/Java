
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
    private boolean running;
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
            this.running = true;
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
        Package pkg = new Package();
        pkg.command = Package.REQUEST_CHAT;
        pkg.source = user;
        pkg.target = targetUser;
        submit(pkg);
    }

    public void sendMessage(User source, User target, String message) {
        Package pkg = new Package();
        pkg.command = Package.SEND_MESSAGE;
        pkg.data = message;
        pkg.source = source;
        pkg.target = target;
        submit(pkg);
    }
    
    class ServerHandler implements Runnable {
        private Client client;
        public ServerHandler(Client client) {
            this.client = client;
        }
        
        @Override
        public void run() {
            InputStream is =  null;
            ObjectInputStream ois = null;
            while (running && !socket.isClosed()) {
                try {
                   is = socket.getInputStream();
                    ois = new ObjectInputStream(is);
                    Package receivedData = (Package) ois.readObject();
                    switch (receivedData.command) {
                        case Package.REGISTER_TO_SERVER:
                            users = receivedData.usersList;
                            c.getData().setUsersOnline(users);
                            c.getListUserData().updateList();
                            break;
                        case Package.USER_LIST_SERVER:
                            users = receivedData.usersList;
                            c.getData().setUsersOnline(users);
                            /*
                            * update list
                            * and make sure no one can send offline message to online user
                            */
                            c.getListUserData().updateList();
                            break;
                        case Package.REQUEST_CHAT:
                            c.showChatBox(receivedData.source);
                            break;
                        case Package.RECEIVE_MESSAGE:
                            User sender = receivedData.source;
                            String message = (String) receivedData.data;
                            c.updateChatBox(sender, message);
                            break;
                    }
                } catch (IOException ex) {
                    break;
                } catch (ClassNotFoundException ex) {
                    break;
                }
            }
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);

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

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    public boolean isRunning() {
        return running;
    }
    
}

