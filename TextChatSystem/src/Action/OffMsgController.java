package Action;

import Controller.Controller;
import Entities.OfflineMessage;
import Entities.User;
import GUI.ChatOffline;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.WindowConstants;

public class OffMsgController {
    private ChatOffline vOffMsg;
    public static ArrayList<Map.Entry> senders;
    private Controller c;
    
    public OffMsgController(ChatOffline vOffMsg, Controller c) {
        this.vOffMsg = vOffMsg;
        this.c = c;
        
        vOffMsg.getButton_read().addActionListener(new OffMsgButtonRead());
        vOffMsg.getButton_close().addActionListener(new OffMsgButtonClose());
        vOffMsg.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        vOffMsg.getLabel_loginName().setText(c.getData().getaUser().getLogin());
        
        vOffMsg.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vOffMsg.setVisible(false);
            }
        });
    }
    
    public class OffMsgListing extends Action {

        private ChatOffline f;

        public OffMsgListing() {
            this.f = c.getvOffMsg();
            senders = new ArrayList<Map.Entry>();
        }
        
        @Override
        // action is triggered from userList view
        public void actionPerformed(ActionEvent e) {
            this.f.setVisible(true);
            // List all off line messages
            DefaultListModel listModel = new DefaultListModel();
            HashMap<String, ArrayList<OfflineMessage>> msgs = c.getData().getMyOfflineMessages();

            Iterator it = msgs.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                ArrayList<OfflineMessage> offMsgs = (ArrayList<OfflineMessage>) pair.getValue();
                // calculate number of messages line
                int nMsgs  = 0;
                for (OfflineMessage offMsg : offMsgs) {
                    nMsgs += offMsg.getMessage().size();
                }
                listModel.addElement(pair.getKey() + " (" + nMsgs + ")");
                senders.add(pair);
            }
            this.f.getList_offlineMessage().setModel(listModel);
        }

    }
    public class OffMsgButtonClose extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            c.getvOffMsg().setVisible(false);
        }

    }
    public class OffMsgButtonRead extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idx = c.getvOffMsg().getList_offlineMessage().getSelectedIndex();
            String sender = (String) senders.get(idx).getKey();
            ArrayList<OfflineMessage> msgs = (ArrayList<OfflineMessage>) senders.get(idx).getValue();

            User targetUser = null;
            for (User user : c.getData().getUsersSorted()) {
                if (user.getLogin().equals(sender)) {
                    targetUser = user;
                    break;
                }
            }

            if (!c.isAlreadyChat(targetUser)) {
                if (c.getData().checkExistOnline(targetUser)) {
                    c.client.requestChat(targetUser);
                }
                c.showChatBox(targetUser, msgs);
                // delete read message
                c.getData().removeReadMessage(sender);
            }
        }

    }
    
}