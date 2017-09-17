
package DataStructure;

import Entities.Train;
import java.io.Serializable;

public class N_Train implements Serializable {
    public N_Train next;
    public Train data;

    public N_Train() {
    }

    public N_Train(Train data) {
        this.data = data;
    }
    
}
