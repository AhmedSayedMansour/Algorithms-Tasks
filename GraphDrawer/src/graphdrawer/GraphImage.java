/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdrawer;
 
import java.awt.Dimension;
import javax.swing.JFrame;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.util.ArrayList;
import javafx.util.Pair;

public class GraphImage {
    int number ;    //number of vertices
    ArrayList<Pair<String,String>> edges;
    
    public GraphImage(int number ,ArrayList<Pair<String,String>> edges) {
        this.number = number;
        this.edges = edges;
    }
    
    public VisualizationImageServer getGraphImageServer(){
        Graph<String, String> graph =
        new DirectedSparseMultigraph<String, String>();
        
        for(int i=0 ; i<number ;++i){
            graph.addVertex(Integer.toString(i+1));
        }
        
        for(int i=0 ; i<edges.size() ;++i){
            graph.addEdge(Integer.toString(i+1), edges.get(i).getKey(), edges.get(i).getValue(), EdgeType.DIRECTED);
        }
        
        VisualizationImageServer vv =
          new VisualizationImageServer(
            new CircleLayout(graph), new Dimension(300, 300));
        
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        
        return vv;
    }
    
//   public static void main( String[ ] args ) {
//        
//        JFrame frame = new JFrame();
//        frame.setSize(new Dimension(400,400));
//        frame.setLocation(700,300);
//        frame.getContentPane().add(vv);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        System.out.println(graph.toString());
//        
//   }
}