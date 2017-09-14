
package Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class OfflineMessage implements Serializable {
    public static final int UNREAD = 0;
    public static final int READ = 1;
    
    private String sender;
    private String receiver;
    private ArrayList<String> messages;
    private int status;

    public OfflineMessage() {
        messages = new ArrayList<String>();
    }

    public OfflineMessage(String sender, String receiver, ArrayList<String> message) {
        this.sender = sender;
        this.receiver = receiver;
        this.messages = message;
    }
    

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public ArrayList<String> getMessage() {
        return messages;
    }
    
    public void addMessage(String message) {
        messages.add(message);
    }
    
    public void setMessage(ArrayList<String> message) {
        this.messages = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OfflineMessage{" + "sender=" + sender + ", receiver=" + receiver + ", messages=" + messages + ", status=" + status + '}';
    }
    
}
