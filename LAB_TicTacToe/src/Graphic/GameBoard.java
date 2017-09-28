
package Graphic;

import Controller.GameData;
import Controller.Rule;
import Entity.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
    
    private GameData gd;
    private int width;
    private int height;
    
    private Graphics g;
    
    public GameBoard(GameData data) {
        this.gd = data;
        width = data.getCell() * data.getCols();
        height = data.getCell() * data.getRows();
        this.setSize(new Dimension(width, height));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
        drawCells(g);
        drawPlayers(g);
        drawWinner(g);
    }
    
    private void drawWinner(Graphics g) {
        Rule r = gd.rule;
        if (r == null) return;
        if (r.getGameStatus() == Rule.WIN) {
            ArrayList<Point> path = r.getWinPath();
            g.setColor(Color.red);
            Point p1 = path.get(0);
            Point p2 = path.get(path.size() - 1);
            int t = gd.getCell(); // Scale coordinate
            
            switch (r.getWinType()) {
                case Rule.HORIZONTAL:
                    g.drawLine(p1.x * t, p1.y * t + t / 2, (p2.x + 1) * t, p2.y * t + t / 2);
                    break;
                case Rule.VERTICAL:
                    g.drawLine(p1.x * t + t / 2, p1.y * t, p2.x * t + t / 2, (p2.y + 1) * t);
                    break;
                case Rule.DIALEFT:
                    g.drawLine(p1.x * t, p1.y * t, (p2.x + 1) * t, (p2.y + 1) * t);
                    break;
                case Rule.DIARIGHT:
                    g.drawLine((p1.x + 1) * t, p1.y * t, p2.x * t, (p2.y + 1) * t);
                    break;
            }
        }
        
    }
    
    private void drawPlayers(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
        g.setColor(Color.BLUE);
        int fh = g.getFontMetrics().getHeight();
        int fw = g.getFontMetrics().stringWidth("x");
        int ct = gd.getCell() / 2;
        for (int i = 0; i < gd.getCols(); i++) {
            for (int j = 0; j < gd.getRows(); j++) {
                if (gd.getBoard()[i][j] == GameData.TURNX) {;
                    g.drawString("x", i * gd.getCell() + fw - 1, j * gd.getCell() + fh - 3);
                }
                if (gd.getBoard()[i][j] ==  GameData.TURNO) {
                    g.drawString("o", i * gd.getCell() + fw - 1, (j + 1) * gd.getCell() - 8);
                }
            }
        }
    }
    
    private void drawCells(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i <= gd.getCols(); i++) {
            g.drawLine(i * gd.getCell(), 0, i * gd.getCell(), height);
        }
        
        for (int i = 0; i <= gd.getRows(); i++) {
            g.drawLine(0, i * gd.getCell(), width, i * gd.getCell());
        }
    }
}
