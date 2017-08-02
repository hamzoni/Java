
package Entities;

import java.io.Serializable;

public class Score implements Serializable{
    public int win, lose, drawn;
    public int steps;
    
    public Score() {
        this.win = 0;
        this.lose = 0;
        this.drawn = 0;
        this.steps = 0;
    }
}
