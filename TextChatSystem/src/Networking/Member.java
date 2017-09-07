
package Networking;

import Entities.User;
import java.net.Socket;

public class Member {
    private User user;
    private Socket socket;

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
}
