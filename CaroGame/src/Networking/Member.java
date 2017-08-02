
package Networking;

import java.net.Socket;

public class Member {
    private Credential info;
    private Socket socket;

    public Credential getInfo() {
        return info;
    }

    public void setInfo(Credential info) {
        this.info = info;
    }
    
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
