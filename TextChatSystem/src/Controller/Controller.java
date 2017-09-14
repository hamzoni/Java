
package Controller;

import GUI.*;
import Action.*;
import DBContext.DBModel;
import Entities.OfflineMessage;
import Entities.User;
import FileIO.FileController;
import Networking.*;
import java.util.ArrayList;

public class Controller {

    private FileController fc;

    public Server server;
    public Client client;
    public ServerListIn upd_in;
    public ServerListOut upd_out;

    private Login vLogin;
    private Register vRegister;
    private ListUser vListUser;
    private ChatOffline vOffMsg;
    private ArrayList<Chat> vChat;
    private ArrayList<ChatboxMessageListing> listMessageData;
    
    private UserListing listUserData;

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
        listUserData = new UserListing(this);
        
        vOffMsg = new ChatOffline();
        
        vChat = new ArrayList<Chat>();
        listMessageData = new ArrayList<ChatboxMessageListing>();

        // set up event listeners for each buttons
        vLogin.getButton_login().addActionListener(new LoginButtonSubmit(this));
        vLogin.getButton_cancel().addActionListener(new LoginButtonCancel(this));
        vLogin.getButton_register().addActionListener(new LoginButtonRegister(this));

        vRegister.getButton_cancle().addActionListener(new RegisterButtonCancel(this));
        vRegister.getButton_register().addActionListener(new RegisterButtonSubmit(this));
        
        vListUser.getList_users().addMouseListener(listUserData);
        vListUser.getButton_chat().addActionListener(new UserListButtonChat(this));
        vListUser.getButton_offlineMessages().addActionListener(new OffMsgListing(this));
        vListUser.getButton_close().addActionListener(new UserListButtonClose(this));

        vOffMsg.getButton_read().addActionListener(new OffMsgButtonRead(this));
        vOffMsg.getButton_close().addActionListener(new OffMsgButtonClose(this));
        
    }
    
    public void updateChatBox(User sender, String message) {
        System.out.println("And the sender of this message is: " + sender.getLogin());
        for (ChatboxMessageListing account : listMessageData) {
            if (account.getChat().receiver.getLogin().equals(sender.getLogin())) {
                account.updateMessagesList(sender, message);
                return;
            }
        }
    }
    
    public boolean isAlreadyChat(User user) {
        for (Chat chat : vChat) {
            if (!chat.isVisible()) return false;
            if (chat.userA.getLogin().equals(user.getLogin()) ||
                chat.userB.getLogin().equals(user.getLogin())) 
                return true;
        }
        return false;
    }
    
    public void showChatBox(User targetUser) {
        if (!isAlreadyChat(targetUser)) {
            System.out.println("Receive request from : " + targetUser.getLogin());
            Chat chat = new Chat();
            chat.setVisible(true);
            chat.receiver = targetUser;
            chat.userA = targetUser;
            chat.userB = this.data.getaUser();
            chat.isOnline = data.checkExistOnline(targetUser);
            chat.getButton_sendMessage().addActionListener(new ChatboxButtonSend(this, chat));
            listMessageData.add(new ChatboxMessageListing(this, chat));
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

    public UserListing getListUserData() {
        return listUserData;
    }

    public ArrayList<ChatboxMessageListing> getListMessageData() {
        return listMessageData;
    }

    public void showChatBox(User targetUser, ArrayList<OfflineMessage> msgs) {
        if (!isAlreadyChat(targetUser)) {
            System.out.println("Receive request from : " + targetUser.getLogin());
            Chat chat = new Chat();
            chat.setVisible(true);
            chat.receiver = targetUser;
            chat.userA = targetUser;
            chat.userB = this.data.getaUser();
            chat.isOnline = data.checkExistOnline(targetUser);
            chat.getButton_sendMessage().addActionListener(new ChatboxButtonSend(this, chat));
            
            String oldMsgs = "";
            for (OfflineMessage msg : msgs) {
                for (String str : msg.getMessage()) {
                    oldMsgs += msg.getSender() + ": " + str + "\n";
                }
            }
            chat.getTextarea_chatbox().setText(oldMsgs);
            listMessageData.add(new ChatboxMessageListing(this, chat));
            vChat.add(chat);
        }
        
    }
    
}
