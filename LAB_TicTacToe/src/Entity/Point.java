
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Point implements Serializable {
    public int x;
    public int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static ArrayList<Point> sortVertical(ArrayList<Point> coords) {
        Collections.sort(coords, new Comparator<Point>() {
            @Override
            public int compare(Point c2, Point c1) {
                return  c2.y - c1.y;
            }
        });
        return coords;
    }
    public static ArrayList<Point> sortHorizontal(ArrayList<Point> coords) {
        Collections.sort(coords, new Comparator<Point>() {
            @Override
            public int compare(Point c2, Point c1) {
                return  c2.x - c1.x;
            }
        });
        return coords;
    }
    
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}
