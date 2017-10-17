
package Controller;

import Entity.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class GameData implements Serializable {
    
    public static final int TURNX = 0;
    public static final int TURNO = 1;
    
    private int rows;
    private int cols;
    private int cell;
    
    private int gameID;
    
    private String playerA; // X
    private String playerB; // O
    
    private int[][] board;
    private int turn;
    private boolean run;
    
    public ArrayList<Point> ma;
    public ArrayList<Point> mb;
    public Rule rule;

    public GameData(int cols, int rows) {
        run = true;
        createBoard(cols, rows);
    }
    
    
    private void createBoard(int cols, int rows) {
        ma = new ArrayList<Point>();
        mb = new ArrayList<Point>();
        this.cols = cols;
        this.rows= rows;
        this.cell = 30;
        board = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = -1;
            }
        }
    }
    
    public boolean playerMove(Point p) {
        if (p.x < cols && p.y < rows) {
            if (board[p.x][p.y] != -1) return false;
            board[p.x][p.y] = turn == TURNX ? TURNX : TURNO;
            
            if (turn == TURNX) {
                ma.add(p);
            } else {
                mb.add(p);
            }
            
            rule = new Rule(this, p, turn);
            if (rule.getGameStatus() == Rule.WIN || rule.getGameStatus() == Rule.DRAWN) {
                run = false;
            }
            
            turn = turn == TURNX ? TURNO : TURNX;
            return true;
        }
        return false;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getPlayerA() {
        return playerA;
    }

    public void setPlayerA(String playerA) {
        this.playerA = playerA;
    }

    public String getPlayerB() {
        return playerB;
    }

    public void setPlayerB(String playerB) {
        this.playerB = playerB;
    }

    public int[][] getBoard() {
        return board;
    }
    
    public void logBoard() {
         for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                 System.out.print(board[i][j] + " ");
            }
             System.out.println();
        }
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isRun() {
        return run;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }
    
}
