
package Networking;

import Entities.User;
import Networking.Server.ClientHandler;
import java.net.Socket;

public class Member {
    private int sid;
    private User user;
    private Socket socket;
    private ClientHandler handler;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ClientHandler getHandler() {
        return handler;
    }

    public void setHandler(ClientHandler handler) {
        this.handler = handler;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
