package Drawer;

import Entities.Point;
import GUI.Canvas;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

public class Drawer {

    public static int SPACING = 90;
    public static final int SCALE = 5;

    private Canvas cvs;
    private Point centroit;

    public Drawer(Canvas cvs) {
        this.cvs = cvs;
    }

    public void drawAxis(Graphics2D g) {
        int cw = cvs.getWidth();
        int ch = cvs.getHeight();

        g.setColor(Color.black);
        g.drawLine(0, ch / 2, cw, ch / 2);
        g.drawLine(cw / 2, 0, cw / 2, ch);
        
        // Axis label
        drawText(g, "x", new Point(cw - 20, ch / 2 - 10));
        drawText(g, "y", new Point(cw / 2 + 10, 20));

        centroit = new Point(cw / 2, ch / 2);

        drawCentroit(g);
        drawCartesianTicks(g);
    }

    private void drawCentroit(Graphics2D g) {
        int r = 8;
        g.fillOval(centroit.getX() - r / 2, centroit.getY() - r / 2, r, r);
        g.drawOval(centroit.getX() - r / 2, centroit.getY() - r / 2, r, r);
    }

    private void drawLabel(Graphics2D g, String txt, Point p) {
        g.setFont(new Font("Purisa", Font.PLAIN, 13));
        g.drawString(txt, p.getX(), p.getY());
    }

    private void drawPoint(Graphics2D g, Point p) {
        int r = 6;
        g.setColor(Color.BLUE);
        g.fillOval(p.getX() - r / 2, p.getY() - r / 2, r, r);
        g.drawOval(p.getX() - r / 2, p.getY() - r / 2, r, r);
    }

    private void drawCartesianTicks(Graphics2D g) {
        int tickw = 2;
        int scopeTracker = 0;
        g.setColor(Color.red);

        // Draw vertical up
        while (scopeTracker < cvs.getHeight() / 2 - SPACING) {
            scopeTracker += SPACING;
            g.drawLine(
                    centroit.getX() - tickw,
                    centroit.getY() - scopeTracker,
                    centroit.getX() + tickw,
                    centroit.getY() - scopeTracker
            );
            Point lbp = new Point(centroit.getX() - 20, centroit.getY() - scopeTracker);
            drawLabel(g, "" + (scopeTracker / SPACING), lbp);
        }

        // Draw vertical down
        scopeTracker = 0;
        while (scopeTracker < cvs.getHeight() / 2 - SPACING) {
            scopeTracker += SPACING;
            g.drawLine(
                    centroit.getX() - tickw,
                    centroit.getY() + scopeTracker,
                    centroit.getX() + tickw,
                    centroit.getY() + scopeTracker
            );
            Point lbp = new Point(centroit.getX() - 20, centroit.getY() + scopeTracker);
            drawLabel(g, "-" + (scopeTracker / SPACING), lbp);
        }

        // Draw horizontal right
        scopeTracker = 0;
        while (scopeTracker < cvs.getWidth() / 2 - SPACING) {
            scopeTracker += SPACING;
            g.drawLine(
                    centroit.getX() + scopeTracker,
                    centroit.getY() + tickw,
                    centroit.getX() + scopeTracker,
                    centroit.getY() - tickw
            );
            Point lbp = new Point(centroit.getX() + scopeTracker, centroit.getY() + 20);
            drawLabel(g, (scopeTracker / SPACING) + "", lbp);
        }

        // Draw horizontal left
        scopeTracker = 0;
        while (scopeTracker < cvs.getWidth() / 2 - SPACING) {
            scopeTracker += SPACING;
            g.drawLine(
                    centroit.getX() - scopeTracker,
                    centroit.getY() + tickw,
                    centroit.getX() - scopeTracker,
                    centroit.getY() - tickw
            );
            Point lbp = new Point(centroit.getX() - scopeTracker, centroit.getY() + 20);
            drawLabel(g, "-" + (scopeTracker / SPACING), lbp);
        }

    }

    public void drawGraph(Graphics2D g2d, ArrayList<Point> graphPoints) {
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            Stroke dashed = new BasicStroke(1);
            g2d.setStroke(dashed);
            g2d.setColor(Color.blue);
            
            Point p = graphPoints.get(i);
            p.setX(p.getX() + centroit.getX());
            p.setY(centroit.getY() - p.getY());

            Point np = graphPoints.get(i + 1);
            np = new Point(np.getX() + centroit.getX(), centroit.getY() - np.getY());

            // Draw actual graph line (connecting dots)
            g2d.drawLine(p.getX(), p.getY(), np.getX(), np.getY());
            
            // Draw dots and the dashed
            if (i % Drawer.SCALE == 0) {
                drawPoint(g2d, p);
                drawDashed(g2d, p);
            }
            if (i == graphPoints.size() - 2) {
                drawPoint(g2d, np);
                drawDashed(g2d, np);
            }
        }
    }

    private void drawDashed(Graphics2D g2d, Point p) {
        g2d.setColor(new Color(196, 196, 196));
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(p.getX(), p.getY(), p.getX(), centroit.getY());
        g2d.drawLine(p.getX(), p.getY(), centroit.getX(), p.getY());
    }

    public void drawText(Graphics2D g2d, String s, Point p) {
        if (s == null || p == null) return;
        
        g2d.setFont(new Font("Serif", Font.BOLD , 20));
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawString(s, p.getX(), p.getY());
    }
}
