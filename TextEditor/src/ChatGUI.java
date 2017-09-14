
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;

public class ChatGUI extends javax.swing.JFrame {

    private UndoManager manager;

    public ChatGUI() {
        initComponents();
        manager = new UndoManager();
        textarea.getDocument().addUndoableEditListener(manager);
        initDialogFont();
    }

    private String fonts[];
    private String styles[];
    private ArrayList<Integer> sizes;

    public void initDialogFont() {
        // set content dialog
        sizes = new ArrayList<Integer>();

        this.fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            select_fontFace.addItem(fonts[i]);
        }

        for (int i = 8; i <= 48; i += 2) {
            this.sizes.add(i);
            select_fontSize.addItem(i + "");
        }

        this.styles = new String[]{"Bold", "Italic", "Underline"};
        for (int i = 0; i < styles.length; i++) {
            select_fontStyle.addItem(styles[i]);
        }

        select_fontFace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = select_fontFace.getSelectedIndex();
                System.out.println();
            }
        });
        // show dialog
        this.dialog_font.pack();
        this.dialog_font.setLocationRelativeTo(null);
        this.dialog_font.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_font = new javax.swing.JDialog();
        select_fontFace = new javax.swing.JComboBox<>();
        select_fontSize = new javax.swing.JComboBox<>();
        select_fontStyle = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        demo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        button_undo = new javax.swing.JToggleButton();
        button_redo = new javax.swing.JToggleButton();
        toggle_underline = new javax.swing.JToggleButton();
        toggle_bold = new javax.swing.JToggleButton();
        toggle_italic = new javax.swing.JToggleButton();

        jButton1.setText("Submit");

        demo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        demo.setText("Demo text");
        demo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout dialog_fontLayout = new javax.swing.GroupLayout(dialog_font.getContentPane());
        dialog_font.getContentPane().setLayout(dialog_fontLayout);
        dialog_fontLayout.setHorizontalGroup(
            dialog_fontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_fontLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialog_fontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialog_fontLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(demo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_fontLayout.createSequentialGroup()
                        .addComponent(select_fontFace, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(select_fontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(select_fontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dialog_fontLayout.setVerticalGroup(
            dialog_fontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_fontLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialog_fontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_fontFace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_fontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_fontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(demo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textarea.setColumns(20);
        textarea.setRows(5);
        textarea.setText("You can either use array declaration or array literal (but only \nwhen you declare and affect the variable right away,\n array literals cannot be used for re-assigning an array).");
        jScrollPane1.setViewportView(textarea);

        button_undo.setText("Undo");
        button_undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_undoActionPerformed(evt);
            }
        });

        button_redo.setText("Redo");
        button_redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_redoActionPerformed(evt);
            }
        });

        toggle_underline.setText("U");
        toggle_underline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggle_underlineActionPerformed(evt);
            }
        });

        toggle_bold.setText("B");
        toggle_bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggle_boldActionPerformed(evt);
            }
        });

        toggle_italic.setText("I");
        toggle_italic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggle_italicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_undo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_redo)
                        .addGap(50, 50, 50)
                        .addComponent(toggle_bold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggle_italic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggle_underline)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_undo)
                    .addComponent(button_redo)
                    .addComponent(toggle_underline)
                    .addComponent(toggle_bold)
                    .addComponent(toggle_italic))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_undoActionPerformed
        if (manager.canUndo()) {
            manager.undo();
        }
    }//GEN-LAST:event_button_undoActionPerformed

    private void button_redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_redoActionPerformed
        if (manager.canRedo()) {
            manager.redo();
        }
    }//GEN-LAST:event_button_redoActionPerformed

    private void toggle_underlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggle_underlineActionPerformed
        
        Font font = textarea.getFont();
        Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
        map.put(TextAttribute.FONT, font);

        if (toggle_underline.isSelected()) {
            map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        } else {
            map.put(TextAttribute.UNDERLINE, -1);
        }

        font = Font.getFont(map);
        textarea.setFont(font);
        
    }//GEN-LAST:event_toggle_underlineActionPerformed

    private void toggle_boldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggle_boldActionPerformed

        Font font = textarea.getFont();
        
        if (toggle_bold.isSelected()) {
            font = font.isItalic()? 
                    font.deriveFont(Font.ITALIC | Font.BOLD) : 
                    font.deriveFont(Font.BOLD);
        } else {
            font = font.isItalic()? 
                    font.deriveFont(Font.ITALIC) : 
                    font.deriveFont(Font.PLAIN);
        }
        
        textarea.setFont(font);

    }//GEN-LAST:event_toggle_boldActionPerformed

    private void toggle_italicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggle_italicActionPerformed

        Font font = textarea.getFont();
        
        if (toggle_italic.isSelected()) {
            font = font.isBold() ? 
                    font.deriveFont(Font.ITALIC | Font.BOLD) : 
                    font.deriveFont(Font.ITALIC);
        } else {
            font = font.isBold() ? 
                    font.deriveFont(Font.BOLD) : 
                    font.deriveFont(Font.PLAIN);
        }
        
        textarea.setFont(font);

    }//GEN-LAST:event_toggle_italicActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton button_redo;
    private javax.swing.JToggleButton button_undo;
    private javax.swing.JLabel demo;
    private javax.swing.JDialog dialog_font;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> select_fontFace;
    private javax.swing.JComboBox<String> select_fontSize;
    private javax.swing.JComboBox<String> select_fontStyle;
    private javax.swing.JTextArea textarea;
    private javax.swing.JToggleButton toggle_bold;
    private javax.swing.JToggleButton toggle_italic;
    private javax.swing.JToggleButton toggle_underline;
    // End of variables declaration//GEN-END:variables
}
