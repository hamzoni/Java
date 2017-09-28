package Action;

import Action.ChatboxController.ChatboxMessageListing;
import Action.OffMsgController.OffMsgListing;
import Controller.Controller;
import Entities.User;
import GUI.ListUser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListModel;

public class UserListController {

    private ListUser vListUser;
    private UserListing userListing;
    private Controller c;
    public UserListController(ListUser vListUser, Controller c) {
        this.vListUser = vListUser;
        this.c = c;
        userListing = new UserListing(c);
        vListUser.getList_users().addMouseListener(userListing);
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
    public ListUser getvListUser() {
        return vListUser;
    }

    public void setvListUser(ListUser vListUser) {
        this.vListUser = vListUser;
    }

    public Controller getC() {
        return c;
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public UserListing getUserListing() {
        return userListing;
    }

    public void setUserListing(UserListing userListing) {
        this.userListing = userListing;
    }

    public void updateList() {
        userListing.updateList();
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
            int selectedItem = c.getUserListCtrl().getUserListing().getSelectedItem();
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
    class UserListing implements MouseListener {

        private Controller c;
        private int selectedItem;

        public UserListing(Controller c) {
            this.c = c;
        }

        public void updateList() {
            DefaultListModel listModel = new DefaultListModel();

            // List all users
            ArrayList<User> usersList = this.c.getData().getUsersSorted();
            ArrayList<ChatboxMessageListing> chatLists = this.c.getListMessageData();
            for (User user : usersList) {
                String text = "";
                if (this.c.getData().checkExistOnline(user)) {
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

            this.c.getvListUser().getList_users().setModel(listModel);

            // categorize offline messages
            this.c.getData().categorizeOfflineMessage();

            // Set count offline messages
            int nOffMsg = this.c.getData().getMyOfflineMessages().size();
            JButton btn = this.c.getvListUser().getButton_offlineMessages();

            if (nOffMsg != 0) {
                btn.setText("Offline Message (" + nOffMsg + ")");
            }

        }

        public int getSelectedItem() {
            return selectedItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JList list = this.c.getvListUser().getList_users();
            ListModel listModel = list.getModel();
            selectedItem = list.getSelectedIndex();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
