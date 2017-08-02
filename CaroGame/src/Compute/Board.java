
package Compute;

import Gameplay.GamePlay;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Board extends javax.swing.JFrame {
    private GamePlay gpl;
    private String gameID;
    private Thread timeCounter;
    private int playTime;
    public Board(GamePlay gpl, String gameID) {
        this.gpl = gpl;
        this.gameID = gameID;
        this.playTime = 0;
        initComponents();
        board_styling();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                playTime = -1;
                gpl.close_board(gameID);
                e.getWindow().dispose();
            }
        });
        timeCounter = new Thread(new Runnable() {
            @Override
            public void run() {
                while (playTime != -1) {
                    try {
                        playTime++;
                        String timeStr = "";
                        int seconds = (int) playTime % 60 ;
                        int minutes = (int) (playTime / 60) % 60;
                        int hours   = (int) ((playTime / 60) / 60) % 24;
                        timeStr += (hours < 10 ? "0" + hours : hours) + ":";
                        timeStr += (minutes < 10 ? "0" + minutes : minutes) + ":";
                        timeStr += seconds < 10 ? "0" + seconds : seconds;
                        timeDpl.setText(timeStr);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        timeCounter.start();
    }
    public JScrollPane getBoard_panel() {
        return board_panel;
    }
    public void board_styling() {
        board_panel.setBackground(new Color(49,52,67));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel4 = new javax.swing.JPanel();
        index_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        playerName_1 = new javax.swing.JLabel();
        playerName_2 = new javax.swing.JLabel();
        scoring1 = new javax.swing.JLabel();
        scoring2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        player_turn = new javax.swing.JLabel();
        timeDpl = new javax.swing.JLabel();
        board_container = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        notification_text = new javax.swing.JLabel();
        board_panel = new javax.swing.JScrollPane();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 550));
        setSize(new java.awt.Dimension(800, 550));

        jPanel4.setBackground(new java.awt.Color(49, 52, 67));

        index_panel.setOpaque(false);
        index_panel.setPreferredSize(new java.awt.Dimension(600, 60));

        jPanel2.setOpaque(false);

        playerName_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        playerName_1.setForeground(new java.awt.Color(132, 228, 228));
        playerName_1.setText("Player #1");

        playerName_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        playerName_2.setForeground(new java.awt.Color(132, 228, 228));
        playerName_2.setText("Player #2");

        scoring1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoring1.setForeground(new java.awt.Color(255, 255, 153));
        scoring1.setText("0/0/0");

        scoring2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoring2.setForeground(new java.awt.Color(255, 255, 153));
        scoring2.setText("0/0/0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(playerName_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoring2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(playerName_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoring1)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerName_1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(scoring1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerName_2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(scoring2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setOpaque(false);

        player_turn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player_turn.setForeground(new java.awt.Color(132, 228, 228));
        player_turn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player_turn.setText("Player #1 - X turns");
        player_turn.setAlignmentX(10.0F);

        timeDpl.setForeground(new java.awt.Color(132, 228, 228));
        timeDpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeDpl.setText("12:59");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(player_turn, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeDpl, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player_turn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(timeDpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout index_panelLayout = new javax.swing.GroupLayout(index_panel);
        index_panel.setLayout(index_panelLayout);
        index_panelLayout.setHorizontalGroup(
            index_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(index_panelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        index_panelLayout.setVerticalGroup(
            index_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        board_container.setBackground(new java.awt.Color(49, 52, 67));
        board_container.setToolTipText("");
        board_container.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(70, 79, 113));

        notification_text.setBackground(new java.awt.Color(70, 79, 113));
        notification_text.setForeground(new java.awt.Color(132, 228, 228));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notification_text, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(notification_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        board_panel.setBackground(new java.awt.Color(49, 52, 67));
        board_panel.setBorder(null);
        board_panel.setMinimumSize(new java.awt.Dimension(785, 3));
        board_panel.setOpaque(false);

        javax.swing.GroupLayout board_containerLayout = new javax.swing.GroupLayout(board_container);
        board_container.setLayout(board_containerLayout);
        board_containerLayout.setHorizontalGroup(
            board_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(board_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        board_containerLayout.setVerticalGroup(
            board_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(board_containerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(board_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(index_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addComponent(board_container, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(index_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(board_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public JLabel getNotificationText() {
        return notification_text;
    }
    public JPanel getBoardContainer() {
        return board_container;
    }
    public JPanel getIndex_panel() {
        return index_panel;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JPanel getjPanel5() {
        return board_container;
    }

    public JLabel getPlayerName_1() {
        return playerName_1;
    }

    public JLabel getPlayerName_2() {
        return playerName_2;
    }

    public JLabel getPlayer_turn() {
        return player_turn;
    }

    public JLabel getScoring1() {
        return scoring1;
    }

    public JLabel getScoring2() {
        return scoring2;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel board_container;
    private javax.swing.JScrollPane board_panel;
    private javax.swing.JPanel index_panel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel notification_text;
    private javax.swing.JLabel playerName_1;
    private javax.swing.JLabel playerName_2;
    private javax.swing.JLabel player_turn;
    private javax.swing.JLabel scoring1;
    private javax.swing.JLabel scoring2;
    private javax.swing.JLabel timeDpl;
    // End of variables declaration//GEN-END:variables
}
