
package Action;

import Controller.Controller;

public abstract class Event {
    protected Controller c;
    
    public Event(Controller c) {
        this.c = c;
    }
    
    protected abstract void setEventListeners();
    protected abstract void setCompContents();
    
}
