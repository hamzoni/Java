package Networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerListOut implements Runnable {
    // Run this class when creating server to announce server has been created
    private DatagramSocket socket;
    private boolean keepAlive;
    public void stop() {
        keepAlive = false;
        socket.close();
    }
    @Override
    public void run() {
        keepAlive = true;
        try {
            if (socket == null) {
                socket = new DatagramSocket(Server.PORT, InetAddress.getByName("0.0.0.0"));
                socket.setBroadcast(true);
            }
            
            while (keepAlive) {
                //Receive a packet
                byte[] recvBuf = new byte[15000];
                DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
                socket.receive(packet);
                
                
                String message = new String(packet.getData()).trim();
                if (message.equals("DISCOVER_FUIFSERVER_REQUEST")) {
                    byte[] sendData = "DISCOVER_FUIFSERVER_RESPONSE".getBytes();
                    
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, packet.getAddress(), packet.getPort());
                    socket.send(sendPacket);
                }
            }
        } catch (IOException ex) {
            //
        }
        socket = null;
    }
}