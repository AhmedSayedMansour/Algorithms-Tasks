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
public class AdjacencyMatrix {
    private boolean adjMatrix[][];
    private int numVertices;
    
    public AdjacencyMatrix(int numVertices) {
          this.numVertices = numVertices+1;
          adjMatrix = new boolean[numVertices+1][numVertices+1];
    }
 
      public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
    }  
    public String toString() {
        String s ="    ";
        for (int i = 1; i < numVertices; i++) {
            s+=i + " ";
        }
        s+="\n";
        for (int i = 1; i < numVertices; i++) {
            s+= i + ": ";
            for (int j = 1; j < numVertices; j++) {
                s+= adjMatrix[i][j]? "1 ":"0 ";
            }
            s += "\n";
        }
        return s;
    }
}
