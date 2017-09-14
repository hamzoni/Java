
package Action;

import Controller.Controller;
import java.awt.event.ActionEvent;

public class OffMsgButtonClose extends Action {

    public OffMsgButtonClose(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.c.getvOffMsg().setVisible(false);
    }
    
}
