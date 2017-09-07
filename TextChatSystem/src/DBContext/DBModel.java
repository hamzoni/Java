
package DBContext;

import Entities.*;
import FileIO.FileController;
import java.util.ArrayList;

public class DBModel {
    private final String userFn = "users.txt";
    private final String msgFn = "offline_messages.txt";
    
    private ArrayList<User> users;
    private ArrayList<OfflineMessage> offlineMessages;
    private FileController fc;
    
    // aUser store logged in user
    private User aUser;
    
    public DBModel() {
        users = new ArrayList<User>();
        offlineMessages = new ArrayList<OfflineMessage>();
        fc = new FileController();
        aUser = new User();
        
        loadData();
    }
    
    public boolean checkLogin(String username, String password) {
        for (User user : users) {
            if (user.getLogin().equals(username)  && user.getPassword().equals(password)) {
                this.aUser = user;
                return true;
            }
        }
        return false;
    }
    
    private void loadData() {
        Object storedMessages = fc.read(msgFn);
        if (storedMessages != null) {
            offlineMessages = (ArrayList<OfflineMessage>) storedMessages;
        }
        
        Object storedUsers = fc.read(userFn);
        if (storedUsers != null) {
            users = (ArrayList<User>) storedUsers ;
        }
    }
    
    private void saveData() {
        fc.write(users, userFn);
        fc.write(offlineMessages, msgFn);
    }
    
    public void addUser(User user) {
        users.add(user);
        saveData();
    }
    
    public void addUser(String login, String password, String fullname) {
        User user = new User(fullname, login, password);
        users.add(user);
        saveData();
    }
    
    public void addOfflineMessage(OfflineMessage msg) {
        offlineMessages.add(msg);
        saveData();
    }
     
    public void addOfflineMessage(String sender, String receiver, String message) {
        OfflineMessage msg = new OfflineMessage(sender, receiver, message);
        offlineMessages.add(msg);
        saveData();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<OfflineMessage> getOfflineMessages() {
        return offlineMessages;
    }

    public void setOfflineMessages(ArrayList<OfflineMessage> offlineMessages) {
        this.offlineMessages = offlineMessages;
    }

    public User getaUser() {
        return aUser;
    }

    public void setaUser(User aUser) {
        this.aUser = aUser;
    }
    
}
