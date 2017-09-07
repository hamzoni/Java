
package Networking;

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
            begin();
            new Thread(new ServerHandler(this)).start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void begin() {
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

    public boolean isRunning() {
        return running;
    }
    
}

