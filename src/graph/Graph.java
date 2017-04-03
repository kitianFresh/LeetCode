package graph;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	int V;
	int E;
	LinkedList<Integer>[] adj;
	public void buildGraph() {
		
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		this.V = cin.nextInt();
		this.E = cin.nextInt();
		adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
		int i = this.E;
		while (i-- > 0) {
			this.addEdge(cin.nextInt(), cin.nextInt());
		}
	}
	
	public int V() { return this.V; }
	public int E() { return this.E; }
	public void addEdge(int v, int w) {
		adj[v].addFirst(w);
		adj[w].addFirst(v);
		E++;
	}
	public List<Integer> adj(int v) {
		return adj[v];
	}
}
