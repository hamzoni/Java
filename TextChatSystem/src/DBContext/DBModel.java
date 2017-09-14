
package DBContext;

import Entities.*;
import FileIO.FileController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DBModel {
    private final String userFn = "users.txt";
    private final String msgFn = "offline_messages.txt";
    
    private ArrayList<User> users;
    private ArrayList<User> usersOnline;
    private ArrayList<User> usersSorted;
    private ArrayList<OfflineMessage> offlineMessages;
    private HashMap<String, ArrayList<OfflineMessage>> myOfflineMessages;
    private FileController fc;
    
    // aUser store logged in user
    private User aUser;
    
    public DBModel() {
        users = new ArrayList<User>();
        usersOnline = new ArrayList<User>();
        usersSorted = new ArrayList<User>();
        offlineMessages = new ArrayList<OfflineMessage>();
        myOfflineMessages = new LinkedHashMap<String, ArrayList<OfflineMessage>>();
        fc = new FileController();
        aUser = new User();
        
        loadData();
    }
    
    public boolean checkExistOnline(User user) {
        for (User user1 : usersOnline) {
            if (user1.getLogin().equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkExistOnline(String user) {
        for (User user1 : usersOnline) {
            if (user1.getLogin().equals(user)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkLogin(String username, String password) {
        for (User user : users) {
            if (user.getLogin().equals(username) && user.getPassword().equals(password)) {
                this.aUser = user;
                return true;
            }
        }
        return false;
    }
    
    private void loadData() {
         // load stored message
        offlineMessages = (ArrayList<OfflineMessage>) fc.read(msgFn);
        if (offlineMessages == null) {
            offlineMessages = new ArrayList<OfflineMessage>();
        }
        
        // load stored user
        Object storedUsers = fc.read(userFn);
        if (storedUsers != null) {
            users = (ArrayList<User>) storedUsers ; 
        }
        
    }
    
    private void saveData() {
        fc.write(users, userFn);
        fc.write(offlineMessages, msgFn);
    }
    
    public void categorizeOfflineMessage() {
        // categorize them as well
        for (OfflineMessage storedMessage : offlineMessages) {
            if (storedMessage.getReceiver().equals(aUser.getLogin())) {
                String sender = storedMessage.getSender();
                if (myOfflineMessages.containsKey(sender)) {
                    myOfflineMessages.get(sender).add(storedMessage);
                } else {
                    ArrayList<OfflineMessage> msg = new ArrayList<OfflineMessage>();
                    msg.add(storedMessage);
                    myOfflineMessages.put(sender, msg);
                }
            }
        }
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
        OfflineMessage msg = checkExistOfflineMessage(sender, receiver);
        if (msg != null) {
            msg.addMessage(message);
        } else {
            msg = new OfflineMessage();
            msg.setSender(sender);
            msg.setReceiver(receiver);
            msg.addMessage(message);
            msg.setStatus(OfflineMessage.UNREAD);
            offlineMessages.add(msg);
            saveData();
        }
    }
    
    private OfflineMessage checkExistOfflineMessage(String sender, String receiver) {
        // check if there is already a pair existed 
        for (OfflineMessage offlineMessage : offlineMessages) {
            if (offlineMessage.getReceiver().equals(receiver) &&
                    offlineMessage.getSender().equals(sender)) {
                return offlineMessage;
            }
        }
        return null;
    }
    

    public HashMap<String, ArrayList<OfflineMessage>> getMyOfflineMessages() {
        return myOfflineMessages;
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
  

    public ArrayList<User> getUsersOnline() {
        return usersOnline;
    }

    public void setUsersOnline(ArrayList<User> usersOnline) {
        this.usersOnline = usersOnline;
        setUsersSorted();
    }
    
    public void setUsersSorted() {
        usersSorted = new ArrayList<User>();
        for (User user : users) {
            if (checkExistOnline(user) && !user.getLogin().equals(aUser.getLogin())) {
                usersSorted.add(user);
                if (usersSorted.size() == usersOnline.size()) {
                    break;
                }
            }
        }
        
        for (User user : users) {
            if (!checkExistOnline(user) && !user.getLogin().equals(aUser.getLogin())) {
                usersSorted.add(user);
            }
        }
    }

    public ArrayList<User> getUsersSorted() {
        return usersSorted;
    }

    public User getaUser() {
        return aUser;
    }

    public void setaUser(User aUser) {
        this.aUser = aUser;
    }
    
}
