
package Middleware;

import Entities.Coordinate;
import Entities.Caro;
import Entities.Player;
import java.util.ArrayList;

public class Case {
    private int status;
    private ArrayList<Coordinate> line;
    private ArrayList<Player> players;
    private Coordinate root;
    public Player player;
    private int winType;
    private Caro map;
    private int turn;
    private int winner;
    
    private int winmax = 4;

    public Case(Caro map) {
        check(map);
    }
    public void reset(Caro map) {
        this.status = -1;
        this.winType = 0;
        this.map = map;
    }
    public void check(Caro map) {
        reset(map);
        boolean isFull = map.coordinates.size() == map.cols * map.rows;
        this.players = map.players;
        for (Player p : this.players) {
            this.turn = this.players.indexOf(p);
            this.player = this.players.get(this.turn);
            
            if (player.coords.size() == 0) return;
            root = player.coords.get(player.coords.size() - 1);
            status = -1;
            if (status == -1) status = mapTracking(1) ? 1 : status; // 1
            if (status == -1) status = mapTracking(2) ? 1 : status; // 2            
            if (status == -1) status = mapTracking(3) ? 1 : status; // 3
            if (status == -1) status = mapTracking(4) ? 1 : status; // 4
            if (status == 1) {
                this.winner = this.turn;
                break;
            }
        }
        if (isFull && status == -1) status = 0;
    }
    public int getStatus() {
        return status;
    }
    public int getWinType() {
        return winType;
    }
    public int getWinner() {
        return winner;
    }
    public ArrayList<Coordinate> getWinLine() {
        return line;
    }

    private boolean mapTracking(int trackType) {
        ArrayList<Coordinate> winLine = new ArrayList<Coordinate>();
        int nextX, nextY, foundIndex = -1, n = 0;

        while (true) {
            if (trackType == 1) foundIndex = player.findCoord(new Coordinate(root.x, root.y + ++n));
            if (trackType == 2) foundIndex = player.findCoord(new Coordinate(root.x  + ++n, root.y));
            if (trackType == 3) foundIndex = player.findCoord(new Coordinate(root.x + ++n, root.y + n));
            if (trackType == 4) foundIndex = player.findCoord(new Coordinate(root.x - ++n, root.y + n));
            
            if (foundIndex == -1) break;
            winLine.add(player.coords.get(foundIndex));
        }
        n = 0;
        while (true) {
            if (trackType == 1) foundIndex = player.findCoord(new Coordinate(root.x, root.y - ++n));
            if (trackType == 2) foundIndex = player.findCoord(new Coordinate(root.x  - ++n, root.y));
            if (trackType == 3) foundIndex = player.findCoord(new Coordinate(root.x - ++n, root.y - n));
            if (trackType == 4) foundIndex = player.findCoord(new Coordinate(root.x + ++n, root.y - n));
            
            if (foundIndex == -1) break;
            winLine.add(player.coords.get(foundIndex));
        }
        
        winLine.add(root);
        if (trackType == 1) winLine = Coordinate.sortVertical(winLine);
        if (trackType == 2) winLine = Coordinate.sortHorizontal(winLine);
        if (trackType == 3) winLine = Coordinate.sortVertical(winLine);
        if (trackType == 4) winLine = Coordinate.sortVertical(winLine);
        boolean non_obstacle = true;
        if (winLine.size() >= winmax) {
            for (int i = 0; i < players.size(); i++) {
                if (i != this.turn) {
                    Coordinate startCoord = new Coordinate(-1,-1);
                    Coordinate endCoord = new Coordinate(-1,-1); 
                    if (trackType == 1) {
                        startCoord = new Coordinate(winLine.get(0).x, winLine.get(0).y - 1);
                        endCoord = new Coordinate(winLine.get(winLine.size() - 1).x, winLine.get(winLine.size() - 1).y + 1);
                    }
                    if (trackType == 2) {
                        startCoord = new Coordinate(winLine.get(0).x  - 1, winLine.get(0).y);
                        endCoord = new Coordinate(winLine.get(winLine.size() - 1).x + 1, winLine.get(winLine.size() - 1).y);
                    }
                    if (trackType == 3) {
                        startCoord = new Coordinate(winLine.get(0).x - 1, winLine.get(0).y - 1);
                        endCoord = new Coordinate(winLine.get(winLine.size() - 1).x + 1, winLine.get(winLine.size() - 1).y + 1);
                    }
                    if (trackType == 4) {
                        startCoord = new Coordinate(winLine.get(0).x + 1, winLine.get(0).y - 1);
                        endCoord = new Coordinate(winLine.get(winLine.size() - 1).x - 1, winLine.get(winLine.size() - 1).y + 1);
                    }
                    if (winLine.size() == winmax) non_obstacle = checkObstacle(startCoord, endCoord, i, false);
                    if (winLine.size() == winmax + 1) non_obstacle = checkObstacle(startCoord, endCoord, i, true);
                }
            }
            if (non_obstacle) {
                this.line = winLine;
                winType = trackType;
                return true;
            }
        }
        return false;
    }
    private boolean checkObstacle(Coordinate start, Coordinate end, int playerIndex, boolean full) {
        if (!full) {
            if (players.get(playerIndex).findCoord(start) != -1 ||
                players.get(playerIndex).findCoord(end) != -1) {
                return false;
            }
        } else {
            if (players.get(playerIndex).findCoord(start) != -1 &&
                players.get(playerIndex).findCoord(end) != -1) {
                return false;
            }
        }
        return true;
    }
}
