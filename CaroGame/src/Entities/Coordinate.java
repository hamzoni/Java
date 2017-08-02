
package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Coordinate implements Serializable {
    public int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static ArrayList<Coordinate> sortVertical(ArrayList<Coordinate> coords) {
        Collections.sort(coords, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate c2, Coordinate c1) {
                return  c2.y - c1.y;
            }
        });
        return coords;
    }
    public static ArrayList<Coordinate> sortHorizontal(ArrayList<Coordinate> coords) {
        Collections.sort(coords, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate c2, Coordinate c1) {
                return  c2.x - c1.x;
            }
        });
        return coords;
    }
}
