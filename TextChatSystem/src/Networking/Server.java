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

    public Server(Controller c) {
        this.clients = new ArrayList<Member>();
        this.c = c;
    }

    public ArrayList<Member> getClients() {
        return clients;
    }

    public ServerSocket getServer() {
        return server;
    }
    
    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT);
            this.c.createClient(null, -1);
            System.out.println("Server is running on port: " + PORT);
            while (!server.isClosed()) {
                try {
                    Socket socket = server.accept();
                    
                    Member member = new Member();
                    member.setSocket(socket);
                    clients.add(member);
                    ClientHandler CH = new ClientHandler(member);
                    
                    new Thread(CH).start();
                } catch (IOException ex) {
                    System.out.println("Server is closed");
                }
            }
        } catch (IOException ex) {
            System.out.println("There is already a server run on this address");
            this.c.listServer();
            return;
        }
    }
    
    class ClientHandler implements Runnable {
        private Member client;
        private boolean running;
        public ClientHandler(Member client) {
            this.running = true;
            this.client = client;
        }

        public ArrayList<User> getUsersList() {
            ArrayList<User> usersList = new ArrayList<User>();
            for (Member m : clients) usersList.add(m.getUser());
            return usersList;
        }

        @Override
        public void run() {
            ObjectOutputStream oos = null;
            try {
                OutputStream os = client.getSocket().getOutputStream();
                os.flush();
                oos = new ObjectOutputStream(os);
                oos.flush();
                while (this.running && !client.getSocket().isClosed() && !server.isClosed()) {
                    InputStream is = null;
                    try {
                        is = client.getSocket().getInputStream();
                        ObjectInputStream ois = new ObjectInputStream(is);
                        Package receivedData = (Package) ois.readObject();
                        
                        switch (receivedData.command) {
                            case Package.REGISTER_TO_SERVER:
                                System.out.println(receivedData.source.getLogin()
                                        + " registered to the server.");
                                client.setUser(receivedData.source);
                                receivedData.usersList = getUsersList();
                                oos.writeObject(receivedData);
                                
                                for (Member m : clients) {
                                    if (m != client) {
                                        OutputStream other_os = m.getSocket().getOutputStream();
                                        ObjectOutputStream other_oos = new ObjectOutputStream(other_os);
                                        receivedData.command = Package.USER_LIST_SERVER;
                                        other_oos.writeObject(receivedData);
                                    }
                                }
                                break;
                            case Package.REQUEST_CHAT:
                                for (Member m : clients) {
                                    if (m.getUser().getLogin().equals(receivedData.target.getLogin())) {
                                        OutputStream other_os = m.getSocket().getOutputStream();
                                        ObjectOutputStream other_oos = new ObjectOutputStream(other_os);
                                        other_oos.writeObject(receivedData);
                                    }
                                }
                                break;
                            case Package.SEND_MESSAGE:
                                for (Member m : clients) {
                                    if (m.getUser().getLogin().equals(receivedData.target.getLogin())) {
                                        OutputStream other_os = m.getSocket().getOutputStream();
                                        ObjectOutputStream other_oos = new ObjectOutputStream(other_os);
                                        receivedData.command = Package.RECEIVE_MESSAGE;
                                        other_oos.writeObject(receivedData);
                                    }
                                }
                                break;
                        }
                    } catch (IOException ex) {
                        break;
                    } catch (ClassNotFoundException ex) {
                        break;
                    }
                }
                client.getSocket().close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
