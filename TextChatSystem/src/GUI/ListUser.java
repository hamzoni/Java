
package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class ListUser extends javax.swing.JFrame {

    public ListUser() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        label_fullName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_users = new javax.swing.JList<>();
        button_close = new javax.swing.JButton();
        button_chat = new javax.swing.JButton();
        button_offlineMessages = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Login As: ");

        label_fullName.setText("username");

        jLabel3.setText("Registered Users");

        jScrollPane1.setViewportView(list_users);

        button_close.setText("Close");

        button_chat.setText("Chat");

        button_offlineMessages.setText("Offline Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_fullName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_close)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_offlineMessages)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_fullName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_chat)
                    .addComponent(button_close)
                    .addComponent(button_offlineMessages))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public JButton getButton_chat() {
        return button_chat;
    }

    public void setButton_chat(JButton button_chat) {
        this.button_chat = button_chat;
    }

    public JButton getButton_close() {
        return button_close;
    }

    public void setButton_close(JButton button_close) {
        this.button_close = button_close;
    }

    public JButton getButton_offlineMessages() {
        return button_offlineMessages;
    }

    public void setButton_offlineMessages(JButton button_offlineMessages) {
        this.button_offlineMessages = button_offlineMessages;
    }

    public JLabel getLabel_fullName() {
        return label_fullName;
    }

    public void setLabel_fullName(JLabel label_fullName) {
        this.label_fullName = label_fullName;
    }

    public JList<String> getList_users() {
        return list_users;
    }

    public void setList_users(JList<String> list_users) {
        this.list_users = list_users;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_chat;
    private javax.swing.JButton button_close;
    private javax.swing.JButton button_offlineMessages;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_fullName;
    private javax.swing.JList<String> list_users;
    // End of variables declaration//GEN-END:variables
}
