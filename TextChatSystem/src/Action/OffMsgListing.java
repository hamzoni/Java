
package Action;

import Controller.Controller;
import Entities.OfflineMessage;
import Entities.User;
import GUI.ChatOffline;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;

public class OffMsgListing extends Action {
    private ChatOffline f; 
    public static ArrayList<Map.Entry> senders;
    
    public OffMsgListing(Controller c) {
        super(c);
        this.f = this.c.getvOffMsg();
        OffMsgListing.senders = new ArrayList<Map.Entry>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.f.setVisible(true);
        // List all off line messages
        DefaultListModel listModel = new DefaultListModel();
        HashMap<String, ArrayList<OfflineMessage>> msgs = this.c.getData().getMyOfflineMessages();
        
        Iterator it = msgs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            ArrayList<OfflineMessage> value = (ArrayList<OfflineMessage>) pair.getValue();
            listModel.addElement(pair.getKey() + " (" + value.size() + ")");
            OffMsgListing.senders.add(pair);
        }
        
        this.f.getList_offlineMessage().setModel(listModel);
    }
    
}
