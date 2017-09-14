
package Action;

import Controller.Controller;
import Entities.User;
import GUI.Chat;
import java.util.ArrayList;
import javax.swing.JButton;

public class ChatboxMessageListing {
    private Controller c;
    private Chat chat;
    private ArrayList<String> messages;
    private ArrayList<User> userTurns;
    
    public ChatboxMessageListing(Controller c, Chat chat) {
        this.c = c;
        this.chat = chat;
        this.messages = new ArrayList<String>();
        this.userTurns = new ArrayList<User>();
        
        chat.getInput_message().addKeyListener(new ChatboxMessageKey(chat));
        
        // Set title
        String userA = c.getData().getaUser().getFullName();
        String userB =  chat.receiver.getFullName();
        String title = userA + " (me) chatting with " + userB;
        chat.getSendFrom().setText(userA);
        chat.getSendTo().setText(userB);
        this.chat.setTitle(title);
        
    }
    
    public void updateMessagesList(User userTurn, String newMessage) {
        this.userTurns.add(userTurn);
        this.messages.add(newMessage);
        
        String msgList = "";
        for (int i = 0; i < messages.size(); i++) {
            msgList += userTurns.get(i).getFullName();
            if (userTurns.get(i).getLogin().equals(c.getData().getaUser().getLogin())) {
                msgList += " (me) ";
            }
            msgList += ": " + messages.get(i) +"\n";
        }
        this.chat.getTextarea_chatbox().setText(msgList);
    }

    public Chat getChat() {
        return chat;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public ArrayList<User> getUserTurns() {
        return userTurns;
    }
    
}
