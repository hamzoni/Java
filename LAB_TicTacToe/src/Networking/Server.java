
package Networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {
    
    private ServerSocket sk;
    private boolean alive;
    private ArrayList<User> usersList;
    
    public Server() {
        usersList = new ArrayList<User>();
        
        try {
            sk = new ServerSocket(Config.PORT);
            alive = true;
            
            System.out.println("Server opened at " + sk.getInetAddress().getHostName() + ":" + Config.PORT);
        } catch (IOException ex) {
            alive = false;
            System.out.println("Server already created.");
        }
    }
    
    public void close() {
        try {
            broadcast(null, null, Package.CLOSE_SERVER);
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while (alive) {
            try {
                Socket client = sk.accept();
                new ClientHandler(client).start();
            } catch (IOException ex) {
                System.out.println("Server closed.");
                break;
            }
        }
    }
    
    private void broadcast(String sender, Object data, int command) throws IOException {
        for (User user : usersList) {
            ObjectOutputStream noos = new ObjectOutputStream(user.getSocket().getOutputStream());

            Package npkg = new Package();
            npkg.sender = sender;
            npkg.data = data;
            npkg.command = command;

            noos.writeObject(npkg);
        }
    }
    
    class ClientHandler extends Thread {
        private String username;
        private Socket socket;
        private boolean alive;
        
        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.alive = true;
        }
        
        public int removeUser(String username) {
            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).getUsername().equals(username)) {
                    usersList.remove(i);
                    return i;
                }
            }
            return -1;
        }
        
        public ArrayList<String> getUsersList() {
            ArrayList<String> users = new ArrayList<String>();
            for (User user : usersList) {
                users.add(user.getUsername());
            }
            return users;
        }
        
        public void run() {
            try {
                init();
            } catch (IOException ex) {
                // Ignore EOFException
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        private void init() throws IOException, ClassNotFoundException, InterruptedException {
            
            while (alive) {
                ObjectInputStream oos = new ObjectInputStream(socket.getInputStream());
                Package pkg = (Package) oos.readObject();
                
                switch (pkg.command) {
                    case Package.CONNECT:
                        username = pkg.sender;
                        usersList.add(new User(pkg.sender, socket));
                        // boardcast new member to other members
                        broadcast(null, getUsersList(), Package.USERLIST);
                        break;
                    case Package.INVITE:
                    case Package.ACCEPT_INVITE:
                    case Package.MAKE_MOVE:
                    case Package.EXIT_GAME:
                        // Send package to a specific user
                        for (User user : usersList) {
                            if (user.getUsername().equals(pkg.receiver)) {
                                ObjectOutputStream noos = new ObjectOutputStream(user.getSocket().getOutputStream());
                                noos.writeObject(pkg);
                                break;
                            }
                        }
                        break;
                    case Package.CLOSE_CLIENT:
                        if (removeUser(pkg.sender) != -1) {
                            // stop listening to client request
                            alive = false;
                            // boardcast new member to other members
                            broadcast(pkg.sender, getUsersList(), Package.CLOSE_CLIENT);
                        }
                        break;
                }
            }
            
        }
        
    }

    public ServerSocket getSocket() {
        return sk;
    }
    
    public void setSocket(ServerSocket socket) {
        this.sk = socket;
    }
    
}
