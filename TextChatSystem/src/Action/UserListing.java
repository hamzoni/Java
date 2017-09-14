package Action;

import Controller.Controller;
import Entities.User;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListModel;

public class UserListing implements MouseListener {
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
            btn.setText(btn.getText() + " (" + nOffMsg + ")");
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
