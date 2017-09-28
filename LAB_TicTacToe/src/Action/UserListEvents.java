
package Action;

import Controller.Controller;
import Controller.GameConfig;
import GUI.UserList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class UserListEvents <T> extends Event {

    private UserList gui;
    private ArrayList<String> usersList;
    private GameConfig gcf;
    
    public UserListEvents(Controller c, T gui) {
        super(c);
        this.gui = (UserList) gui;
        this.gcf = new GameConfig(10, 10);
        setEventListeners();
        setCompContents();
    }

    @Override
    protected void setEventListeners() {
        
        gui.getButton_invite().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int idx = gui.getList_users().getSelectedIndex();
                if (idx != -1) {
                    c.invitePlayer(usersList.get(idx), gcf);
                }
            }
        });
        gui.getInput_boardsize().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    
                    String sizeTxt = gui.getInput_boardsize().getText();
                    int size = Integer.parseInt(sizeTxt);
                    gcf.cols = gcf.rows = size;
                } catch (NumberFormatException err) {
                    // Default size
                    gcf.cols = gcf.rows = 10;
                    gui.getInput_boardsize().setText(gcf.cols + "");
                }
            }
        });
        
        gui.addWindowListener(new WindowAdapter() {
           @Override
            public void windowClosing(WindowEvent e) {
                c.exitGame();
            }
        });
    }
    
    public void updateUsersList(ArrayList<String> usersList) {
        this.usersList = usersList;
        
        JList lists = gui.getList_users();
        DefaultListModel<String> model = new DefaultListModel<>();
        
        if (usersList == null) {
            model.removeAllElements();
            lists.setModel(model);
            return;
        }
        
        // Update list - userlist in local must not have owner
        for (String username : usersList) {
            if (!username.equals(c.me)) {
                model.addElement(username);
            }
        }
        
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).equals(c.me)) {
                usersList.remove(i);
            }
            
        }
   
        lists.setModel(model);
    }

    @Override
    protected void setCompContents() {
        gui.setTitle(c.me);
        gui.getInput_boardsize().setText(gcf.cols + "");
    }
    
}
