package Compute;

import Entities.Coordinate;
import Entities.Caro;
import Entities.Player;
import Middleware.Case;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Graphic extends JPanel {

    public Caro map;

    public Color clr_panel = new Color(49,52,67); // DARK BLUE
    public Color clr_grid = new Color(132,228,228); // CYAN
    public Color clr_itemX = new Color(235,206,89); // DARK YELLOW
    public Color clr_itemO = new Color(255,255,153); // LIGHT YELLOW
    
    public Graphic() {
        this.setBackground(clr_panel);
    }
    
    private void drawGrid(Graphics g) {
        g.setColor(clr_grid); 
        int k;
        int width = map.cols * map.cellsize;
        int height = map.rows * map.cellsize;

        int htOfRow = height / (map.rows);
        for (k = 0; k <= map.rows; k++) {
            g.drawLine(0, k * htOfRow, width, k * htOfRow);
        }

        int wdOfRow = width / (map.cols);
        for (k = 0; k <= map.cols; k++) {
            g.drawLine(k * wdOfRow, 0, k * wdOfRow, height);
        }
    }
    private void drawPlayer(Graphics g) {
        g.setFont(new Font("Sans Serif", Font.BOLD, 15));
        
        for (int i = 0; i < map.cols; i++) {
            for (int j = 0; j < map.rows; j++) {

                if (map.getMap()[i][j] != 0) {
                    for (Player player : map.players) {
                        if (player.getId() == map.getMap()[i][j]) {
                            g.setColor(clr_itemO);
                            if (player.getId() == 1) {} else {}
                            String node = player.getName();
                            int dY = map.cellsize * (j + 1) - map.cellsize / 2 + 6;
                            int dX =map.cellsize * (i) + map.cellsize / 2 - 6;
                            g.drawString(node, dX, dY); 
                            break;
                        }
                    }
                }
            }
        }
    }
    public void drawResult(Graphics g) {
        Case match = new Case(map);
        if (match.getStatus() == 1) {
            ArrayList<Coordinate> winLine = match.getWinLine();
            Coordinate start = new Coordinate(winLine.get(0).x * map.cellsize, winLine.get(0).y * map.cellsize);
            Coordinate end = new Coordinate(winLine.get(winLine.size() - 1).x * map.cellsize, winLine.get(winLine.size() - 1).y * map.cellsize);
            // draw cross win
            g.setColor(Color.red);
            switch (match.getWinType()) {
                case 1: // vertical cross
                    g.drawLine(start.x + map.cellsize / 2, start.y, end.x + map.cellsize / 2, end.y + map.cellsize);
                    break;
                case 2: // horizontal cross
                    g.drawLine(start.x, start.y + map.cellsize / 2, end.x  + map.cellsize, start.y + map.cellsize / 2);
                    break;
                case 3: // diagonal down cross
                    g.drawLine(start.x, start.y, end.x + map.cellsize, end.y + map.cellsize);
                    break;
                case 4: // diagonal up cross
                    g.drawLine(end.x, end.y + map.cellsize, start.x + map.cellsize, start.y);
                    break;
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawPlayer(g);
        drawResult(g);
    }
}
