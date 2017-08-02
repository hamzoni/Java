
package Entities;

import Compute.AIZobrist;
import Networking.Credential;
import java.io.Serializable;
import java.util.ArrayList;

public class Caro implements Serializable {
    public static int ROWS = 10;
    public static int COLS = 10;
    public static int CELLSIZE = 30;
    public int rows = 10;
    public int cols = 10;
    public int cellsize = 30;
    
    public int[][] mapZK;
    private int[][] map;
    private int turn;
    
    private Pair<Credential, Credential> duo;
    private String gameID;
    
    public ArrayList<Player> players;
    public ArrayList<Coordinate> coordinates;

    public void setDuo(Pair<Credential, Credential> duo) {
        this.duo = duo;
    }
    
    public Pair getDuo() {
        return duo;
    }
    
    public void setGameID(String gameID) {
        this.gameID = gameID;
    }
    
    public String getGameID() {
        return gameID;
    }
    
    public Caro() {
        players = new ArrayList<Player>();
        rows = ROWS;
        cols = COLS;
        reset();
    }
    public void reset() {
        coordinates = new ArrayList<Coordinate>();
        mapZK = new int[rows][cols];
        map = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mapZK[i][j] = AIZobrist.genKey();
                map[i][j] = 0; 
            }
        }
        this.turn = 0;
        for (Player player : players) {
            player.resetCoord();
        }
    }
    public void setMap(int[][] map) {
        this.map = map;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public int[][] getMap() {
        return map;
    }
    public int getTurn() {
        return turn;
    }
    public int getPrevTurn() {
        int prevTurn = this.getTurn() - 1;
        if (prevTurn == -1) prevTurn = this.players.size() - 1;
        return prevTurn;
    }
    public void nextMove(int i, int j) {
        this.coordinates.add(new Coordinate(i, j));
        map[i][j] = players.get(turn).getId();
        if (++turn == players.size()) turn = 0;
    }
    public void prevMove(int i, int j) {
        this.coordinates.remove(this.coordinates.size() - 1);
        map[i][j] = 0;
        if (--turn == -1) turn = players.size() - 1;
        int n = this.players.get(turn).coords.size();
        this.players.get(turn).coords.remove(n - 1);
    }
    
}
