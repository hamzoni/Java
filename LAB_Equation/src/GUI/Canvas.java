package GUI;

import Drawer.Drawer;
import Entities.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {

    private Drawer drawer;
    private ArrayList<Point> graphPoints;
    private String expression;

    public Canvas() {
        initComponents();
        drawer = new Drawer(this);
        graphPoints = new ArrayList<Point>();

    }
    private BufferedImage image;
    @Override
    public void paintComponent(Graphics g) {
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        
        g2d.setBackground(Color.yellow);
        drawer.drawAxis(g2d);
        drawer.drawGraph(g2d, graphPoints);
        drawer.drawText(g2d, expression, new Point(10, 30));
        
        Graphics2D g2m = (Graphics2D) g;
        
        super.paintComponent(g);
        g2m.drawImage(image, 0, 0, this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void saveImage() throws IOException {
        try {
            ImageIO.write(image, "png", new File("output.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGraphPoints(ArrayList<Point> graphPoints) {
        this.graphPoints = graphPoints;
        repaint();
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
