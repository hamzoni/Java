package Controller;

import Entity.Point;
import java.io.Serializable;
import java.util.ArrayList;


public class Rule implements Serializable {
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;
    public static final int DIALEFT = 2;
    public static final int DIARIGHT = 3;
    
    public static final int WIN = 0;
    public static final int DRAWN = 1;
    public static final int CONT = 2;
    
    private static final int MAXMOVE = 4;
    
    private GameData data;
    private int[][] board;
    private Point root;
    private int turn;
    private int opponentTurn;
    
    private ArrayList<Point> winPath;
    private int gameStatus;
    private int winType;
    
    private ArrayList<Point> moves;

    public Rule(GameData data, Point root, int turn) {
        this.data = data;
        this.board = data.getBoard();
        this.root = root;
        this.turn = turn;
        this.opponentTurn = turn == GameData.TURNO ? GameData.TURNX : GameData.TURNO;
        this.gameStatus = CONT;
        analyze();
    }
    
    private void analyze() {
        if (data.ma.size() + data.mb.size() == data.getCols() * data.getRows()) {
            gameStatus = DRAWN;
        } else {
            moves = turn == GameData.TURNX ? data.ma : data.mb;
            if (moves.size() == 0) return;
            performAudit();
        }
    }
    
    public void performAudit() {
        if (gameStatus == CONT) gameStatus = mapTracking(VERTICAL) ? WIN : CONT; // 1
        if (gameStatus == CONT) gameStatus = mapTracking(HORIZONTAL) ? WIN : CONT; // 2            
        if (gameStatus == CONT) gameStatus = mapTracking(DIALEFT) ? WIN : CONT; // 3
        if (gameStatus == CONT) gameStatus = mapTracking(DIARIGHT) ? WIN : CONT; // 4
    }
    
    private int findCoord(Point p, int player) {
        ArrayList<Point> moves = player == GameData.TURNX ? data.ma : data.mb;
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).x == p.x && moves.get(i).y == p.y) {
                return i;
            }
        }
        return -1;
    }
    
     private int findCoord(Point p) {
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).x == p.x && moves.get(i).y == p.y) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean mapTracking(int trackType) {
        ArrayList<Point> winLine = new ArrayList<Point>();
        int nextX, nextY, idx = -1, n = 0;
        
        winLine.add(root);
        
        boolean trackt[] = {false, false, false, false};
        trackt[trackType] = true;
        
        while (true) {
            if (trackt[0]) idx = findCoord(new Point(root.x, root.y + ++n));
            if (trackt[1]) idx = findCoord(new Point(root.x  + ++n, root.y));
            if (trackt[2]) idx = findCoord(new Point(root.x + ++n, root.y + n));
            if (trackt[3]) idx = findCoord(new Point(root.x - ++n, root.y + n));
            if (idx == -1) break;
            winLine.add(moves.get(idx));
        }
        n = 0;
        while (true) {
            if (trackt[0]) idx = findCoord(new Point(root.x, root.y - ++n));
            if (trackt[1]) idx = findCoord(new Point(root.x  - ++n, root.y));
            if (trackt[2]) idx = findCoord(new Point(root.x - ++n, root.y - n));
            if (trackt[3]) idx = findCoord(new Point(root.x + ++n, root.y - n));
            
            if (idx == -1) break;
            winLine.add(moves.get(idx));
        }
        
        if (trackt[0]) winLine = Point.sortVertical(winLine);
        if (trackt[1]) winLine = Point.sortHorizontal(winLine);
        if (trackt[2]) winLine = Point.sortVertical(winLine);
        if (trackt[3]) winLine = Point.sortVertical(winLine);
        
        boolean non_obstacle = true;
        if (winLine.size() >= MAXMOVE) {
            
                Point sc = new Point(-1,-1);
                Point ec = new Point(-1,-1); 
                
                if (trackt[0]) {
                    sc = new Point(winLine.get(0).x, winLine.get(0).y - 1);
                    ec = new Point(winLine.get(winLine.size() - 1).x, winLine.get(winLine.size() - 1).y + 1);
                }
                if (trackt[1]) {
                    sc = new Point(winLine.get(0).x  - 1, winLine.get(0).y);
                    ec = new Point(winLine.get(winLine.size() - 1).x + 1, winLine.get(winLine.size() - 1).y);
                }
                if (trackt[2]) {
                    sc = new Point(winLine.get(0).x - 1, winLine.get(0).y - 1);
                    ec = new Point(winLine.get(winLine.size() - 1).x + 1, winLine.get(winLine.size() - 1).y + 1);
                }
                if (trackt[3]) {
                    sc = new Point(winLine.get(0).x + 1, winLine.get(0).y - 1);
                    ec = new Point(winLine.get(winLine.size() - 1).x - 1, winLine.get(winLine.size() - 1).y + 1);
                }
                
                if (winLine.size() == MAXMOVE) non_obstacle = checkObstacle(sc, ec, opponentTurn, false);
                if (winLine.size() == MAXMOVE + 1) non_obstacle = checkObstacle(sc, ec, opponentTurn, true);
            if (non_obstacle) {
                winPath = winLine;
                winType = trackType;
                return true;
            }
        }
        return false;
    }
    private boolean checkObstacle(Point start, Point end, int player, boolean full) {
        if (!full) {
            if (findCoord(start, player) != -1 ||
                findCoord(end, player) != -1) {
                return false;
            }
        } else {
            if (findCoord(start, player) != -1 &&
                findCoord(end, player) != -1) {
                return false;
            }
        }
        return true;
    }

    public static int getMAXMOVE() {
        return MAXMOVE;
    }

    public Point getRoot() {
        return root;
    }

    public int getTurn() {
        return turn;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public int getWinType() {
        return winType;
    }

    public ArrayList<Point> getWinPath() {
        return winPath;
    }
    
}
