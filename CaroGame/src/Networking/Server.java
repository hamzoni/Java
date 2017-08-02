package Networking;

import Gameplay.GamePlay;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {
    
    public static final int PORT = 6789;
    private ArrayList<Member> clients;
    private int n_conns;
    private ServerSocket server;
    private GamePlay gpl;

    public Server(GamePlay gpl) {
        this.gpl = gpl;
        this.clients = new ArrayList<Member>();
        this.n_conns = 0;
    }

    public ArrayList<Member> getClients() {
        return clients;
    }

    public ServerSocket getServer() {
        return server;
    }
    
    public void run() {
        initConnector();
    }
    public void stop() {
        try {
            Package pkg = new Package();
            pkg.command = Package.CLOSE_SERVER;
            for (Member m : clients) {
                ObjectOutputStream other_oos = null;
                OutputStream other_os = m.getSocket().getOutputStream();
                other_oos = new ObjectOutputStream(other_os);
                other_oos.writeObject(pkg);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initConnector() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Port " + PORT + " is now open.");
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
            gpl.window.frame_c.createServerFail();
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    class ClientHandler implements Runnable {
        private Member client;
        private boolean running;
        public ClientHandler(Member client) {
            this.running = true;
            this.client = client;
        }

        public ArrayList<Credential> getPlayersInfo() {
            ArrayList<Credential> playersInfo = new ArrayList<Credential>();
            for (Member m : clients) playersInfo.add(m.getInfo());
            return playersInfo;
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
                                System.out.println(receivedData.source.getNickname()
                                        + " registered to the server.");
                                client.setInfo(receivedData.source);
                                receivedData.playersInfo = getPlayersInfo();
                                oos.writeObject(receivedData);
                                
                                for (Member m : clients) {
                                    if (m != client) {
                                        OutputStream other_os = m.getSocket().getOutputStream();
                                        ObjectOutputStream other_oos = new ObjectOutputStream(other_os);
                                        receivedData.command = Package.USER_LIST_SERVER;
                                        other_oos.writeObject(receivedData);
                                    }
                                }
                                n_conns++;
                                break;
                            case Package.SEND_DATA_TO_SERVER:
                            case Package.REQUEST_PLAY:
                            case Package.ACCEPT_PLAY:
                            case Package.GAME_END:
                                for (Member client : clients) {
                                    if (client.getInfo().getID() == receivedData.targetID) {
                                        OutputStream other_os = client.getSocket().getOutputStream();
                                        ObjectOutputStream other_oos = new ObjectOutputStream(other_os);
                                        other_oos.writeObject(receivedData);
                                        break;
                                    }
                                }
                                break;
                            case Package.CLOSE_SERVER:
                                n_conns--;
                                if (n_conns == 0) server.close();
                                break;
                            case Package.EXIT_SERVER:
                                for (Member m : clients) {
                                    if (m.getInfo().getID() == receivedData.sourceID) {
                                        OutputStream other_os = m.getSocket().getOutputStream();
                                        ObjectOutputStream other_oos = new ObjectOutputStream(other_os);
                                        other_oos.writeObject(receivedData);
                                        break;
                                    }
                                }
                                // Remove player from the players list
                                for (Member m : clients) {
                                    if (m.getInfo().getID() == receivedData.sourceID) {
                                        clients.remove(m);
                                        break;
                                    }
                                }
                                // Boardcast the list to other players
                                receivedData.playersInfo = getPlayersInfo();
                                for (Member m : clients) {
                                    OutputStream other_os = m.getSocket().getOutputStream();
                                    ObjectOutputStream other_oos = new ObjectOutputStream(other_os);
                                    receivedData.command = Package.USER_LIST_SERVER;
                                    other_oos.writeObject(receivedData);
                                }
                                this.running = false;
                                n_conns--;
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
