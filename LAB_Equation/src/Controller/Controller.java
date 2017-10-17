package Controller;

import Drawer.Drawer;
import Entities.Point;
import GUI.Canvas;
import GUI.UICanvas;
import Math.ExpressionSolver;
import Math.ExpressionValidator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private UICanvas frame;
    private Canvas canvas;

    private ArrayList<Point> graphPoints;

    public static void main(String[] args) {
        new Controller().init();
    }
    
    private void test() {
        String exp = "--x^2";
        double x = 1;
        double y = ExpressionSolver.calc(exp, x);
        System.out.println(y);
    }
    
    public void init() {
        frame = new UICanvas();
        canvas = new Canvas();

        frame.setLocationRelativeTo(null);
        frame.getCanvasContainer().setViewportView(canvas);
        frame.getCanvasContainer().setVisible(true);
        frame.setVisible(true);
        frame.getInput_expression().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                processCalc();
            }
        });
        frame.getInput_start_x().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                processCalc();
            }
        });
        frame.getInput_end_x().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                processCalc();
            }
        });
        frame.getButton_drawGraph().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processCalc();
            }
        });
        frame.getButton_saveImage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    canvas.saveImage();
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    public void processCalc() {
        String expression = frame.getInput_expression().getText();
        if (!ExpressionValidator.isValid(expression)) return;
        canvas.setExpression(expression);
        int xtracker = 0;
        String startXr = frame.getInput_start_x().getText();
        String endXr = frame.getInput_end_x().getText();
        if (startXr.length() > 0 && endXr.length() > 0) {
            try {
                double startX = Double.parseDouble(startXr);
                double endX = Double.parseDouble(endXr);
                graphPoints = new ArrayList<Point>();

                while (startX <= endX) {

                    for (int i = 0; i < Drawer.SCALE; i++) {

                        Point p = new Point();

                        double x = startX + (double) i / (double) Drawer.SCALE;
                        double y = ExpressionSolver.calc(expression, x);
                        
                        if (x > endX) break;

                        x = x * (Drawer.SPACING);
                        y = y * (Drawer.SPACING);

                        y = Math.round(y);

                        p.setX((int) x);
                        p.setY((int) y);

                        graphPoints.add(p);
                    }

                    startX++;
                }
                updateSpacing(graphPoints);
                canvas.setGraphPoints(graphPoints);
            } catch (Exception e) {
                return;
            }
        }
    }

    private void updateSpacing(ArrayList<Point> points) {
        // Find highest values point (highest X and Y values)
        int bx, by;
        bx = by = 0;
        
        for (Point p : points) {
            int px = Math.abs(p.getX() / Drawer.SPACING);
            int py = Math.abs(p.getY() / Drawer.SPACING);
            if (px > bx) bx = px;
            if (py > by) by = py;
        }
        
        // Window max size
        int wbx = (canvas.getWidth() / 2) / Drawer.SPACING;
        int wby = (canvas.getHeight() / 2) / Drawer.SPACING;
     
        // Calculate new ratio (Spacing)
        int rby, rbx;
        rbx = (int) (((double) wbx / bx) * Drawer.SPACING);
        rby = (int) (((double) wby / by) * Drawer.SPACING);
        
        // Get smallest spacing: smaller = better
        double oldspc = Drawer.SPACING;
        Drawer.SPACING = rbx < rby ? rbx : rby;
        // Recalculate new points size
        for (Point p : points) {
            int px = (int) (((double) p.getX() / oldspc) * Drawer.SPACING);
            int py = (int) (((double) p.getY() / oldspc) * Drawer.SPACING);
            p.setX(px);
            p.setY(py);
        }
    }

}
