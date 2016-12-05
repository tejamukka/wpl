/**
 * Class to represent a graph
 *  @author rbk
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Graph implements Iterable<Vertex> {
    List<Vertex> v; // vertices of graph
    int size; // number of verices in the graph
    boolean directed;  // true if graph is directed, false otherwise
    

    /**
     * Constructor for Graph
     * 
     * @param size
     *            : int - number of vertices
     */
    Graph(int size) {
	this.size = size;
	this.v = new ArrayList<>(size + 1);
	this.v.add(0, null);  // Vertex at index 0 is not used
	this.directed = false;  // default is undirected graph
	// create an array of Vertex objects
	for (int i = 1; i <= size; i++)
	    this.v.add(i, new Vertex(i));
    }

    /**
     * Find vertex no. n
     * @param n
     *           : int
     */
    Vertex getVertex(int n) {
	return this.v.get(n);
    }
    
    /**
     * Method to add an edge to the graph
     * 
     * @param a
     *            : int - one end of edge
     * @param b
     *            : int - other end of edge
     * @param weight
     *            : int - the weight of the edge
     */
    void addEdge(Vertex from, Vertex to, int weight) {
	Edge e = new Edge(from, to, weight);
	if(this.directed) {
	    from.adj.add(e);
            to.revAdj.add(e);
	} else {
	    from.adj.add(e);
	    to.adj.add(e);
	}
    }

    /**
     * Method to create iterator for vertices of graph
     */
    public Iterator<Vertex> iterator() {
	Iterator<Vertex> it = this.v.iterator();
	it.next();  // Index 0 is not used.  Skip it.
	return it;
    }

    // Run BFS from a given source node
    // Precondition: nodes have already been marked unseen
    public void bfs(Vertex src) {
	src.seen = true;
	src.d = 0;
	Queue<Vertex> q = new LinkedList<>();
	q.add(src);
	while(!q.isEmpty()) {
	    Vertex u = q.remove();
	    for(Edge e: u.adj) {
		Vertex v = e.otherEnd(u);
		if(!v.seen) {
		    v.seen = true;
		    v.d = u.d + 1;
		    q.add(v);
		}
	    }
	}
    }
    
    public static void connectGraph(Graph g){
    	for(Vertex u:g){
    		u.indegree = u.revAdj.size();
    		u.outdegree = u.adj.size();
    		
    	}

    		for(Vertex u: g){
    			if(u.d==0 && u.indegree==0){
    				for(Vertex v:g){
    					if(v.indegree==0 && v.d!=0){
    						g.addEdge(g.getVertex(u.name), g.getVertex(v.name), 0);
    						u.outdegree++;
    						v.indegree++;
    					}
    				}
    				break;
    			}
    		}
    		for(Vertex u: g){
    			if(u.d==0 && u.outdegree==0){
    				for(Vertex v:g){
    					if(v.outdegree==0 && v.d!=0){
    						g.addEdge(g.getVertex(v.name), g.getVertex(u.name), 0);
    						u.indegree++;
    						v.outdegree++;
    					}
    				}
    				break;
    			}
    		}
    }

    // Check if graph is bipartite, using BFS
    public boolean isBipartite() {
	for(Vertex u: this) {
	    u.seen = false;
	}
	for(Vertex u: this) {
	    if(!u.seen) {
		bfs(u);
	    }
	}
	for(Vertex u:this) {
	    for(Edge e: u.adj) {
		Vertex v = e.otherEnd(u);
		if(u.d == v.d) {
		    return false;
		}
	    }
	}
	return true;
    }


    // read a directed graph using the Scanner interface
    public static Graph readDirectedGraph(Scanner in) {
	return readGraph(in, true);
    }
    
    // read an undirected graph using the Scanner interface
    public static Graph readGraph(Scanner in) {
	return readGraph(in, false);
    }
    
    public static Graph readGraph(Scanner in, boolean directed) {
	// read the graph related parameters
	int n = in.nextInt(); // number of vertices in the graph
	int m = in.nextInt(); // number of edges in the graph

	// create a graph instance
	Graph g = new Graph(n);
	g.directed = directed;
	for (int i = 0; i < m; i++) {
	    int u = in.nextInt();
	    int v = in.nextInt();
	    int w = in.nextInt();
	    g.addEdge(g.getVertex(u), g.getVertex(v), w);
	}
	return g;
    }

}
