
package Compute;

import Entities.Coordinate;
import Entities.Caro;
import Entities.Player;
import Middleware.Case;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AIControl {
    public static int DEPTH;
    private Caro map;
    private Coordinate move;
    private ArrayList<Integer> mapScores = new ArrayList<Integer>();
    private HashMap<Integer, AITranspositionEntry> transpositionTable;
    public static final int MIN_VALUE = -9999;
    public static final int MAX_VALUE = 9999;

    public AIControl() {
        transpositionTable = new HashMap<Integer, AITranspositionEntry>();
    }
    
    public void setBoard(Caro map) {
        this.map = map;
    }
    
    public Coordinate getMove() {
        Evaluation bestMove = negamax(map, DEPTH,  MIN_VALUE, MAX_VALUE);
        move = bestMove.coordinate;
        return move;
    }
    
    public int scoring(Caro map) {
        int turn = map.getTurn();
        if (--turn == -1) turn = map.players.size() - 1;
        Case match = new Case(map);
        if (match.getStatus() == 1 && map.players.get(turn).isBot()) return AIBrain.EVAL_LIST[0];
        if (match.getStatus() == 1 && !map.players.get(turn).isBot()) return AIBrain.EVAL_LIST[1];
        return 0;
    }
    public boolean terminal(Caro map) {
        int mapScore = scoring(map);
        if (mapScore == 0) {
            for (int i = 0; i < map.rows; i++) {
                for (int j = 0; j < map.cols; j++) {
                    if (map.getMap()[i][j] == 0) return false;
                }
            }
        }
        return true;
    }
    private ArrayList<Coordinate> getBlankMoves() {
        ArrayList<Coordinate> moves = new ArrayList<Coordinate>();
        for (int i = 0; i < map.rows; i++) {
            for (int j = 0; j < map.cols; j++) {
                if (map.getMap()[j][i] == 0) {
                    moves.add(new Coordinate(j,i));
                }
            }
        }
        return moves;
    }
    public Evaluation negamax(Caro map, int depth, int alpha,  int beta) {  
        // CHECK HEURISTIC NODE
        Player player = map.players.get(map.getTurn());  
        int prevTurn = map.getTurn();  
        if (--prevTurn == -1) prevTurn = map.players.size() - 1;  
        Player prevPlayer = map.players.get(prevTurn);  

        if (terminal(map) || depth == 0) {  
            int mapScore = scoring(map);  

            Coordinate lastNode = player.coords.get(player.coords.size() - 1);  
            if (mapScore != 0) lastNode = prevPlayer.coords.get(prevPlayer.coords.size() - 1);  

            Coordinate heuristicMove = new Coordinate(lastNode.x, lastNode.y);  

            return new Evaluation(heuristicMove, mapScore);  
        }
        // SET ORDERING MOVE
        ArrayList<Coordinate> possibleMoves = getBlankMoves();
        Evaluation bestNode = new Evaluation(new Coordinate(-1 , -1), MIN_VALUE);  
        for (int i = 0; i < possibleMoves.size(); i++) {
            Coordinate nextMove = possibleMoves.get(i);  

            player.coords.add(new Coordinate(nextMove.x, nextMove.y));  
            map.nextMove(nextMove.x, nextMove.y);  

            Evaluation nextNode = negamax(map, depth - 1, - beta, - alpha);  
            nextNode.coordinate = new Coordinate(nextMove.x, nextMove.y);  
            nextNode.score = - nextNode.score;
            bestNode = getMax(nextNode, bestNode);  
            alpha = Math.max(alpha, bestNode.score); 

            map.prevMove(nextMove.x, nextMove.y);  

            if (beta <= alpha) break;  
        }  
       
        return bestNode;  
    }
    public Evaluation getMin(Evaluation x, Evaluation y) {
       if (x.score < y.score) return x;
       return y;
    }
    public Evaluation getMax(Evaluation x, Evaluation y) {
        if (x.score > y.score) return x;
        return y;
    }
    class Evaluation {
        public int score;
        public Coordinate coordinate;

        public Evaluation(Coordinate coordinate, int score) {
            this.score = score;
            this.coordinate = coordinate;
        }
    }
}