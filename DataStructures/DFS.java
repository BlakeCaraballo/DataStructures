package lab12;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class DFS {
	
	static class Graph{
		int V;
		LinkedList<Integer>[]adj;
		
		Graph(int V)
		    {
		      this.V=V;
		      adj = new LinkedList[V];
		      for(int i=0;i<adj.length;i++)
		        {
		            adj[i]=new LinkedList<Integer>();
		        }
		    }
		
		void addEdge(int v,int w){
			adj[v].add(w);
		    }
		
		//Traverse one component completely 
		void recursiveDFS(int v,boolean visited[])
		  {
		    visited[v]=true;
		    System.out.print(v+" ");
		    Iterator<Integer> i=adj[v].listIterator();
		    
		    while(i.hasNext())
		    {
		       int n=i.next();
		       
		       if(!visited[n])
		        {
		            recursiveDFS(n, visited);
		        }
		    }
		  }
		
		//DFS on disconnected components and keep track of visited vertices
		void DFS(int v)
		  {
		      boolean visited[]=new boolean[v];
		      recursiveDFS(0, visited);
		  }
		
		
		

		}
		    public static void main(String args[])
		    {
		    Graph g=new Graph(7);
		    g.addEdge(0, 1);
		    g.addEdge(0,2);
		    g.addEdge(2, 3);
		    g.addEdge(2,4);
		    g.addEdge(4, 5);
		    g.addEdge(1, 3);
		    g.addEdge(3, 5);

		    System.out.println("The Depth first Traveresal with source 0 is");
		    g.DFS(7);
		    System.out.println();
		    }

		    

		}


