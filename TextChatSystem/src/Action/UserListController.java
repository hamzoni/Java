package Action;

import Action.ChatboxController.ChatboxMessageListing;
import Action.OffMsgController.OffMsgListing;
import Controller.Controller;
import Entities.User;
import GUI.ListUser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class UserListController {

    private ListUser vListUser;
    private Controller c;
    public UserListController(ListUser vListUser, Controller c) {
        this.vListUser = vListUser;
        this.c = c;
        vListUser.getButton_chat().addActionListener(new UserListButtonChat());
        vListUser.getButton_offlineMessages().addActionListener(c.getOffMsgCtrl().new OffMsgListing());
        vListUser.getButton_close().addActionListener(new UserListButtonClose());
        
        vListUser.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
    }
    private void closeWindow() {
        // Close connection to server
        if (c.server.getServer() == null &&
                c.client != null) {
            c.closeClient();
        }
        // Close server if hosted
        c.closeServer();
        System.exit(0);
    }

    public void updateServerStatus(boolean stt) {
        String txt = "ON";
        Color clr = Color.GREEN;
        if (!stt) {
            txt = "OFF";
            clr = Color.RED;
        }
        vListUser.getServer_status().setForeground(clr);
        vListUser.getServer_status().setText(txt);
    }
    
    class UserListButtonChat extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedItem = vListUser.getList_users().getSelectedIndex();
            if (selectedItem == -1) return;
            User targetUser = c.getData().getUsersSorted().get(selectedItem);
            if (!c.isAlreadyChat(targetUser)) {
                if (c.getData().checkExistOnline(targetUser)) {
                    c.client.requestChat(targetUser);
                }
                c.showChatBox(targetUser, null);
            }
        }

    }
    class UserListButtonClose extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            closeWindow();
        }

    }
    class UserListButtonOffMsg extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            c.getvOffMsg().setVisible(true);
        }

    }
    
    public void updateList() {
        DefaultListModel listModel = new DefaultListModel();
        c.getData().refresh();
        // List all users
        ArrayList<User> usersList = c.getData().getUsersSorted();
        ArrayList<ChatboxMessageListing> chatLists = c.getListMessageData();
        for (User user : usersList) {
            String text = "";
            if (c.getData().checkExistOnline(user)) {
                for (ChatboxMessageListing chatList : chatLists) {
                    if (chatList.getChat().receiver.getLogin().equals(user.getLogin())) {
                        chatList.getChat().isOnline = true;
                    }
                }
                text = user.getLogin() + " ( Online )";
            } else {
                for (ChatboxMessageListing chatList : chatLists) {
                    if (chatList.getChat().receiver.getLogin().equals(user.getLogin())) {
                        chatList.getChat().isOnline = false;
                    }
                }
                text = user.getFullName();
            }
            listModel.addElement(text);
        }

        c.getvListUser().getList_users().setModel(listModel);

        // categorize offline messages
        c.getData().categorizeOfflineMessage();

        // Set count offline messages
        int nOffMsg = c.getData().getMyOfflineMessages().size();
        JButton btn = c.getvListUser().getButton_offlineMessages();

        if (nOffMsg != 0) {
            btn.setText("Offline Message (" + nOffMsg + ")");
        }

    }
}
