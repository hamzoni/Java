
package GUI;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UICanvas extends javax.swing.JFrame {

    public UICanvas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvasContainer = new javax.swing.JScrollPane();
        x = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        input_start_x = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        input_end_x = new javax.swing.JTextField();
        button_drawGraph = new javax.swing.JButton();
        button_saveImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        x.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        x.setText("x^3");
        x.setMinimumSize(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("From");

        input_start_x.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        input_start_x.setText("-2");
        input_start_x.setMinimumSize(null);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("F(x)  =");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("To");

        input_end_x.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        input_end_x.setText("1");
        input_end_x.setMinimumSize(null);

        button_drawGraph.setText("Draw Graph");
        button_drawGraph.setMaximumSize(new java.awt.Dimension(97, 30));
        button_drawGraph.setMinimumSize(null);

        button_saveImage.setText("Print");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvasContainer)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(input_start_x, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(input_end_x, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_drawGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_saveImage)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(input_start_x, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(input_end_x, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_drawGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_saveImage)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(canvasContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public JTextField getInput_expression() {
        return x;
    }

    public JScrollPane getCanvasContainer() {
        return canvasContainer;
    }

    public JTextField getInput_end_x() {
        return input_end_x;
    }

    public JTextField getInput_start_x() {
        return input_start_x;
    }

    public JButton getButton_drawGraph() {
        return button_drawGraph;
    }

    public JButton getButton_saveImage() {
        return button_saveImage;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_drawGraph;
    private javax.swing.JButton button_saveImage;
    private javax.swing.JScrollPane canvasContainer;
    private javax.swing.JTextField input_end_x;
    private javax.swing.JTextField input_start_x;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField x;
    // End of variables declaration//GEN-END:variables
}
