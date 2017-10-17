
package GUI;

import Controller.Controller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UICalculator extends javax.swing.JFrame {

    private Controller c;
    public UICalculator(Controller c) {
        initComponents();
        this.c = c;

    }

    public JTextField getInput_result() {
        return input_result;
    }

    public JButton getBtn_0() {
        return btn_0;
    }

    public JButton getBtn_1() {
        return btn_1;
    }

    public JButton getBtn_2() {
        return btn_2;
    }

    public JButton getBtn_3() {
        return btn_3;
    }

    public JButton getBtn_4() {
        return btn_4;
    }

    public JButton getBtn_5() {
        return btn_5;
    }

    public JButton getBtn_6() {
        return btn_6;
    }

    public JButton getBtn_7() {
        return btn_7;
    }

    public JButton getBtn_8() {
        return btn_8;
    }

    public JButton getBtn_9() {
        return btn_9;
    }

    public JButton getBtn_decimal() {
        return btn_decimal;
    }

    public JButton getBtn_divide() {
        return btn_divide;
    }

    public JButton getBtn_fraction() {
        return btn_fraction;
    }

    public JButton getBtn_mc() {
        return btn_mc;
    }

    public JButton getBtn_minus() {
        return btn_minus;
    }

    public JButton getBtn_minusPlus() {
        return btn_minusPlus;
    }

    public JButton getBtn_mm() {
        return btn_mm;
    }

    public JButton getBtn_modulus() {
        return btn_modulus;
    }

    public JButton getBtn_mp() {
        return btn_mp;
    }

    public JButton getBtn_mr() {
        return btn_mr;
    }

    public JButton getBtn_mult() {
        return btn_mult;
    }

    public JButton getBtn_plus() {
        return btn_plus;
    }

    public JButton getBtn_result() {
        return btn_result;
    }

    public JButton getBtn_sqrt() {
        return btn_sqrt;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JTextField getjTextField1() {
        return input_result;
    }

    public JPanel getPanel_btnGroups() {
        return panel_btnGroups;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input_result = new javax.swing.JTextField();
        panel_btnGroups = new javax.swing.JPanel();
        btn_mc = new javax.swing.JButton();
        btn_mr = new javax.swing.JButton();
        btn_mp = new javax.swing.JButton();
        btn_mm = new javax.swing.JButton();
        btn_sqrt = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_divide = new javax.swing.JButton();
        btn_modulus = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_mult = new javax.swing.JButton();
        btn_fraction = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_minus = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_decimal = new javax.swing.JButton();
        btn_minusPlus = new javax.swing.JButton();
        btn_plus = new javax.swing.JButton();
        btn_result = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        input_result.setEditable(false);
        input_result.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        input_result.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        input_result.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panel_btnGroups.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_mc.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_mc.setText("MC");
        btn_mc.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_mc.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_mc.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_mr.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_mr.setText("MR");
        btn_mr.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_mr.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_mr.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_mp.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_mp.setText("M+");
        btn_mp.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_mp.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_mp.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_mm.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_mm.setText("M-");
        btn_mm.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_mm.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_mm.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_sqrt.setText("√");
        btn_sqrt.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_sqrt.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_sqrt.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_7.setText("7");
        btn_7.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_7.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_7.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_8.setText("8");
        btn_8.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_8.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_8.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_9.setText("9");
        btn_9.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_9.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_9.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_divide.setText("/");
        btn_divide.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_divide.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_divide.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_modulus.setText("%");
        btn_modulus.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_modulus.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_modulus.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_4.setText("4");
        btn_4.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_4.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_4.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_5.setText("5");
        btn_5.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_5.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_5.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_6.setText("6");
        btn_6.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_6.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_6.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_mult.setText("x");
        btn_mult.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_mult.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_mult.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_fraction.setText("1/x");
        btn_fraction.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_fraction.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_fraction.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_1.setText("1");
        btn_1.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_1.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_1.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_2.setText("2");
        btn_2.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_2.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_2.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_3.setText("3");
        btn_3.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_3.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_3.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_minus.setText("-");
        btn_minus.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_minus.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_minus.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_0.setText("0");
        btn_0.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_0.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_0.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_decimal.setText(".");
        btn_decimal.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_decimal.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_decimal.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_minusPlus.setText("+/-");
        btn_minusPlus.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_minusPlus.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_minusPlus.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_plus.setText("+");
        btn_plus.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_plus.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_plus.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_result.setText("=");
        btn_result.setMaximumSize(new java.awt.Dimension(50, 50));
        btn_result.setMinimumSize(new java.awt.Dimension(50, 50));
        btn_result.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout panel_btnGroupsLayout = new javax.swing.GroupLayout(panel_btnGroups);
        panel_btnGroups.setLayout(panel_btnGroupsLayout);
        panel_btnGroupsLayout.setHorizontalGroup(
            panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
            .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                            .addComponent(btn_mc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_mr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_sqrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                            .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_divide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_modulus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                            .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_mult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_fraction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                            .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                                    .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_minus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                                    .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_minusPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_plus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel_btnGroupsLayout.setVerticalGroup(
            panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
            .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_mc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_mr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_sqrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_divide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_modulus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_mult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_fraction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panel_btnGroupsLayout.createSequentialGroup()
                            .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_minus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel_btnGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_minusPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_plus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btn_result, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton1.setText("Clear");

        jLabel1.setText("Calculator LAB - QUYTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_result)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel_btnGroups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input_result, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_btnGroups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_decimal;
    private javax.swing.JButton btn_divide;
    private javax.swing.JButton btn_fraction;
    private javax.swing.JButton btn_mc;
    private javax.swing.JButton btn_minus;
    private javax.swing.JButton btn_minusPlus;
    private javax.swing.JButton btn_mm;
    private javax.swing.JButton btn_modulus;
    private javax.swing.JButton btn_mp;
    private javax.swing.JButton btn_mr;
    private javax.swing.JButton btn_mult;
    private javax.swing.JButton btn_plus;
    private javax.swing.JButton btn_result;
    private javax.swing.JButton btn_sqrt;
    private javax.swing.JTextField input_result;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel_btnGroups;
    // End of variables declaration//GEN-END:variables
}
