
package Action;

import Controller.Controller;
import GUI.Chat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
