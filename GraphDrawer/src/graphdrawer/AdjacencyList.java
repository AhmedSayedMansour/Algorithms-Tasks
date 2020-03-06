/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdrawer;

import java.util.LinkedList;

/**
 *
 * @author ahmed
 */
public class AdjacencyList {
    int V;  //number of vertices
    LinkedList<Integer> adjListArray[]; 
     
    AdjacencyList(int V) 
    { 
        this.V = V; 
        adjListArray = new LinkedList[V+1]; 
        
        for(int i = 0; i < V+1 ; i++){ 
            adjListArray[i] = new LinkedList<>(); 
        }
    } 
    
    public void addEdge(int src, int dest) 
    {  
        adjListArray[src].add(dest); 
        //adjListArray[dest].add(src); 
    } 
    
    public LinkedList<Integer> [] getAdjLists(){
        return adjListArray;
    }
    
    public String getFormattedList() 
    {   
        String out = "Adjacency List :\n";
        for(int v = 1; v < V+1; v++) 
        {  
            out += v;
            for(Integer pCrawl: adjListArray[v]){ 
                out += " -> "+pCrawl; 
            } 
            out+="\n"; 
        } 
        return out;
    } 
}
