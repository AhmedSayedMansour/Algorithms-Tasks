package project;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

import java.util.ArrayList;

public class InputGraph {
    Graph<Integer, String> graph;
    InputGraph(ArrayList<Integer>vertices , ArrayList<MinimumSpaning.Edge> edges)
    {
         graph = new SparseMultigraph<>();

        // Add vertices
        for(int i=0 ; i<vertices.size() ; i++) graph.addVertex(vertices.get(i));
        // Add edges.
        for(int i=0 ; i<edges.size() ; i++)
        {
            graph.addEdge(String.valueOf(edges.get(i).weight), edges.get(i).src , edges.get(i).dest);
        }
    }
}
