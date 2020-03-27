input example

5

0 1 0 1 0  
1 0 1 1 1  
0 1 0 0 1  
1 1 0 0 1  
0 1 1 1 0


for cycle 
 0  1  2  4  3  0
 
 
 
Backtracking Algorithm
Create an empty path array and add vertex 0 to it. Add other vertices, starting from the vertex 1. Before adding a vertex, check for whether it is adjacent to the previously added vertex and not already added. If we find such a vertex, we add the vertex as part of the solution. If we do not find a vertex then we return false.
