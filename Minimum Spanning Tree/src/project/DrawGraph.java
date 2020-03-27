package project;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import org.apache.commons.collections15.Transformer;

import javax.swing.*;
import java.awt.*;

public class DrawGraph {
    DrawGraph(InputGraph input , String name , int pos)
    {
        Layout<Integer, String> layout = new CircleLayout<>(input.graph);
        layout.setSize(new Dimension(300,300));
        BasicVisualizationServer<Integer,String> vv =
                new BasicVisualizationServer<Integer,String>(layout);
        vv.setPreferredSize(new Dimension(350,350));

        Transformer<Integer,Paint> vertexPaint = i -> Color.WHITE;
        float dash[] = {0.1f};
        final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE,
                BasicStroke.JOIN_BEVEL, 10.0f, dash, 0.0f);
        Transformer<String, Stroke> edgeStrokeTransformer =
                new Transformer<String, Stroke>() {
                    public Stroke transform(String s) {
                        return edgeStroke;
                    }
                };
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        JFrame frame = new JFrame(name);
        if(pos == 1)
            frame.setLocation(50,50);
        else
            frame.setLocation(800,50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
