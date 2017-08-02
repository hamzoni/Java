
package Compute;

import Entities.Caro;
import Entities.Player;
import java.security.SecureRandom;

public class AIZobrist {
    public static int genKey() {
        SecureRandom random = new SecureRandom();
        int rand_n = random.nextInt();
        rand_n = Math.abs(rand_n);
        return rand_n;
    }
    public static int encode(Caro board) {
        int key = -1;
        Player playerX = board.players.get(0);
        Player playerO = board.players.get(1);
        for (int i = 0; i < board.cols; i++) {
            for (int j = 0; j < board.rows; j++) {
                key ^= board.mapZK[i][j];
                if (board.getMap()[i][j] == playerX.getId()) {
                    key ^=  playerX.getKey();
                } else {
                    key ^=  playerO.getKey();
                }
            }
        }
        return key;
    }
}
