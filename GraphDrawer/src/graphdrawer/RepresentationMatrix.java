/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdrawer;

/**
 *
 * @author ahmed
 */
public class RepresentationMatrix {
    private int adjMatrix[][];
    private int numVertices;
    
    public RepresentationMatrix(int numVertices) {
          this.numVertices = numVertices+1;
          adjMatrix = new int[numVertices+1][numVertices+1];
    }
 
      public void addEdge(int i, int j) {
        adjMatrix[i][j] += 1;
    }  
    public String toString() {
        String s = "Adjacency Matrix :\n";
        s +="    ";
        for (int i = 1; i < numVertices; i++) {
            s+=i + " ";
        }
        s+="\n";
        for (int i = 1; i < numVertices; i++) {
            s+= i + ": ";
            for (int j = 1; j < numVertices; j++) {
                s+= adjMatrix[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
