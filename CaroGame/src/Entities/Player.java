package Entities;

import Compute.AIZobrist;
import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private int id;
    private int key;
    private String name;
    private Score score;
    private boolean botPlayer = false;
    public ArrayList<Coordinate> coords;
    public Player(int id, String name, boolean isBot) {
        botPlayer = isBot;
        coords = new ArrayList<Coordinate>();
        score = new Score();
        this.key = AIZobrist.genKey();
        this.name = name;
        this.id = id;
    }
    public boolean isBot() {
        return botPlayer;
    }
    public int getId() {
        return id;
    }
    public int getKey() {
        return key;
    }
    public String getName() {
        return name;
    }
    public Score getScore() {
        return score;
    }
    public int findCoord(Coordinate c) {
        for (int i = 0; i < coords.size(); i++) {
            if (coords.get(i).x == c.x && coords.get(i).y == c.y) {
                return i;
            }
        }
        return -1;
    }
    public void resetCoord() {
        coords = new ArrayList<Coordinate>();
    }
}
