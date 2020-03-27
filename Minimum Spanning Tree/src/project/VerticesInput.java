package project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Atef
 */
public class VerticesInput extends JFrame {
    int checkV = 0 , checkE = 0;
    int Name;
    static ArrayList<Integer> vertices = new ArrayList<>();
    static ArrayList<MinimumSpaning.Edge> edges = new ArrayList();

    static mainGUI main = new mainGUI();
    public VerticesInput() {
        initComponents();
    }

    private void add1ActionPerformed(ActionEvent e) {
        if(!name.getText().equals("") && checkV < main.numberOfVertices)
        {
            Name = Integer.parseInt(name.getText());
            vertices.add(Name);
            checkV += 1;
            name.setText("");
        }
        else if(name.getText().equals(""))
            JOptionPane.showMessageDialog(null, "This field can't be empty");
        else if(checkV >= main.numberOfVertices)
        {
            JOptionPane.showMessageDialog(null, "You entered all vertices name");
            name.setText("");
        }
    }

    private void add2ActionPerformed(ActionEvent e) {
        if(!src.getText().equals("") && !dest.getText().equals("") && !weight.getText().equals("") && checkE < main.numberOfEdges && checkV == main.numberOfVertices) {
            int source, destination, Weight;
            source = Integer.parseInt(src.getText());
            destination = Integer.parseInt(dest.getText());
            Weight = Integer.parseInt(weight.getText());
            src.setText("");
            dest.setText("");
            weight.setText("");
            edges.add(new MinimumSpaning.Edge(source, destination, Weight));
            checkE += 1;
        }
        else if(checkV < main.numberOfVertices)
            JOptionPane.showMessageDialog(null, "You Should enter all vertices' names first!");
        else if(checkE >= main.numberOfEdges)
        {
            JOptionPane.showMessageDialog(null, "You entered all edges!");
        }
        else
            JOptionPane.showMessageDialog(null, "The 3 fields can't be empty!");
    }
    private void runActionPerformed(ActionEvent e) {
        try
        {
            MinimumSpaning.Edge [] result;
            ArrayList<MinimumSpaning.Edge> newEdges = new ArrayList<>();
            InputGraph graph = new InputGraph(vertices , edges);
            DrawGraph draw = new DrawGraph(graph , "Original Tree" ,1);

            MinimumSpaning minimum = new MinimumSpaning(main.numberOfVertices , main.numberOfEdges , edges);
            result = minimum.KruskalMST();
            for(int i=0 ; i<result.length ; i++)
            {
                newEdges.add(result[i]);
            }
            InputGraph graph2 = new InputGraph(vertices , newEdges);
            DrawGraph draw2 = new DrawGraph(graph2 , "Minimum Spanning Tree" , 2);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Can't draw the minimum Spanning tree =>(Vertices must be more than2)!");
            System.out.println(ex);
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Atef
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        name = new JTextField();
        add1 = new JButton();
        add2 = new JButton();
        separator1 = new JSeparator();
        src = new JTextField();
        dest = new JTextField();
        weight = new JTextField();
        separator2 = new JSeparator();
        separator3 = new JSeparator();
        run = new JButton();
        label7 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Vertix Name :");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 60), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Src : ");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(10, 155), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Dest :");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(10, 205), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("Weight :");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(135, 180), label4.getPreferredSize()));
        contentPane.add(name);
        name.setBounds(110, 60, 80, name.getPreferredSize().height);

        //---- add1 ----
        add1.setText("ADD");
        add1.addActionListener(e -> add1ActionPerformed(e));
        contentPane.add(add1);
        add1.setBounds(new Rectangle(new Point(235, 55), add1.getPreferredSize()));

        //---- add2 ----
        add2.setText("ADD");
        add2.addActionListener(e -> add2ActionPerformed(e));
        contentPane.add(add2);
        add2.setBounds(new Rectangle(new Point(275, 175), add2.getPreferredSize()));
        contentPane.add(separator1);
        separator1.setBounds(new Rectangle(new Point(0, 120), separator1.getPreferredSize()));
        contentPane.add(src);
        src.setBounds(50, 150, 65, src.getPreferredSize().height);
        contentPane.add(dest);
        dest.setBounds(50, 195, 65, dest.getPreferredSize().height);
        contentPane.add(weight);
        weight.setBounds(190, 175, 70, weight.getPreferredSize().height);
        contentPane.add(separator2);
        separator2.setBounds(25, 115, 155, 0);
        contentPane.add(separator3);
        separator3.setBounds(0, 110, 400, 5);

        //---- run ----
        run.setText("Run");
        run.addActionListener(e -> runActionPerformed(e));
        contentPane.add(run);
        run.setBounds(new Rectangle(new Point(315, 235), run.getPreferredSize()));

        //---- label7 ----
        label7.setText("Enter All vertices name (First)");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(20, 15), label7.getPreferredSize()));

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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Atef
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField name;
    private JButton add1;
    private JButton add2;
    private JSeparator separator1;
    private JTextField src;
    private JTextField dest;
    private JTextField weight;
    private JSeparator separator2;
    private JSeparator separator3;
    private JButton run;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
