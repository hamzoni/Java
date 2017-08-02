
package Compute;

import Entities.Caro;
import Gameplay.GamePlay;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Frame extends JFrame {
    public ArrayList<JPanel> panels;
    public FrameController frame_c;
    public GamePlay gpl;
    public Frame(GamePlay gpl) {
        this.gpl = gpl;
        initComponents();
        frame_c = new FrameController(this);
        new setDragging();
        panels = new ArrayList<JPanel>();
        /* 0 */
        panels.add(menu);
        /* 1 */
        panels.add(pve);
        /* 2 */
        panels.add(pvp);
        /* 3 */
        panels.add(credit);
        /* 4 */
        panels.add(option);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame_c.disconnect_server();
            }
        });
        
        frame_c.styling_table();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choose_side = new javax.swing.ButtonGroup();
        choose_side2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        close_frame = new javax.swing.JButton();
        minimize_frame = new javax.swing.JButton();
        jpanel_container = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        join_server2 = new javax.swing.JButton();
        create_server3 = new javax.swing.JButton();
        backPvP3 = new javax.swing.JButton();
        backPvP4 = new javax.swing.JButton();
        pvp = new javax.swing.JPanel();
        pvp_main = new javax.swing.JPanel();
        create_server = new javax.swing.JButton();
        join_server = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pve_x1 = new javax.swing.JRadioButton();
        pve_o1 = new javax.swing.JRadioButton();
        backPvP = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        error_usn = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        username1 = new javax.swing.JTextField();
        pvp_server = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        view_serverIP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        connect_to_player = new javax.swing.JButton();
        exitServer = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        username_v = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        v_serverPort = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        serverList = new javax.swing.JTable();
        pvp_sv_list = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sv_list = new javax.swing.JTable();
        request_join_server = new javax.swing.JButton();
        exitServer1 = new javax.swing.JButton();
        refresh_svList = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        selectedServer = new javax.swing.JTextField();
        pve = new javax.swing.JPanel();
        pve_x = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        pve_o = new javax.swing.JRadioButton();
        hard_AI = new javax.swing.JButton();
        normal_AI = new javax.swing.JButton();
        back = new javax.swing.JButton();
        easy_AI = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        credit = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        backPvP1 = new javax.swing.JButton();
        option = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        board_size = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        cell_size = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(49, 52, 67));
        setMaximumSize(new java.awt.Dimension(400, 590));
        setMinimumSize(new java.awt.Dimension(400, 590));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 590));

        jPanel2.setBackground(new java.awt.Color(49, 52, 67));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(400, 30));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 30));
        jPanel2.setRequestFocusEnabled(false);

        close_frame.setBackground(new java.awt.Color(49, 52, 67));
        close_frame.setForeground(new java.awt.Color(255, 255, 153));
        close_frame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/close.png"))); // NOI18N
        close_frame.setBorder(null);
        close_frame.setBorderPainted(false);
        close_frame.setFocusPainted(false);
        close_frame.setFocusable(false);
        close_frame.setOpaque(false);
        close_frame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_frameActionPerformed(evt);
            }
        });

        minimize_frame.setBackground(new java.awt.Color(49, 52, 67));
        minimize_frame.setForeground(new java.awt.Color(255, 255, 153));
        minimize_frame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/minimize.png"))); // NOI18N
        minimize_frame.setBorder(null);
        minimize_frame.setBorderPainted(false);
        minimize_frame.setFocusPainted(false);
        minimize_frame.setFocusable(false);
        minimize_frame.setOpaque(false);
        minimize_frame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimize_frameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 334, Short.MAX_VALUE)
                .addComponent(minimize_frame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close_frame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_frame, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(minimize_frame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpanel_container.setBackground(new java.awt.Color(49, 52, 67));
        jpanel_container.setMaximumSize(new java.awt.Dimension(400, 560));
        jpanel_container.setMinimumSize(new java.awt.Dimension(400, 560));
        jpanel_container.setPreferredSize(new java.awt.Dimension(400, 560));
        jpanel_container.setLayout(new java.awt.CardLayout());

        menu.setBackground(new java.awt.Color(49, 52, 67));
        menu.setMaximumSize(new java.awt.Dimension(400, 560));
        menu.setMinimumSize(new java.awt.Dimension(400, 560));
        menu.setPreferredSize(new java.awt.Dimension(400, 560));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon.png"))); // NOI18N
        jLabel1.setToolTipText("");

        join_server2.setBackground(new java.awt.Color(70, 79, 113));
        join_server2.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        join_server2.setForeground(new java.awt.Color(138, 236, 236));
        join_server2.setText("PvE");
        join_server2.setBorderPainted(false);
        join_server2.setFocusPainted(false);
        join_server2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                join_server2ActionPerformed(evt);
            }
        });

        create_server3.setBackground(new java.awt.Color(70, 79, 113));
        create_server3.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        create_server3.setForeground(new java.awt.Color(138, 236, 236));
        create_server3.setText("PvP");
        create_server3.setBorderPainted(false);
        create_server3.setFocusPainted(false);
        create_server3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_server3ActionPerformed(evt);
            }
        });

        backPvP3.setBackground(new java.awt.Color(70, 79, 113));
        backPvP3.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        backPvP3.setForeground(new java.awt.Color(138, 236, 236));
        backPvP3.setText("Option");
        backPvP3.setBorderPainted(false);
        backPvP3.setFocusPainted(false);
        backPvP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPvP3ActionPerformed(evt);
            }
        });

        backPvP4.setBackground(new java.awt.Color(70, 79, 113));
        backPvP4.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        backPvP4.setForeground(new java.awt.Color(138, 236, 236));
        backPvP4.setText("Credit");
        backPvP4.setBorderPainted(false);
        backPvP4.setFocusPainted(false);
        backPvP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPvP4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backPvP4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(create_server3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backPvP3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(join_server2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(create_server3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(join_server2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backPvP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backPvP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jpanel_container.add(menu, "card5");

        pvp.setBackground(new java.awt.Color(49, 52, 67));
        pvp.setMaximumSize(new java.awt.Dimension(400, 560));
        pvp.setMinimumSize(new java.awt.Dimension(400, 560));
        pvp.setPreferredSize(new java.awt.Dimension(400, 560));
        pvp.setLayout(new java.awt.CardLayout());

        pvp_main.setBackground(new java.awt.Color(49, 52, 67));
        pvp_main.setMaximumSize(new java.awt.Dimension(400, 560));
        pvp_main.setMinimumSize(new java.awt.Dimension(400, 560));
        pvp_main.setPreferredSize(new java.awt.Dimension(400, 560));

        create_server.setBackground(new java.awt.Color(70, 79, 113));
        create_server.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        create_server.setForeground(new java.awt.Color(138, 236, 236));
        create_server.setText("Create server");
        create_server.setBorderPainted(false);
        create_server.setFocusPainted(false);
        create_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_serverActionPerformed(evt);
            }
        });

        join_server.setBackground(new java.awt.Color(70, 79, 113));
        join_server.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        join_server.setForeground(new java.awt.Color(138, 236, 236));
        join_server.setText("Join a server");
        join_server.setBorderPainted(false);
        join_server.setFocusPainted(false);
        join_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                join_serverActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(235, 206, 89));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PvP");

        jLabel8.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(235, 206, 89));
        jLabel8.setText("Choose turn");
        jLabel8.setToolTipText("");

        pve_x1.setBackground(new java.awt.Color(49, 52, 67));
        choose_side.add(pve_x1);
        pve_x1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pve_x1.setForeground(new java.awt.Color(235, 206, 89));
        pve_x1.setSelected(true);
        pve_x1.setText("X");
        pve_x1.setToolTipText("");
        pve_x1.setFocusPainted(false);
        pve_x1.setOpaque(false);
        pve_x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pve_x1ActionPerformed(evt);
            }
        });

        pve_o1.setBackground(new java.awt.Color(49, 52, 67));
        choose_side.add(pve_o1);
        pve_o1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pve_o1.setForeground(new java.awt.Color(235, 206, 89));
        pve_o1.setText("O");
        pve_o1.setToolTipText("");
        pve_o1.setFocusPainted(false);
        pve_o1.setOpaque(false);
        pve_o1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pve_o1ActionPerformed(evt);
            }
        });

        backPvP.setBackground(new java.awt.Color(70, 79, 113));
        backPvP.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        backPvP.setForeground(new java.awt.Color(138, 236, 236));
        backPvP.setText("Back");
        backPvP.setBorderPainted(false);
        backPvP.setFocusPainted(false);
        backPvP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPvPActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 102));
        username.setText("Username");
        username.setBorder(null);
        username.setOpaque(false);

        error_usn.setForeground(new java.awt.Color(255, 0, 0));

        username1.setEditable(false);
        username1.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(235, 206, 89));
        username1.setText("Username");
        username1.setBorder(null);
        username1.setFocusable(false);
        username1.setOpaque(false);

        javax.swing.GroupLayout pvp_mainLayout = new javax.swing.GroupLayout(pvp_main);
        pvp_main.setLayout(pvp_mainLayout);
        pvp_mainLayout.setHorizontalGroup(
            pvp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pvp_mainLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(pvp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pvp_mainLayout.createSequentialGroup()
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE))
                    .addGroup(pvp_mainLayout.createSequentialGroup()
                        .addGroup(pvp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pvp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(join_server, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backPvP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(create_server, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pvp_mainLayout.createSequentialGroup()
                                .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(error_usn)
                            .addGroup(pvp_mainLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pve_x1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pve_o1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pvp_mainLayout.setVerticalGroup(
            pvp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pvp_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pvp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pve_x1)
                    .addComponent(pve_o1))
                .addGap(18, 18, 18)
                .addGroup(pvp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(create_server, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(join_server, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backPvP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(error_usn)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pvp.add(pvp_main, "card6");

        pvp_server.setBackground(new java.awt.Color(49, 52, 67));
        pvp_server.setMaximumSize(new java.awt.Dimension(400, 560));
        pvp_server.setMinimumSize(new java.awt.Dimension(400, 560));
        pvp_server.setPreferredSize(new java.awt.Dimension(400, 560));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(235, 206, 89));
        jLabel5.setText("Turn");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(235, 206, 89));
        jLabel6.setText("X");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(235, 206, 89));
        jLabel9.setText("Server IP:");

        view_serverIP.setEditable(false);
        view_serverIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        view_serverIP.setForeground(new java.awt.Color(255, 255, 102));
        view_serverIP.setBorder(null);
        view_serverIP.setMinimumSize(new java.awt.Dimension(66, 25));
        view_serverIP.setOpaque(false);
        view_serverIP.setPreferredSize(new java.awt.Dimension(66, 25));
        view_serverIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_serverIPActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trajan Pro", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(235, 206, 89));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("PLAYERS LIST");
        jLabel12.setToolTipText("");

        connect_to_player.setBackground(new java.awt.Color(70, 79, 113));
        connect_to_player.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        connect_to_player.setForeground(new java.awt.Color(132, 228, 228));
        connect_to_player.setText("Connect");
        connect_to_player.setBorderPainted(false);
        connect_to_player.setFocusPainted(false);
        connect_to_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_to_playerActionPerformed(evt);
            }
        });

        exitServer.setBackground(new java.awt.Color(70, 79, 113));
        exitServer.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        exitServer.setForeground(new java.awt.Color(132, 228, 228));
        exitServer.setText("Back");
        exitServer.setBorderPainted(false);
        exitServer.setFocusPainted(false);
        exitServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitServerActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(235, 206, 89));
        jLabel14.setText("Username:");

        username_v.setEditable(false);
        username_v.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username_v.setForeground(new java.awt.Color(255, 255, 102));
        username_v.setBorder(null);
        username_v.setMinimumSize(new java.awt.Dimension(66, 25));
        username_v.setOpaque(false);
        username_v.setPreferredSize(new java.awt.Dimension(66, 25));

        v_serverPort.setEditable(false);
        v_serverPort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        v_serverPort.setForeground(new java.awt.Color(255, 255, 102));
        v_serverPort.setText("9999");
        v_serverPort.setBorder(null);
        v_serverPort.setMinimumSize(new java.awt.Dimension(36, 25));
        v_serverPort.setOpaque(false);
        v_serverPort.setPreferredSize(new java.awt.Dimension(36, 25));

        jSeparator3.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(235, 206, 89));
        jLabel16.setText("Current selected player");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 102));
        jTextField1.setBorder(null);
        jTextField1.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextField1.setOpaque(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(6, 25));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(235, 206, 89));
        jLabel25.setText("Port");

        jScrollPane1.setBackground(new java.awt.Color(49, 52, 67));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        serverList.setAutoCreateRowSorter(true);
        serverList.setBackground(new java.awt.Color(49, 52, 67));
        serverList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        serverList.setForeground(new java.awt.Color(235, 206, 89));
        serverList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player ID", "Player Name", "Time Join"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        serverList.setFocusable(false);
        serverList.setGridColor(new java.awt.Color(49, 52, 67));
        serverList.setIntercellSpacing(new java.awt.Dimension(3, 3));
        serverList.setRowHeight(25);
        serverList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serverListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(serverList);
        if (serverList.getColumnModel().getColumnCount() > 0) {
            serverList.getColumnModel().getColumn(0).setResizable(false);
            serverList.getColumnModel().getColumn(1).setResizable(false);
            serverList.getColumnModel().getColumn(1).setPreferredWidth(200);
            serverList.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout pvp_serverLayout = new javax.swing.GroupLayout(pvp_server);
        pvp_server.setLayout(pvp_serverLayout);
        pvp_serverLayout.setHorizontalGroup(
            pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pvp_serverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pvp_serverLayout.createSequentialGroup()
                        .addComponent(connect_to_player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitServer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pvp_serverLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pvp_serverLayout.createSequentialGroup()
                        .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_v, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(view_serverIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pvp_serverLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addGroup(pvp_serverLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(v_serverPort, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pvp_serverLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pvp_serverLayout.setVerticalGroup(
            pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pvp_serverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pvp_serverLayout.createSequentialGroup()
                        .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(view_serverIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(v_serverPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pvp_serverLayout.createSequentialGroup()
                        .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(34, 34, 34)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pvp_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connect_to_player, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitServer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pvp.add(pvp_server, "card3");

        pvp_sv_list.setBackground(new java.awt.Color(49, 52, 67));

        jLabel18.setFont(new java.awt.Font("Trajan Pro", 0, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(235, 206, 89));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("SERVERS LIST");
        jLabel18.setToolTipText("");

        sv_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Server IP", "Time Created"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sv_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sv_listMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sv_list);
        if (sv_list.getColumnModel().getColumnCount() > 0) {
            sv_list.getColumnModel().getColumn(0).setResizable(false);
            sv_list.getColumnModel().getColumn(0).setPreferredWidth(20);
            sv_list.getColumnModel().getColumn(1).setResizable(false);
            sv_list.getColumnModel().getColumn(1).setPreferredWidth(120);
            sv_list.getColumnModel().getColumn(2).setPreferredWidth(90);
        }

        request_join_server.setBackground(new java.awt.Color(70, 79, 113));
        request_join_server.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        request_join_server.setForeground(new java.awt.Color(132, 228, 228));
        request_join_server.setText("JOIN");
        request_join_server.setBorderPainted(false);
        request_join_server.setFocusPainted(false);
        request_join_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                request_join_serverActionPerformed(evt);
            }
        });

        exitServer1.setBackground(new java.awt.Color(70, 79, 113));
        exitServer1.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        exitServer1.setForeground(new java.awt.Color(132, 228, 228));
        exitServer1.setText("Back");
        exitServer1.setBorderPainted(false);
        exitServer1.setFocusPainted(false);
        exitServer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitServer1ActionPerformed(evt);
            }
        });

        refresh_svList.setBackground(new java.awt.Color(70, 79, 113));
        refresh_svList.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        refresh_svList.setForeground(new java.awt.Color(132, 228, 228));
        refresh_svList.setText("Refresh");
        refresh_svList.setBorderPainted(false);
        refresh_svList.setFocusPainted(false);
        refresh_svList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_svListActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(235, 206, 89));
        jLabel26.setText("Current selected server");

        selectedServer.setEditable(false);
        selectedServer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectedServer.setForeground(new java.awt.Color(255, 255, 102));
        selectedServer.setBorder(null);
        selectedServer.setMinimumSize(new java.awt.Dimension(6, 25));
        selectedServer.setOpaque(false);
        selectedServer.setPreferredSize(new java.awt.Dimension(6, 25));
        selectedServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pvp_sv_listLayout = new javax.swing.GroupLayout(pvp_sv_list);
        pvp_sv_list.setLayout(pvp_sv_listLayout);
        pvp_sv_listLayout.setHorizontalGroup(
            pvp_sv_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pvp_sv_listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectedServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pvp_sv_listLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pvp_sv_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pvp_sv_listLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pvp_sv_listLayout.createSequentialGroup()
                        .addGroup(pvp_sv_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pvp_sv_listLayout.createSequentialGroup()
                                .addComponent(request_join_server, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refresh_svList, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exitServer1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pvp_sv_listLayout.setVerticalGroup(
            pvp_sv_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pvp_sv_listLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pvp_sv_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(selectedServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pvp_sv_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pvp_sv_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exitServer1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refresh_svList, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(request_join_server, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pvp.add(pvp_sv_list, "card7");

        jpanel_container.add(pvp, "card5");

        pve.setBackground(new java.awt.Color(49, 52, 67));
        pve.setAlignmentX(0.0F);
        pve.setAlignmentY(0.0F);
        pve.setMaximumSize(new java.awt.Dimension(400, 560));
        pve.setMinimumSize(new java.awt.Dimension(400, 560));
        pve.setPreferredSize(new java.awt.Dimension(400, 560));

        choose_side2.add(pve_x);
        pve_x.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pve_x.setForeground(new java.awt.Color(235, 206, 89));
        pve_x.setSelected(true);
        pve_x.setText("X");
        pve_x.setFocusPainted(false);
        pve_x.setOpaque(false);
        pve_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pve_xActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(235, 206, 89));
        jLabel4.setText("Choose turn");

        choose_side2.add(pve_o);
        pve_o.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pve_o.setForeground(new java.awt.Color(235, 206, 89));
        pve_o.setText("O");
        pve_o.setFocusPainted(false);
        pve_o.setOpaque(false);
        pve_o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pve_oActionPerformed(evt);
            }
        });

        hard_AI.setBackground(new java.awt.Color(70, 79, 113));
        hard_AI.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        hard_AI.setForeground(new java.awt.Color(138, 236, 236));
        hard_AI.setText("Hard");
        hard_AI.setBorderPainted(false);
        hard_AI.setFocusPainted(false);
        hard_AI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hard_AIActionPerformed(evt);
            }
        });

        normal_AI.setBackground(new java.awt.Color(70, 79, 113));
        normal_AI.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        normal_AI.setForeground(new java.awt.Color(138, 236, 236));
        normal_AI.setText("Normal");
        normal_AI.setBorderPainted(false);
        normal_AI.setFocusPainted(false);
        normal_AI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_AIActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(70, 79, 113));
        back.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(138, 236, 236));
        back.setText("Back");
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        easy_AI.setBackground(new java.awt.Color(70, 79, 113));
        easy_AI.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        easy_AI.setForeground(new java.awt.Color(138, 236, 236));
        easy_AI.setText("Easy");
        easy_AI.setBorderPainted(false);
        easy_AI.setFocusPainted(false);
        easy_AI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easy_AIActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trajan Pro", 0, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(235, 206, 89));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PvE");

        javax.swing.GroupLayout pveLayout = new javax.swing.GroupLayout(pve);
        pve.setLayout(pveLayout);
        pveLayout.setHorizontalGroup(
            pveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pveLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(pveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pveLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pve_x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pve_o))
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(normal_AI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hard_AI, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(easy_AI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        pveLayout.setVerticalGroup(
            pveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pve_x)
                    .addComponent(pve_o))
                .addGap(18, 18, 18)
                .addComponent(hard_AI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(normal_AI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(easy_AI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jpanel_container.add(pve, "card2");

        credit.setBackground(new java.awt.Color(49, 52, 67));
        credit.setMaximumSize(new java.awt.Dimension(400, 560));
        credit.setMinimumSize(new java.awt.Dimension(400, 560));

        jLabel15.setFont(new java.awt.Font("Trajan Pro", 0, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(235, 206, 89));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("CREDIT");

        jSeparator4.setBackground(new java.awt.Color(51, 255, 204));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(132, 228, 228));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Creator");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 253, 104));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TA QUY");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(132, 228, 228));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Instructor");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 253, 104));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Ngo Tung Son");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(132, 228, 228));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Helper (on AI Algorithms)");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 253, 104));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Anh Le");

        jPanel1.setBackground(new java.awt.Color(49, 52, 67));

        backPvP1.setBackground(new java.awt.Color(70, 79, 113));
        backPvP1.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        backPvP1.setForeground(new java.awt.Color(138, 236, 236));
        backPvP1.setText("Back");
        backPvP1.setBorderPainted(false);
        backPvP1.setFocusPainted(false);
        backPvP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPvP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(backPvP1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPvP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout creditLayout = new javax.swing.GroupLayout(credit);
        credit.setLayout(creditLayout);
        creditLayout.setHorizontalGroup(
            creditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(creditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        creditLayout.setVerticalGroup(
            creditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpanel_container.add(credit, "card5");

        option.setBackground(new java.awt.Color(49, 52, 67));
        option.setEnabled(false);
        option.setMaximumSize(new java.awt.Dimension(400, 560));
        option.setMinimumSize(new java.awt.Dimension(400, 560));
        option.setPreferredSize(new java.awt.Dimension(400, 560));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(235, 206, 89));
        jLabel17.setText("Board size");

        board_size.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        board_size.setForeground(new java.awt.Color(255, 255, 102));
        board_size.setBorder(null);
        board_size.setOpaque(false);
        board_size.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                board_sizeFocusLost(evt);
            }
        });
        board_size.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                board_sizeMouseClicked(evt);
            }
        });
        board_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                board_sizeActionPerformed(evt);
            }
        });
        board_size.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                board_sizeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                board_sizeKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(235, 206, 89));
        jLabel20.setText("Cell size");

        jLabel22.setFont(new java.awt.Font("Trajan Pro", 0, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(235, 206, 89));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("OPTION");

        cell_size.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cell_size.setForeground(new java.awt.Color(255, 255, 102));
        cell_size.setBorder(null);
        cell_size.setOpaque(false);
        cell_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell_sizeActionPerformed(evt);
            }
        });
        cell_size.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cell_sizeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cell_sizeKeyTyped(evt);
            }
        });

        back1.setBackground(new java.awt.Color(70, 79, 113));
        back1.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        back1.setForeground(new java.awt.Color(138, 236, 236));
        back1.setText("Back");
        back1.setBorderPainted(false);
        back1.setFocusPainted(false);
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionLayout = new javax.swing.GroupLayout(option);
        option.setLayout(optionLayout);
        optionLayout.setHorizontalGroup(
            optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionLayout.createSequentialGroup()
                .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(optionLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(optionLayout.createSequentialGroup()
                                .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator9)
                                        .addComponent(cell_size, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator5)
                                        .addComponent(board_size, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))))
                            .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        optionLayout.setVerticalGroup(
            optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionLayout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(board_size, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cell_size, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jpanel_container.add(option, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jpanel_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 556, Short.MAX_VALUE)))
        );

        jpanel_container.add(new JPanel());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pve_oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pve_oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pve_oActionPerformed

    private void pve_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pve_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pve_xActionPerformed

    private void pve_x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pve_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pve_x1ActionPerformed

    private void pve_o1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pve_o1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pve_o1ActionPerformed

    private void create_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_serverActionPerformed
        frame_c.createNewServer();
    }//GEN-LAST:event_create_serverActionPerformed
    
    
    
    private void join_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_join_serverActionPerformed
        frame_c.show_pvp_pages(2);
        frame_c.get_server_list();
    }//GEN-LAST:event_join_serverActionPerformed
    
    private void connect_to_playerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_to_playerActionPerformed
        // CONNECT TO CHOSEN PLAYER
        int selected = serverList.getSelectedRow();
        DefaultTableModel mdl_tbl = (DefaultTableModel) serverList.getModel();
        if (selected != -1) {
            int targetID = (int) mdl_tbl.getValueAt(selected, 0);
            if (targetID != -1) gpl.client.match(targetID);
        }
    }//GEN-LAST:event_connect_to_playerActionPerformed
    
    private void exitServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitServerActionPerformed
        frame_c.disconnect_server();
    }//GEN-LAST:event_exitServerActionPerformed
    
    private void serverListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serverListMouseClicked
        frame_c.init_server_list();
    }//GEN-LAST:event_serverListMouseClicked
   
  
    private void backPvPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPvPActionPerformed
        frame_c.show_layer(0);
    }//GEN-LAST:event_backPvPActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void hard_AIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hard_AIActionPerformed
        gpl.create_AI_game(frame_c.getSelectedTurn_BOT(), 7);
    }//GEN-LAST:event_hard_AIActionPerformed

    private void normal_AIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normal_AIActionPerformed
        gpl.create_AI_game(frame_c.getSelectedTurn_BOT(), 5);
    }//GEN-LAST:event_normal_AIActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       frame_c.show_layer(0);
    }//GEN-LAST:event_backActionPerformed

    private void easy_AIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easy_AIActionPerformed
        gpl.create_AI_game(frame_c.getSelectedTurn_BOT(), 3);
    }//GEN-LAST:event_easy_AIActionPerformed

    private void join_server2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_join_server2ActionPerformed
        frame_c.show_layer(1);
    }//GEN-LAST:event_join_server2ActionPerformed

    private void create_server3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_server3ActionPerformed
        frame_c.show_layer(2);
    }//GEN-LAST:event_create_server3ActionPerformed

    private void backPvP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPvP3ActionPerformed
        board_size.setText(Caro.ROWS + "");
        cell_size.setText(Caro.ROWS + "");
        frame_c.show_layer(4);
    }//GEN-LAST:event_backPvP3ActionPerformed

    private void backPvP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPvP4ActionPerformed
        frame_c.show_layer(3);
    }//GEN-LAST:event_backPvP4ActionPerformed

    private void backPvP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPvP1ActionPerformed
        frame_c.show_layer(0);
    }//GEN-LAST:event_backPvP1ActionPerformed

    private void close_frameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_frameActionPerformed
//        dispose();
//        System.exit(0);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_close_frameActionPerformed

    private void minimize_frameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimize_frameActionPerformed
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimize_frameActionPerformed

    private void view_serverIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_serverIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_view_serverIPActionPerformed

    private void board_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_board_sizeActionPerformed
    }//GEN-LAST:event_board_sizeActionPerformed

    private void board_sizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_board_sizeMouseClicked
    }//GEN-LAST:event_board_sizeMouseClicked

    private void board_sizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_board_sizeFocusLost
        
    }//GEN-LAST:event_board_sizeFocusLost

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        frame_c.show_layer(0);
    }//GEN-LAST:event_back1ActionPerformed

    private void board_sizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_board_sizeKeyReleased
        String txt = board_size.getText();
        int size = Caro.COLS;
        if (!txt.equals("")) {
            size = Integer.parseInt(txt);
        }
        Caro.COLS = size;
        Caro.ROWS = size;
    }//GEN-LAST:event_board_sizeKeyReleased

    private void board_sizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_board_sizeKeyTyped
        char c = evt.getKeyChar();
        if ((c >= '0') && (c <= '9') ||
            (c == KeyEvent.VK_BACK_SPACE) ||
            (c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_board_sizeKeyTyped

    private void cell_sizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cell_sizeKeyTyped
        char c = evt.getKeyChar();
        if ((c >= '0') && (c <= '9') ||
            (c == KeyEvent.VK_BACK_SPACE) ||
            (c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_cell_sizeKeyTyped

    private void cell_sizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cell_sizeKeyReleased
        String txt = cell_size.getText();
        int size = Caro.CELLSIZE;
        if (!txt.equals("")) {
            size = Integer.parseInt(txt);
        }
        Caro.CELLSIZE = size;
    }//GEN-LAST:event_cell_sizeKeyReleased

    private void cell_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell_sizeActionPerformed

    }//GEN-LAST:event_cell_sizeActionPerformed

    private void request_join_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_request_join_serverActionPerformed
        frame_c.requestJoinServer();
    }//GEN-LAST:event_request_join_serverActionPerformed
    
    private void exitServer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitServer1ActionPerformed
        frame_c.show_pvp_pages(0);
    }//GEN-LAST:event_exitServer1ActionPerformed

    private void refresh_svListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_svListActionPerformed
        frame_c.get_server_list();
    }//GEN-LAST:event_refresh_svListActionPerformed

    private void sv_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sv_listMouseClicked
//        selectedServer
    }//GEN-LAST:event_sv_listMouseClicked

    private void selectedServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedServerActionPerformed
    
    public JLabel getError_usn() {
        return error_usn;
    }
    public JTextField getUsername() {
        return username;
    }
    public JButton getCreate_server() {
        return create_server;
    }
    public JButton getJoin_server() {
        return join_server;
    }
    public JTextField getView_serverIP() {
        return view_serverIP;
    }
    public JTextField getV_serverPort() {
        return v_serverPort;
    }
    public JTextField getUsername_v() {
        return username_v;
    }
    public JLabel getJLabel6() {
        return jLabel6;
    }
    public JRadioButton getPve_x() {
        return pve_x;
    }
    public JRadioButton getPve_x1() {
        return pve_x1;
    }
    public JButton getConnect_to_player() {
        return connect_to_player;
    }
    public JPanel getPvp_main() {
        return pvp_main;
    }
    public JPanel getPvp_server() {
        return pvp_server;
    }
    public JPanel getPvp_sv_list() {
        return pvp_sv_list;
    }
    public JTable getSv_list() {
        return sv_list;
    }
    public JTable getServerList() {
        return serverList;
    }
    public JTextField getJTextField1() {
        return jTextField1;
    }
    public JScrollPane getJScrollPane1() {
        return jScrollPane1;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton back1;
    private javax.swing.JButton backPvP;
    private javax.swing.JButton backPvP1;
    private javax.swing.JButton backPvP3;
    private javax.swing.JButton backPvP4;
    private javax.swing.JTextField board_size;
    private javax.swing.JTextField cell_size;
    private javax.swing.ButtonGroup choose_side;
    private javax.swing.ButtonGroup choose_side2;
    private javax.swing.JButton close_frame;
    private javax.swing.JButton connect_to_player;
    private javax.swing.JButton create_server;
    private javax.swing.JButton create_server3;
    private javax.swing.JPanel credit;
    private javax.swing.JButton easy_AI;
    private javax.swing.JLabel error_usn;
    private javax.swing.JButton exitServer;
    private javax.swing.JButton exitServer1;
    private javax.swing.JButton hard_AI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton join_server;
    private javax.swing.JButton join_server2;
    private javax.swing.JPanel jpanel_container;
    private javax.swing.JPanel menu;
    private javax.swing.JButton minimize_frame;
    private javax.swing.JButton normal_AI;
    private javax.swing.JPanel option;
    private javax.swing.JPanel pve;
    private javax.swing.JRadioButton pve_o;
    private javax.swing.JRadioButton pve_o1;
    private javax.swing.JRadioButton pve_x;
    private javax.swing.JRadioButton pve_x1;
    private javax.swing.JPanel pvp;
    private javax.swing.JPanel pvp_main;
    private javax.swing.JPanel pvp_server;
    private javax.swing.JPanel pvp_sv_list;
    private javax.swing.JButton refresh_svList;
    private javax.swing.JButton request_join_server;
    private javax.swing.JTextField selectedServer;
    private javax.swing.JTable serverList;
    private javax.swing.JTable sv_list;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    private javax.swing.JTextField username_v;
    private javax.swing.JTextField v_serverPort;
    private javax.swing.JTextField view_serverIP;
    // End of variables declaration//GEN-END:variables
    
    class HeaderStyling extends DefaultTableCellRenderer {
        public HeaderStyling() {
            setOpaque(true);
        }
        public Component getTableCellRenderedComponent(JTable myTable, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(myTable, value, selected, focused, row, column);
            setBackground(new Color(0, 0, 0));
            return this;
        }
    }

    class setDragging {
        public setDragging() {
            MouseAdapter ma = new MouseAdapter() {
                int lastX, lastY;
                @Override
                public void mousePressed(MouseEvent e) {
                    lastX = e.getXOnScreen();
                    lastY = e.getYOnScreen();
                }
                @Override
                public void mouseDragged(MouseEvent e) {
                    int x = e.getXOnScreen();
                    int y = e.getYOnScreen();
                    // Move frame by the mouse delta
                    setLocation(getLocationOnScreen().x + x - lastX,
                            getLocationOnScreen().y + y - lastY);
                    lastX = x;
                    lastY = y;
                }
            };
            addMouseListener(ma);
            addMouseMotionListener(ma);
        }
    }
}
