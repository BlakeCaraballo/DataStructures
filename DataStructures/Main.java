package lab13;

import java.util.*;
public class Main {
	
 static class Graph {
     int V; //Number of Vertices
     LinkedList<LinkedList<Integer>> adj; // adjacency lists
     //Constructor
     Graph(int V)
     {
         this.V = V;
         adj = new LinkedList<LinkedList<Integer>>();
         for (int i = 0; i < V; i++) 
             adj.add(new LinkedList<Integer>());
     }
     //To add an edge to graph
     void addEdge(int v, int w)
     {
         adj.get(v).add(w);
         // Add w to the list of v.
     }
 }

 public static void main(String[] args) {
     int V = 6;
     Graph g = new Graph(6);
     g.addEdge(0, 1); g.addEdge(0, 2);  g.addEdge(2, 3);
     g.addEdge(2, 4); g.addEdge(4, 5);  g.addEdge(1, 3);
     g.addEdge(3, 5);
     
     // Queue for BFS traversal
     Queue<Integer> pq = new LinkedList<Integer>();
     pq.add(0); // first push the source node i.e 0
     
     //this boolean array helps check whether the given vertex has been visited 
     boolean[] visited = new boolean[V];
     Arrays.fill(visited,false);// mark as false
     System.out.println("BFS Traversal for the given graph is ");
     visited[0] = true;// mark source as true
     while (pq.isEmpty() == false){
           int  top = pq.remove(); // pick the node from the front of the queue
         System.out.print(top+" ");
         // now check the neighbors of this node
         for (int element : g.adj.get(top)){
             // if this element has not been visited before
             // mark this element as visited
             // and push it into the queue
             if(visited[element] == false){
             visited[element] = true;
             pq.add(element);
             }
         }
     }
 }
}
//
