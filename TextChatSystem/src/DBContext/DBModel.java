package DBContext;

import Entities.*;
import FileIO.FileController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DBModel {

    private final String userFn = "users.dat";
    private final String msgFn = "offline_messages.dat";

    private ArrayList<User> users;
    private ArrayList<User> usersOnline;
    private ArrayList<User> usersSorted;
    private ArrayList<OfflineMessage> offMsgs;
    private HashMap<String, ArrayList<OfflineMessage>> myOffMsgs;
    private FileController fc;

    // aUser store logged in user
    private User aUser;

    public DBModel() {
        users = new ArrayList<User>();
        usersOnline = new ArrayList<User>();
        usersSorted = new ArrayList<User>();
        offMsgs = new ArrayList<OfflineMessage>();
        myOffMsgs = new LinkedHashMap<String, ArrayList<OfflineMessage>>();
        fc = new FileController();
        aUser = new User();
        
        users = loadUsers();
        offMsgs = loadMsgs();
    }
    
    public void refresh() {
        users = loadUsers();
        offMsgs = loadMsgs();
    }

    public boolean checkExistOnline(User user) {
        if (usersOnline == null || user == null) return false;
        for (User user1 : usersOnline) {
            if (user1 == null) continue;
            if (user1.getLogin().equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistOnline(String username) {
        for (User user1 : usersOnline) {
            if (user1.getLogin().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User checkLogin(User u) {
        if (u == null) return null;
        for (User user : users) {
            if (user.getLogin().equals(u.getLogin()) && 
                    user.getPassword().equals(u.getPassword())) {
                return user;
            }
        }
        return null;
    }
    
    private ArrayList<OfflineMessage> loadMsgs() {
        ArrayList<OfflineMessage> data = (ArrayList<OfflineMessage>) fc.read(msgFn);
        if (data == null) data = new ArrayList<OfflineMessage>();
        return data;
    }
    private ArrayList<User> loadUsers() {
        ArrayList<User> data = (ArrayList<User>) fc.read(userFn);
        if (data == null) data = new ArrayList<User>();
        return data;
    }

    private void saveMsg(boolean nonstack) {
        // open and merge data first
        if (!nonstack) {
            ArrayList<OfflineMessage> sMsgs = loadMsgs();
            for (OfflineMessage sMsg : sMsgs) {
                if (!checkDupMsg(sMsg)) 
                    offMsgs.add(sMsg);
            }
        }
        // then save the data
        fc.write(offMsgs, msgFn);
    }
    
    
    private void saveUsers() {
        fc.write(users, userFn);
    }
    public boolean checkDupMsg(OfflineMessage msg) {
        for (OfflineMessage offMsg : offMsgs) {
            if (offMsg.getReceiver().equals(msg.getReceiver()) &&
                    offMsg.getSender().equals(msg.getSender())) {
                return true;
            }
        }
        return false;
    }

    public void categorizeOfflineMessage() {
        // categorize them as well
        for (OfflineMessage storedMessage : offMsgs) {
            if (storedMessage.getReceiver().equals(aUser.getLogin()) && 
                    storedMessage.getStatus() == OfflineMessage.UNREAD) {
                String sender = storedMessage.getSender();
                if (myOffMsgs.containsKey(sender)) {
                    myOffMsgs.get(sender).add(storedMessage);
                } else {
                    ArrayList<OfflineMessage> msg = new ArrayList<OfflineMessage>();
                    msg.add(storedMessage);
                    myOffMsgs.put(sender, msg);
                }
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public void addUser(String login, String password, String fullname) {
        User user = new User(fullname, login, password);
        users.add(user);
        saveUsers();
    }

    public void addOfflineMessage(OfflineMessage msg) {
        offMsgs.add(msg);
        saveMsg(false);
    }

    public void addOfflineMessage(String sender, String receiver, String message) {
        int idx = checkExistOfflineMessage(sender, receiver);
        OfflineMessage msg = new OfflineMessage();
        if (idx != -1) {
            msg = offMsgs.get(idx);
            msg.addMessage(message);
            offMsgs.remove(idx);
            offMsgs.add(msg);
        } else {
            msg.setSender(sender);
            msg.setReceiver(receiver);
            msg.addMessage(message);
            msg.setStatus(OfflineMessage.UNREAD);
            offMsgs.add(msg);
        }
        saveMsg(false);
    }

    private int checkExistOfflineMessage(String sender, String receiver) {
        // check if there is already a pair existed 
        for (int i = 0; i <  offMsgs.size(); i++) {
            OfflineMessage msg = offMsgs.get(i);
            if (msg.getReceiver().equals(receiver) && msg.getSender().equals(sender)) {
                return i;
            }
        }
        return -1;
    }

    public HashMap<String, ArrayList<OfflineMessage>> getMyOfflineMessages() {
        return myOffMsgs;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<User> getUsersOnline() {
        return usersOnline;
    }

    // Calling user
    public void setUsersOnline(ArrayList<User> usersOnline, User newUser) {
        this.usersOnline = usersOnline;
        // add new user if there is new
        if (newUser != null && !duplicateUser(newUser) && 
                !newUser.equals(aUser.getLogin())) {
            users.add(newUser);
        }
        // sort by version
        setUsersSorted();
    }
    
    private boolean duplicateUser(User user) {
        for (User user1 : users) {
            if (user1.getLogin().equals(user.getLogin()))
                return true;
        }
        return false;
    }
    
    public void setUsersSorted() {
        usersSorted = new ArrayList<User>();
        // (me) go first
        for (User user : users) {
            if (checkExistOnline(user) && !user.getLogin().equals(aUser.getLogin())) {
                usersSorted.add(user);
                if (usersSorted.size() == usersOnline.size()) {
                    break;
                }
            }
        }
        // List the rest of users
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

    public void removeReadMessage(String sender) {
        for (int i = 0; i < offMsgs.size(); i++) {
            OfflineMessage offMsg = offMsgs.get(i);
            if (offMsg.getSender().equals(sender) &&
                    offMsg.getReceiver().equals(aUser.getLogin())) {
                offMsgs.remove(offMsg);
            }
        }
        saveMsg(true);
    }

}
