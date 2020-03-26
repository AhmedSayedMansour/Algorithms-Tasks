public class HamCycle {
  public int V; 
  public int path[]; 
  
     HamCycle(int v) 
    {
      V = v;
    }
      boolean isSafe(int v, int graph[][], int path[], int pos) 
    { 
        if (graph[path[pos - 1]][v] == 0) 
            return false; 
  
        for (int i = 0; i < pos; i++) 
            if (path[i] == v) 
                return false; 
  
        return true; 
    }
      boolean Check(int graph[][], int path[], int pos) 
    { 

        if (pos == V) 
        { 

            if (graph[path[pos - 1]][path[0]] == 1) 
                return true; 
            else
                return false; 
        } 

        for (int v = 1; v < V; v++) 
        { 

            if (isSafe(v, graph, path, pos)) 
            { 
                path[pos] = v; 
  
                if (Check(graph, path, pos + 1) == true) 
                    return true; 

                path[pos] = -1; 
            } 
        } 
  
        return false; 
    }
      
        int[] complete(int graph[][]) 
    { 
        path = new int[V+1]; 
        for (int i = 0; i < V; i++) 
            path[i] = -1; 
  
        path[0] = 0; 
        if (Check(graph, path, 1) == false) 
        { 
           int [] array = new int [0];
           return array;
        }
        path[V] = 0;
        return path; 
    }
        void printSolution(int path[]) 
    { 
        System.out.print("Solution Exists: Following" + 
                           " is one Hamiltonian Cycle"); 
        for (int i = 0; i < V; i++) 
            System.out.print(" " + path[i] + " "); 
  

        System.out.println(" " + path[0] + " "); 
    }
        
   
}

