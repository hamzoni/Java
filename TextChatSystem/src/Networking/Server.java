package Networking;

import Controller.Controller;
import Entities.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {

//    public static final int PORT = (int) Math.floor(Math.random() * 9999);
    public static final int PORT = 1212;
    private ArrayList<Member> clients;
    private ServerSocket server;
    private Controller c;
    private int leaverCounter;

    public Server(Controller c) {
        this.clients = new ArrayList<Member>();
        this.c = c;
        this.c.getData().refresh();
    }

    public ArrayList<Member> getClients() {
        return clients;
    }

    public ServerSocket getServer() {
        return server;
    }
    
    public void close() {
        Package pkg = new Package();
        pkg.command = Package.SERVER_CLOSING;
        for (Member m : clients) {
            try {
                m.getHandler().oos.writeObject(pkg);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);
            while (!server.isClosed()) {
                try {
                    Socket socket = server.accept();

                    Member member = new Member();
                    member.setSocket(socket);

                    ClientHandler CH = new ClientHandler(member);
                    member.setHandler(CH);

                    clients.add(member);

                    new Thread(CH).start();
                } catch (IOException ex) {
                    System.out.println("Server is closed");
                }
            }
        } catch (IOException ex) {
            /* Since this program is running localhost only.
            * Thus after creating server fail, the client will immediately looking for a server to connect
             */
            System.out.println("Connecting to server...");
            this.c.listServer();
            return;
        }
    }

    class ClientHandler implements Runnable {

        private Member client;
        private boolean running;
        
        private OutputStream os;
        private ObjectOutputStream oos;
        
        private InputStream is;
        private ObjectInputStream ois;

        public ClientHandler(Member client) {
            try {
                this.running = true;
                this.client = client;
                this.client.setHandler(this);
                
                os = client.getSocket().getOutputStream();
                oos = new ObjectOutputStream(os);
                is = client.getSocket().getInputStream();
                ois = new ObjectInputStream(is);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public ArrayList<User> getUsersList() {
            ArrayList<User> usersList = new ArrayList<User>();
            for (Member m : clients) {
                usersList.add(m.getUser());
            }
            return usersList;
        }

        public void broadcasting(Package pkg) throws IOException {
            for (Member m : clients) {
                if (m != client) {
                    m.getHandler().oos.writeObject(pkg);
                }
            }
        }

        public void sendPackage(Package pkg) throws IOException {
            for (Member m : clients) {
                if (m.getUser().getLogin().equals(pkg.target.getLogin())) {
                    m.getHandler().oos.writeObject(pkg);
                }
            }
        }

        public Package packaging(User sender, User receiver, Object data, int command) {
            Package pkg = new Package();
            pkg.source = sender;
            pkg.target = receiver;
            pkg.data = data;
            pkg.command = command;
            return pkg;
        }

        @Override
        public void run() {
            try {
                while (this.running) {
                    Package pkg = (Package) ois.readObject();
                    switch (pkg.command) {
                        case Package.CONNECT_SERVER:
                            System.out.println(pkg.senderID + " registered to server.");
                            client.setSid(pkg.senderID);
                            break;
                        case Package.CREATE_ACCOUNT:
                            c.getData().addUser((User) pkg.data);
                            broadcasting(pkg);
                            break;
                        case Package.LOGIN_ACCOUNT:
                            User user = (User) pkg.source;
                            User authUser = c.getData().checkLogin(user);
                            pkg.source = null;
                            if (authUser != null) {
                                System.out.println(authUser.getLogin() + " registered to the server.");
                                // Update login info for client
                                client.setUser(authUser);
                                
                                pkg.usersList = getUsersList();
                                pkg.source = authUser;
                                oos.writeObject(pkg);
                                
                                // Broadcast new user list to all users
                                pkg.command = Package.USER_LIST_SERVER;
                                broadcasting(pkg);
                            } else {
                                oos.writeObject(pkg);
                            }
                            break;
                        case Package.REQUEST_CHAT:
                        case Package.SEND_MESSAGE:
                        case Package.CANCEL_CHAT:
                            sendPackage(pkg);
                            break;
                        case Package.SERVER_CLOSING:
                            leaverCounter++;
                            if (leaverCounter == clients.size()) {
                                server.close();
                                this.running = false;
                                System.out.println("Server closed.");
                            }
                            break;
                        case Package.CLIENT_CLOSING:
                            this.running = false;
                            for (int i = 0; i < clients.size(); i++) {
                                if (clients.get(i) == client) {
                                    clients.get(i).getHandler().running = false;
                                    clients.get(i).getSocket().close();
                                    clients.remove(i);
                                    break;
                                }
                            }
                            pkg.usersList = getUsersList();
                            broadcasting(pkg);
                            break;
                    }
                }
                if (!client.getSocket().isClosed()) client.getSocket().close();
                if (!this.running) return;
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
