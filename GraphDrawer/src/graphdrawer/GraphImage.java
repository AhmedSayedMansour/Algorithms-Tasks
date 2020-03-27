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

public class GraphImage {
    int number ;    //number of vertices
    ArrayList<Pair> edges;
    private boolean IncMatrix[][];
    
    public GraphImage(int number ,ArrayList<Pair> edges) {
        this.number = number;
        this.edges = edges;
        IncMatrix = new boolean[number+1][edges.size()];
    }
    
    public VisualizationImageServer getGraphImageServer(){
        Graph<String, String> graph =
        new DirectedSparseMultigraph<String, String>();
        
        for(int i=0 ; i<number ;++i){
            graph.addVertex(Integer.toString(i+1));
        }
        
        char c = 'a';
        for(int i=0 ; i<edges.size() ;++i){
            graph.addEdge(Character.toString(c), edges.get(i).getKey(), edges.get(i).getValue(), EdgeType.DIRECTED);
            IncMatrix[Integer.parseInt(edges.get(i).getKey())][i] = true;
            c++;
        }
        
        VisualizationImageServer vv =
          new VisualizationImageServer(
            new CircleLayout(graph), new Dimension(300, 300));
        
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        
        return vv;
    }
    
    public String getIncMatric(){
        String S = "Incidence Matrix :\n   ";  //Incidence Matrix
        for(int i=0 ; i<edges.size() ;++i){
                S+=Character.toString((char) ('a' +i))+" ";
        }
        S+="\n";
        for(int i=1 ; i<number+1 ;++i){
            S+=Integer.toString(i) +" ";
            for(int j=0 ; j<edges.size() ;++j){
                S+= IncMatrix[i][j] ? "1 " : "0 ";
            }
            S+="\n";
        }
        return S;
    }
}