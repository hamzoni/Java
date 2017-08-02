
package Compute;

import static java.awt.image.ImageObserver.WIDTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogRP extends javax.swing.JDialog {
    private Thread abortTimeCounter;
    private Frame frame;
    
    public DialogRP(Frame frame) {
        initComponents();
        this.frame = frame;
        this.pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField_duoRequestFrom1 = new javax.swing.JTextField();
        jButton_abortDuoRequest1 = new javax.swing.JButton();
        jButton_acceptDuoRequest1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel_countDownRequestAbort1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(49, 52, 67));
        jPanel4.setForeground(new java.awt.Color(49, 52, 67));
        jPanel4.setAutoscrolls(true);

        jLabel19.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(132, 228, 228));
        jLabel19.setText("Duo request");

        jLabel21.setForeground(new java.awt.Color(235, 206, 89));
        jLabel21.setText("From");

        jTextField_duoRequestFrom1.setEditable(false);
        jTextField_duoRequestFrom1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_duoRequestFrom1.setForeground(new java.awt.Color(255, 255, 153));
        jTextField_duoRequestFrom1.setText("Someone");
        jTextField_duoRequestFrom1.setBorder(null);
        jTextField_duoRequestFrom1.setOpaque(false);

        jButton_abortDuoRequest1.setBackground(new java.awt.Color(70, 79, 113));
        jButton_abortDuoRequest1.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jButton_abortDuoRequest1.setForeground(new java.awt.Color(132, 228, 228));
        jButton_abortDuoRequest1.setText("Abort");
        jButton_abortDuoRequest1.setBorderPainted(false);
        jButton_abortDuoRequest1.setFocusPainted(false);
        jButton_abortDuoRequest1.setMaximumSize(new java.awt.Dimension(77, 25));
        jButton_abortDuoRequest1.setMinimumSize(new java.awt.Dimension(77, 25));
        jButton_abortDuoRequest1.setPreferredSize(new java.awt.Dimension(77, 25));
        jButton_abortDuoRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_abortDuoRequest1ActionPerformed(evt);
            }
        });

        jButton_acceptDuoRequest1.setBackground(new java.awt.Color(70, 79, 113));
        jButton_acceptDuoRequest1.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jButton_acceptDuoRequest1.setForeground(new java.awt.Color(132, 228, 228));
        jButton_acceptDuoRequest1.setText("Accept");
        jButton_acceptDuoRequest1.setBorderPainted(false);
        jButton_acceptDuoRequest1.setFocusPainted(false);
        jButton_acceptDuoRequest1.setMaximumSize(new java.awt.Dimension(77, 25));
        jButton_acceptDuoRequest1.setMinimumSize(new java.awt.Dimension(77, 25));
        jButton_acceptDuoRequest1.setPreferredSize(new java.awt.Dimension(77, 25));
        jButton_acceptDuoRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_acceptDuoRequest1ActionPerformed(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(235, 206, 89));
        jLabel23.setText("The request will be auto aborted in");

        jLabel_countDownRequestAbort1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_countDownRequestAbort1.setText("20");

        jLabel24.setForeground(new java.awt.Color(235, 206, 89));
        jLabel24.setText("seconds");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6)
                            .addComponent(jTextField_duoRequestFrom1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_countDownRequestAbort1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_acceptDuoRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_abortDuoRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel19)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jTextField_duoRequestFrom1)))
                .addGap(4, 4, 4)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel_countDownRequestAbort1)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_abortDuoRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_acceptDuoRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel19)
                    .addContainerGap(110, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_abortDuoRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_abortDuoRequest1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_abortDuoRequest1ActionPerformed

    private void jButton_acceptDuoRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_acceptDuoRequest1ActionPerformed
        frame.frame_c.accept_duo_request();
        dispose();
    }//GEN-LAST:event_jButton_acceptDuoRequest1ActionPerformed
    
    public void setCountDown(String sourceName) {
        abortTimeCounter = new Thread(new Runnable() {
            @Override
            public void run() {
                int abortCD = 15;
                while(abortCD >= 0) {
                    try {
                        getCountDownTXT().setText(abortCD + "");
                        setTitle("Request from " + sourceName + " (" + abortCD + ")");
                        abortCD--;
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                setVisible(false);
            }
        });
        abortTimeCounter.start();
    }
    
    public JLabel getCountDownTXT() {
        return jLabel_countDownRequestAbort1;
    }

    public JTextField getSenderNameTXT() {
        return jTextField_duoRequestFrom1;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_abortDuoRequest1;
    private javax.swing.JButton jButton_acceptDuoRequest1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel_countDownRequestAbort1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField_duoRequestFrom1;
    // End of variables declaration//GEN-END:variables
}
