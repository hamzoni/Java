
package Action;

import Controller.Controller;
import Controller.GameConfig;
import GUI.DialogInvite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogInviteEvents <T> extends Event {
    
    private DialogInvite gui;
    private GameConfig gcf;
    private int dlgID;
    private String sender;
    
    public DialogInviteEvents(Controller c, T gui) {
        super(c);
        this.gui = (DialogInvite) gui;
        setEventListeners();
    }
    
    public void closeGUI() {
        gui.dispose();
    }

    @Override
    protected void setEventListeners() {
        gui.getButton_accept().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.acceptInvite(sender, gcf.cols, gcf.rows);
                gui.dispose();
                c.dlgInvCtrls.remove(dlgID);
            }
        });
        gui.getButton_reject().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.dispose();
                c.dlgInvCtrls.remove(dlgID);
            }
        });
    }
    
    @Override
    protected void setCompContents() {
        String txt = "Do you want to play Caro(" + gcf.cols + "x" + gcf.rows + ") with " + sender + "?";
        gui.getLabel_playerRequest().setText(txt);
    }

    public void setSender(String sender) {
        this.sender = sender;
        setCompContents();
    }

    public String getSender() {
        return sender;
    }
    
    public void setDlgID(int dlgID) {
        this.dlgID = dlgID;
    }

    public void setGcf(GameConfig gcf) {
        this.gcf = gcf;
    }
    
}
