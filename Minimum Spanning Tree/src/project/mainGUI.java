/*
 * Created by JFormDesigner on Thu Mar 26 19:04:08 EET 2020
 */

package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Atef
 */
public class mainGUI extends JFrame {
    public mainGUI() {
        initComponents();
    }

    static int numberOfVertices , numberOfEdges;

    private void nextActionPerformed(ActionEvent e) {
        if(!vert.getText().equals("") && !edg.getText().equals(""))
        {
            numberOfVertices = Integer.parseInt(vert.getText());
            numberOfEdges = Integer.parseInt(edg.getText());
            this.setVisible(false);
            VerticesInput obj = new VerticesInput();
            obj.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Two fields is required");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Atef
        label1 = new JLabel();
        vert = new JTextField();
        label2 = new JLabel();
        edg = new JTextField();
        next = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Number of Vertices :");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 40), label1.getPreferredSize()));
        contentPane.add(vert);
        vert.setBounds(155, 35, 95, vert.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Number of Edges :");
        contentPane.add(label2);
        label2.setBounds(25, 80, label2.getPreferredSize().width, 25);
        contentPane.add(edg);
        edg.setBounds(155, 80, 95, edg.getPreferredSize().height);

        //---- next ----
        next.setText("Next");
        next.addActionListener(e -> nextActionPerformed(e));
        contentPane.add(next);
        next.setBounds(new Rectangle(new Point(145, 175), next.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(400, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Atef
    private JLabel label1;
    private JTextField vert;
    private JLabel label2;
    private JTextField edg;
    private JButton next;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainGUI().setVisible(true);
            }
        });
    }
}
