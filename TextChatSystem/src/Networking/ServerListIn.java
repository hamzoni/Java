
package Networking;

import Controller.Controller;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerListIn implements Runnable {
    // INITIATE THIS PACKAGE WHEN SEARCHING FOR SERVERS
    public ArrayList<String> serverLists;
    private Controller c;

    public ServerListIn(Controller c) {
        this.c = c;
    }
    
    @Override
    public void run() {
        DatagramSocket c = null;
        serverLists = new ArrayList<String>();
        try {
            c  = new DatagramSocket();
            c.setBroadcast(true);
            byte[] sendData = "DISCOVER_FUIFSERVER_REQUEST".getBytes();
            DatagramPacket sendPackge = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), Server.PORT);
            c.setSoTimeout(5000); // 5 seconds waiting for server response
            c.send(sendPackge);
            
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();
                if (networkInterface.isLoopback() || !networkInterface.isUp()) continue;
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress broadcast = interfaceAddress.getBroadcast();
                    if (broadcast == null) continue;
                    DatagramPacket sendPackge2 = new DatagramPacket(sendData, sendData.length, broadcast, Server.PORT);
                    c.send(sendPackge2);
                }
            }
            
            byte[] recvBuf = new byte[15000];
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            
            c.receive(receivePacket);
            String message = new String(receivePacket.getData()).trim();
            
            if (message.equals("DISCOVER_FUIFSERVER_RESPONSE")) {
                String serverAddress = receivePacket.getAddress().getHostAddress();
                int serverPort = receivePacket.getPort();
                
                // Connect to first found server
                this.c.createClient(serverAddress, serverPort);
                serverLists.add(serverAddress);
                System.out.println("Found a server: " + serverAddress + ":" + serverPort);
                
                return;
            }
        } catch (SocketException ex) {
            System.out.println("NO SERVER FOUND");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerListIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerListIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.close();
    }
}
