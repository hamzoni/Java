package Action;

import Controller.Controller;
import Entities.User;
import GUI.Chat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatboxController {
    private Controller c;
    
    public ChatboxController(Controller c) {
        this.c = c;
    }
    
    public class ChatboxMessageListing {
        private Chat chat;
        
        public ChatboxMessageListing(Chat chat) {
            this.chat = chat;
            chat.getInput_message().addKeyListener(new ChatboxMessageKey(chat));

            // Set title
            String userA = c.getData().getaUser().getFullName();
            String userB = chat.receiver.getFullName();
            String title = userA + " (me) chatting with " + userB;
            chat.getSendFrom().setText(userA);
            chat.getSendTo().setText(userB);
            chat.setTitle(title);
            // Set event listener
            setEvents();
        }
        
        public void setEvents() {
            chat.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    c.removeChatbox(chat.receiver, false);
                }
            });
        }
        
        // Use in Controller
        public void updateMessagesList(User userTurn, String newMessage) {
            chat.setVisible(true);
            chat.getTextarea_chatbox().append(userTurn.getFullName() + ": " + newMessage + "\n");
        }

        public Chat getChat() {
            return chat;
        }

    }
    public class ChatboxButtonSend extends Action {

        private Chat chat;

        public ChatboxButtonSend(Chat chat) {
            this.chat = chat;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            User target = this.chat.receiver;
            User source = c.getData().getaUser();
            String message = this.chat.getInput_message().getText();
            
            if (message.length() == 0) return;
            
            this.chat.getInput_message().setText("");
            // push current chat to UI
            chat.getTextarea_chatbox().append(source.getFullName() +"(me): " + message + "\n");
            if (this.chat.isOnline) {
                c.client.sendMessage(target, message);
            } else {
                c.getData().addOfflineMessage(source.getLogin(), target.getLogin(), message);
            }
        }

    }
    public class ChatboxMessageKey implements KeyListener {

        private Chat c;

        public ChatboxMessageKey(Chat c) {
            this.c = c;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                c.getButton_sendMessage().doClick();
            }
        }

    }

}
