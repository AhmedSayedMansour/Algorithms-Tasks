public class HamPath extends HamCycle { 
    
    public HamPath(int v) {
        super(v);
    }
    
    @Override
    boolean Check(int graph[][], int path[], int pos) 
    { 

        if (pos == V) 
        { 

            if (graph[path[pos - 1]][path[0]] == 1) 
                return false; 
            else
                return true; 
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
    
    @Override
        void printSolution(int path[]) 
    { 
        System.out.print("Solution Exists: Following" + 
                           " is one Hamiltonian Path"); 
        for (int i = 0; i < V; i++) 
            System.out.print(" " + path[i] + " "); 
        
        System.out.println();
  
    }
       
        @Override
        int [] complete(int graph[][]) 
    { 
        path = new int[V]; 
        for (int i = 0; i < V; i++) 
            path[i] = -1; 
  
        path[0] = 0; 
        if (Check(graph, path, 1) == false) 
        { 
           int [] array = new int [0];
           return array;
        } 
   
        return path; 
    }
}
