
package Action;

import Controller.Controller;
import java.awt.event.ActionListener;

public abstract class Action implements ActionListener {
    protected Controller c;
    public Action(Controller c) {
        this.c = c;
    }
}
