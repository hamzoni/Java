
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
    public boolean serverAlive;

    public static void main(String[] args) {
        new Controller().init();
    }

    private void init() {
        data = new DBModel();
        fc = new FileController();

        setupComponents();
        setupNetworks();
        initServer();
    }
    
    public void showLogin() {
        vLogin.setVisible(true);
    }
    
    public void listServer() {
        new Thread(upd_in).start();
    }
    
    public void initServer() {
        new Thread(server).start();
        new Thread(upd_out).start();
    }
    
    public void createClient(String address) {
        
        // Host client connect to its server itself
        if (address == null) {
            address = server.getServer().getInetAddress().getHostAddress();
        }
        showLogin();
        new Thread(client).start();
    }

    public void setupNetworks() {
        upd_in = new ServerListIn(this);
        upd_out = new ServerListOut();
        client = new Client(this);
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
            listMessageData.add(chatboxCtrl.new ChatboxMessageListing(chat));
            vChat.add(chat);
        }
        
    }
    
     public void removeChatbox(User receiver, boolean isReceiver) {
        for (ChatboxMessageListing cbml : listMessageData) {
            if (cbml.getChat().receiver.getLogin().equals(receiver.getLogin())) {
                cbml.getChat().dispose();
                for (Chat chat : vChat) {
                    if (cbml.getChat() == chat) {
                        vChat.remove(chat);
                        break;
                    }
                }
                listMessageData.remove(cbml);
                break;
            }
        }
        if (!isReceiver && data.checkExistOnline(receiver)) {
            client.cancelChat(receiver);
        }
    }
     
    public void emptyChatboxes() {
        for (User user : data.getUsers()) {
            removeChatbox(user, true);
        }
    }
     
    public void login(boolean isSuccess) {
        if (isSuccess) {
            loginCtrl.loginSuccess();
        } else {
            loginCtrl.loginFail();
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
        if (client.getSocket() == null || !serverAlive) return;
        client.close();
    }
    
    public void closeServer() {
        if (server.getServer() == null) return;
        server.close();
    }
    
    public UserListController getUserListCtrl() {
        return userListCtrl;
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

}
