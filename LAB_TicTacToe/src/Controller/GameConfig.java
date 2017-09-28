
package Controller;

import java.io.Serializable;

public class GameConfig implements Serializable {
    public int cols;
    public int rows;

    public GameConfig(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "GameConfig{" + "cols=" + cols + ", rows=" + rows + '}';
    }
    
}
