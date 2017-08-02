package Compute;

import Entities.Caro;
import Entities.Pair;
import Middleware.Moment;
import Networking.Client;
import Networking.Credential;
import Networking.Server;
import Networking.ServerListIN;
import Networking.ServerListOUT;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class FrameController {
    private Frame frame;
    DefaultTableModel tbl_mdl;
    public FrameController(Frame frame) {
        this.frame = frame;
        new setDragging();
    }
    public void create_server() {
        frame.getError_usn().setText("");
        
        String usrn = frame.getUsername().getText();
        
        frame.getCreate_server().setText("Create Server");
        if (frame.gpl.hostGame == false) {
            if (usrn.length() != 0) {
                // CREATE SERVER SOCKET
                frame.gpl.hostGame = true;
                
                frame.gpl.serverlist = new ServerListOUT();
                frame.gpl.server = new Server(frame.gpl);
                
                new Thread(frame.gpl.serverlist).start();
                new Thread(frame.gpl.server).start();
                
                frame.getCreate_server().setText("Play");
                frame.getJoin_server().setEnabled(false);
            } else {
                frame.getError_usn().setText("Player name must not be empty");
            }
        } else {
            // CREATE CLIENT SOCKET
            clientSocketInit();
            frame.getCreate_server().setText("Create Server");
        }
    }
    public void clientSocketInit() {
        String hostAddress = "";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String username = frame.getUsername().getText();
        // CREATE CLIENT INFO
        Credential playerInfo = new Credential();
        playerInfo.setID((int) new Date().getTime());
        playerInfo.setNickname(username);
        playerInfo.setChosenTurn(getSelectedTurn());
        playerInfo.setTimeJoin(new Date());
        
        // CONNECT TO SERVER
        frame.gpl.client = new Client(hostAddress, playerInfo, frame.gpl);
        new Thread(frame.gpl.client).start();
        if (frame.gpl.hostGame == true) {
            try {
                hostAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        frame.getView_serverIP().setText(hostAddress);
        frame.getV_serverPort().setText(Server.PORT + "");
        frame.getUsername_v().setText(username);
        frame.getJLabel6().setText(getSelectedTurn() == 0 ? "X" : "O");
        show_pvp_pages(1);
    }
    public int getSelectedTurn() {
        if (frame.getPve_x1().isSelected()) { return 0; } else { return 1; }
    }
    public void show_pvp_pages(int page) {
        frame.getConnect_to_player().setEnabled(false);
        frame.getPvp_main().setVisible(false);
        frame.getPvp_server().setVisible(false);
        frame.getPvp_sv_list().setVisible(false);
        if (page == 0) {
            frame.getPvp_main().setVisible(true);
        } else if (page == 1) {
            frame.getPvp_server().setVisible(true);
        } else {
            frame.getPvp_sv_list().setVisible(true);
        }
    } 
    public void createNewServer() {
        frame.getError_usn().setText("");
        
        String usrn = frame.getUsername().getText();
        frame.getCreate_server().setText("Create Server");
        if (frame.gpl.hostGame == false) {
            if (usrn.length() != 0) {
                // CREATE SERVER SOCKET
                frame.gpl.hostGame = true;
                
                frame.gpl.serverlist = new ServerListOUT();
                frame.gpl.server = new Server(frame.gpl);
                
                new Thread(frame.gpl.serverlist).start();
                new Thread(frame.gpl.server).start();
                
                frame.getCreate_server().setText("Play");
                frame.getJoin_server().setEnabled(false);
            } else {
                frame.getError_usn().setText("Player name must not be empty");
            }
        } else { 
            try {
                // CREATE CLIENT SOCKET
                String hostAddress = InetAddress.getLocalHost().getHostAddress();
                String usn = frame.getUsername_v().getText();
                clientSocketInit();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.getCreate_server().setText("Create Server");
        }
    }
    public void requestJoinServer() {
        DefaultTableModel tbl_mdl = (DefaultTableModel) frame.getSv_list().getModel();
        int selected = frame.getSv_list().getSelectedRow();
        if (selected != -1) {
            String serverIP = (String) tbl_mdl.getValueAt(selected, 1);
            connect_to_server(serverIP);
        }
    }
    public void connect_to_server(String serverAddress) {
        clientSocketInit();
    }
    public void get_server_list() {
        tbl_mdl = (DefaultTableModel) frame.getSv_list().getModel();
        tbl_mdl.setRowCount(0);
        ServerListIN serverlist = new ServerListIN(frame);
        new Thread(serverlist).start();
    }
    public void update_list_servers_table(ArrayList<String> serversName) {
        tbl_mdl = (DefaultTableModel) frame.getSv_list().getModel();
        for (String svname : serversName) {
            String timeCreated = Moment.getTime(new Date());
            int stt = tbl_mdl.getRowCount() + 1;
            tbl_mdl.addRow(new Object[]{stt, svname, timeCreated});
        }
    }
    public void upatePlayersTable() {
        tbl_mdl = (DefaultTableModel) frame.getServerList().getModel();
        tbl_mdl.setRowCount(0);
        for (Credential pl : frame.gpl.client.playersInfo) {
            if (pl.getID() != frame.gpl.client.getInfo().getID() && 
                pl.getChosenTurn() != frame.gpl.client.getInfo().getChosenTurn()) {
                int plID = pl.getID();
                String plName = pl.getNickname();
                System.out.println(plName);
                String plTime = Moment.getTime(pl.getTimeJoin());
                tbl_mdl.addRow(new Object[] {plID, plName, plTime});
            }
        }
    }
    public void show_layer(int layer) {
        for (JPanel panel : frame.panels) panel.setVisible(false);
        frame.panels.get(layer).setVisible(true);
    }
    public boolean prompt_end_game() {
        int rsl = JOptionPane.showConfirmDialog(null, "Play again?", "Again?", JOptionPane.YES_NO_OPTION);
        return rsl == 0;
    }
    public String findPlayerName(int id) {
        for (Credential cred : frame.gpl.client.playersInfo) {
            if (cred.getID() == id) return cred.getNickname();
        }
        return "";
    }
    public Credential findPlayerInfo(int id) {
        for (Credential cred : frame.gpl.client.playersInfo) {
            if (cred.getID() == id) return cred;
        }
        return null;
    }
    int currentRequestID = -1;
    public void requestPrompt(int sourceID) {
        currentRequestID = sourceID;
        String sourceName = findPlayerName(sourceID);
        DialogRP request_dlg = new DialogRP(frame);
        request_dlg.pack();
        request_dlg.setVisible(true);
        request_dlg.setLocationRelativeTo(null);
        request_dlg.getSenderNameTXT().setText(sourceName + " - " + sourceID);
        request_dlg.getCountDownTXT().setText("");
        request_dlg.setCountDown(sourceName);
    }
     public void accept_duo_request() {
        Credential infoA = frame.gpl.client.getInfo();
        Credential infoB = findPlayerInfo(currentRequestID);
        Credential duoA = infoA.getChosenTurn() == 0 ? infoA : infoB;
        Credential duoB = infoA.getChosenTurn() == 1 ? infoA : infoB;
        Pair duo = new Pair<Credential,Credential>(duoA, duoB);
        // CREATE GAME ID
        String gameID = "1_"  
                + (infoA.getChosenTurn() == 0 ? 
                    infoA.getID() + "_" + infoB.getID() : 
                    infoB.getID() + "_" + infoA.getID())
                + "_" + new Date().getTime();
        Caro newMap = new Caro();
        newMap.setDuo(duo);
        newMap.setGameID(gameID);
        // SENT ACCEPT NOTIFICATION
        frame.gpl.client.accept(infoB.getID(), newMap);
        frame.gpl.create_game(1, infoA.getChosenTurn(), newMap);
    }
    public void playerPaired(Caro map) {
        Credential infoA = frame.gpl.client.getInfo();
        frame.gpl.create_game(1, infoA.getChosenTurn(), map);
    }
    public int getSelectedTurn_BOT () {
        if (frame.getPve_x().isSelected()) return 0;
        return 1;
    }
    public void createServerFail() {
        frame.getCreate_server().setText("Create Server");
        frame.getJoin_server().setEnabled(true);
        frame.gpl.hostGame = false;
    }
    public void disconnect_server() {
        if (frame.gpl.server != null || frame.gpl.client != null) {
            if (frame.gpl.hostGame) {
                frame.gpl.serverlist.stop();
                frame.gpl.server.stop();
            } else {
                if (frame.gpl.client != null)
                    frame.gpl.client.stop();
            }
        }
        frame.gpl.hostGame = false;
        frame.gpl.end_game();
        frame.getCreate_server().setText("Create Server");
        frame.getJoin_server().setEnabled(true);
        show_pvp_pages(0);
    }
    public void init_server_list() {
        int selected = frame.getServerList().getSelectedRow();
        if (selected != -1) {
            Credential pl = frame.gpl.client.playersInfo.get(selected);
            String sltPlBInfo = pl.getNickname() + " - " + pl.getID();
            frame.getJTextField1().setText(sltPlBInfo);
            frame.getConnect_to_player().setEnabled(true);
        }
    }
    public void styling_table() {
        frame.getJScrollPane1().setBorder(createEmptyBorder());
        frame.getJScrollPane1().setBackground(new Color(49,52,67));
        frame.getJScrollPane1().getViewport().setBackground(new Color(49,52,67));
        frame.getServerList().setBackground(new Color(49,52,67));
        
        JTableHeader tbl_header = frame.getServerList().getTableHeader();
        tbl_header.setBackground(new Color(70,79,113));
        tbl_header.setForeground(new Color(132,228,228));
        tbl_header.setBorder(createEmptyBorder());
    }
    
    class HeaderStyling extends DefaultTableCellRenderer {
        public HeaderStyling() {
            setOpaque(true);
        }
        public Component getTableCellRenderedComponent(JTable myTable, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(myTable, value, selected, focused, row, column);
            setBackground(new Color(0, 0, 0));
            return this;
        }
    }

    class setDragging {
        public setDragging() {
            MouseAdapter ma = new MouseAdapter() {
                int lastX, lastY;
                @Override
                public void mousePressed(MouseEvent e) {
                    lastX = e.getXOnScreen();
                    lastY = e.getYOnScreen();
                }
                @Override
                public void mouseDragged(MouseEvent e) {
                    int x = e.getXOnScreen();
                    int y = e.getYOnScreen();
                    // Move frame by the mouse delta
                    frame.setLocation(frame.getLocationOnScreen().x + x - lastX,
                            frame.getLocationOnScreen().y + y - lastY);
                    lastX = x;
                    lastY = y;
                }
            };
            frame.addMouseListener(ma);
            frame.addMouseMotionListener(ma);
        }
    }
}
