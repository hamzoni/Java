
package Compute;

import Compute.AIControl.Evaluation;
import java.security.SecureRandom;

public class AITranspositionEntry {
    private int remainingNode;
    private Evaluation node;

    public AITranspositionEntry(Evaluation node, int remainingNode) {
        this.node = node;
        this.remainingNode = remainingNode;
    }
    public Evaluation getNode() {
        return node;
    }
    public int getRemainingNode() {
        return remainingNode;
    }
}

