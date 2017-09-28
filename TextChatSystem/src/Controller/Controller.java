
package Controller;

import GUI.*;
import Action.*;
import Action.ChatboxController.ChatboxButtonSend;
import Action.ChatboxController.ChatboxMessageListing;
import DBContext.DBModel;
import Entities.OfflineMessage;
import Entities.User;
import FileIO.FileController;
import Networking.*;
import java.util.ArrayList;

public class Controller {
    
    private FileController fc;
    // Networking controller
    public Server server;
    public Client client;
    public ServerListIn upd_in;
    public ServerListOut upd_out;
    
    // All Swing views
    private Login vLogin;
    private Register vRegister;
    private ListUser vListUser;
    private ChatOffline vOffMsg;
    private ArrayList<Chat> vChat;
    private ArrayList<ChatboxMessageListing> listMessageData;
    
    // All Controllers for each Views (Events Handler)
    private UserListController userListCtrl;
    private ChatboxController chatboxCtrl;
    private LoginController loginCtrl;
    private OffMsgController offMsgCtrl;
    private RegisterController regCtrl;

    private DBModel data;

    public static void main(String[] args) {
        new Controller().init();
    }

    private void init() {
        data = new DBModel();
        fc = new FileController();

        setupComponents();
        setupNetworks();

        vLogin.setVisible(true);
    }
    
    public void listServer() {
        new Thread(upd_in).start();
    }
    
    public void initServer() {
        new Thread(server).start();
        new Thread(upd_out).start();
    }
    
    public void createClient(String address, int port) {
        String serverAddress = null;
        int serverPort = -1;
        if (address == null) {
            serverAddress = server.getServer().getInetAddress().getHostAddress();
            serverPort = server.getServer().getLocalPort();
        } else {
            serverAddress = address;
            serverPort = port;
        }
        
        client.setHost(serverAddress);
        client.setPort(serverPort);
        client.setUser(data.getaUser());
        client.setController(this);
        new Thread(client).start();
    }

    public void setupNetworks() {
        upd_in = new ServerListIn(this);
        upd_out = new ServerListOut();
        client = new Client();
        server = new Server(this);
    }

    private void setupComponents() {
        vLogin = new Login();
        vRegister = new Register();
        vListUser = new ListUser();
        vOffMsg = new ChatOffline();
        vChat = new ArrayList<Chat>();
        
        listMessageData = new ArrayList<ChatboxMessageListing>();
        
        offMsgCtrl = new OffMsgController(vOffMsg, this);
        userListCtrl = new UserListController(vListUser, this);
        chatboxCtrl = new ChatboxController(this);
        loginCtrl = new LoginController(vLogin, this);
        regCtrl = new RegisterController(vRegister, this);
        
    }
    
    public void updateChatBox(User sender, String message) {
        for (ChatboxMessageListing account : listMessageData) {
            if (account.getChat().receiver.getLogin().equals(sender.getLogin())) {
                account.updateMessagesList(sender, message);
                return;
            }
        }
    }
    
    public boolean isAlreadyChat(User user) {
        for (Chat chat : vChat) {
            if (chat.userA.getLogin().equals(user.getLogin()) ||
                chat.userB.getLogin().equals(user.getLogin())) 
                return true;
        }
        return false;
    }

     public void showChatBox(User targetUser, ArrayList<OfflineMessage> msgs) {
        if (!isAlreadyChat(targetUser)) {
            Chat chat = new Chat();
            chat.setVisible(true);
            chat.receiver = targetUser;
            chat.userA = targetUser;
            chat.userB = this.data.getaUser();
            chat.isOnline = data.checkExistOnline(targetUser);
            
            if (msgs != null) {
                for (OfflineMessage msg : msgs) {
                    for (String str : msg.getMessage()) {
                        chat.getTextarea_chatbox().append(msg.getSender() + ": " + str + "\n");
                    }
                }
            }
            
            chat.getButton_sendMessage().addActionListener(chatboxCtrl.new ChatboxButtonSend(chat));
            listMessageData.add(chatboxCtrl.new ChatboxMessageListing(this, chat));
            vChat.add(chat);
        }
        
    }
    

    public Login getvLogin() {
        return vLogin;
    }

    public Register getvRegister() {
        return vRegister;
    }

    public ListUser getvListUser() {
        return vListUser;
    }

    public ChatOffline getvOffMsg() {
        return vOffMsg;
    }

    public DBModel getData() {
        return data;
    }

    public ArrayList<ChatboxMessageListing> getListMessageData() {
        return listMessageData;
    }
    
    public void closeClient() {
        if (client.getSocket() == null) return;
        client.close();
    }
   
    public void closeServer() {
        if (server.getServer() == null) return;
        server.close();
    }

    public UserListController getUserListCtrl() {
        return userListCtrl;
    }

    public void setUserListCtrl(UserListController userListCtrl) {
        this.userListCtrl = userListCtrl;
    }

    public ChatboxController getChatboxCtrl() {
        return chatboxCtrl;
    }

    public LoginController getLoginCtrl() {
        return loginCtrl;
    }

    public OffMsgController getOffMsgCtrl() {
        return offMsgCtrl;
    }


    public ArrayList<Chat> getvChat() {
        return vChat;
    }
}
