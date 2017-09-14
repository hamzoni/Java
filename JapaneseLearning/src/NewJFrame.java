
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
    }
    
    private Thread t1;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        button_play = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 140)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("a");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        button_play.setText("Start");
        button_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_playActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_play)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_play)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean firstTime = true;
    private void button_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_playActionPerformed
        if (button_play.isSelected()) {
            try {
                button_play.setText("Stop");
                if (firstTime) {
                    firstTime = false;
                    t1.start();
                } else {
                    
                }
            } catch (Exception ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                button_play.setText("Start");
                t1.wait();
            } catch (Exception ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_playActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);
        frame.init();
    }
    int i = 0;
    private void init() {
        t1 = new Thread(new Runnable() {
            String[] chars = {
                "a", "i", "u", "e", "o", "ka", "ki", "ku", "ke", "ko",
                "sa", "shi", "su", "se", "so", "ta", "chi", "tsu", "te", "to",
                "na", "ni", "nu", "ne", "no", "ha", "hi", "fu", "he", "ho",
                "ma", "mi", "mu", "me", "mo", "ya", "yu", "yo",
                "ra", "ri", "ru", "re", "ro", "wa", "o(wo)"
            };
            @Override
            public void run() {
                while (true) {
                    try {
                        int rand = (int) Math.floor(Math.random() * chars.length);
                        jLabel1.setText(chars[rand]);
                        System.out.println(i++);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println("Stopped");
                        break;
                    }
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton button_play;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
