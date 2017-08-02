
package Networking;

import Entities.Caro;
import Gameplay.GamePlay;
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
    private GamePlay gpl;
    
    private String host;
    private int port;
    private Socket socket;
    private Credential info;
    public ArrayList<Credential> playersInfo;
    private boolean running;
    
    public Client(String host, Credential info, GamePlay gpl) {
        this.gpl = gpl;
        this.playersInfo = new ArrayList<Credential>();
        this.info = info;
        this.host = host;
    }

    @Override
    public void run() {
    
        try {
            this.socket = new Socket(host, Server.PORT);
            this.running = true;
            begin();
            new Thread(new ServerHandler(this)).start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void begin() {
        Package pkg = new Package();
        pkg.command = Package.REGISTER_TO_SERVER;
        pkg.source = this.info;
        submit(pkg);
    }
    
    public void stop() {
        Package pkg = new Package();
        pkg.sourceID = info.getID();
        pkg.command = Package.EXIT_SERVER;
        submit(pkg);
    }
    
    public void endGame(int targetID, Caro map) {
        packaging(targetID, map, Package.GAME_END);
    }
    
    public void send(int targetID, Caro map) {
        packaging(targetID, map, Package.SEND_DATA_TO_SERVER);
    }
    
    public void match(int targetID) {
        packaging(targetID, null, Package.REQUEST_PLAY);
    }
    
    public void accept(int targetID, Caro map) {
        packaging(targetID, map, Package.ACCEPT_PLAY);
    }
    
    public void packaging(int targetID, Caro map, int command) {
        Package pkg = new Package();
        pkg.targetID = targetID;
        pkg.sourceID = info.getID();
        pkg.map = map;
        pkg.command = command;
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
                            playersInfo = receivedData.playersInfo;
                            gpl.window.frame_c.upatePlayersTable();
                            break;
                        case Package.USER_LIST_SERVER:
                            playersInfo = receivedData.playersInfo;
                            gpl.window.frame_c.upatePlayersTable();
                            gpl.refreshGamesList();
                            break;
                        case Package.SEND_DATA_TO_SERVER:
                            for (Credential source : this.client.playersInfo) {
                                if (source.getID() == receivedData.targetID) {
                                    Caro newMap = (Caro) receivedData.map;
                                    gpl.update_board(newMap);
                                }
                            }
                            break;
                        case Package.REQUEST_PLAY:
                            gpl.window.frame_c.requestPrompt(receivedData.sourceID);
                            break;
                        case Package.ACCEPT_PLAY:
                            Caro newMap = (Caro) receivedData.map;
                            gpl.window.frame_c.playerPaired(newMap);
                            break;
                        case Package.GAME_END:
                            String gameID = ((Caro) receivedData.map).getGameID();
                            gpl.end_board(gameID);
                            break;
                        case Package.CLOSE_SERVER:
                            gpl.window.frame_c.show_pvp_pages(0);
                            packaging(-1, null, Package.CLOSE_SERVER);
                            gpl.refreshGamesList();
                            running = false;
                            break;
                        case Package.EXIT_SERVER:
                            gpl.window.frame_c.show_pvp_pages(0);
                            running = false;
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
    public Credential getInfo() {
        return this.info;
    }
}

