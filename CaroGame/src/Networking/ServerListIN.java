
package Networking;

import Compute.Frame;
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


public class ServerListIN implements Runnable {
    public ArrayList<String> serverLists;
    private Frame frame;
    public ServerListIN(Frame frame) {
        this.frame = frame;
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
            System.out.println (getClass().getName() + ">>> Request package sent to: 255.255.255.255 (DEFAULT)");
            
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();
                if (networkInterface.isLoopback() || !networkInterface.isUp()) continue;
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress broadcast = interfaceAddress.getBroadcast();
                    if (broadcast == null) continue;
                    DatagramPacket sendPackge2 = new DatagramPacket(sendData, sendData.length, broadcast, Server.PORT);
                    c.send(sendPackge2);
                    System.out.println(getClass().getName() + ">>> Request packet sent to: " + broadcast.getHostAddress() + "; Interface: " + networkInterface.getDisplayName());
                }
            }
            
            System.out.println (getClass().getName() + ">>> Done looping over all network interfaces. Now waiting for a reply!");
            byte[] recvBuf = new byte[15000];
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            
            c.receive(receivePacket);
            System.out.println (getClass().getName() + ">>> Broadcast response from server: " + receivePacket.getAddress().getHostAddress());
            String message = new String(receivePacket.getData()).trim();
            
            if (message.equals("DISCOVER_FUIFSERVER_RESPONSE"))
                serverLists.add(receivePacket.getAddress().getHostAddress());
            
        } catch (SocketException ex) {
            System.out.println("NO SERVER FOUND");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerListIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerListIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.frame_c.update_list_servers_table(serverLists);
        c.close();
    }
}
