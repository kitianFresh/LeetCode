package graph;

import java.util.Stack;

public class DepthFirstPath {
	boolean[] marked;
	int[] edgeTo;
	int s; // 起点
	public DepthFirstPath(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	public void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != this.s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(this.s);
		return path;
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.buildGraph();
		DepthFirstPath dfp = new DepthFirstPath(G, 0);
		for (int v= 0; v < G.V(); v++) {
			if (dfp.hasPathTo(v)) {
				Stack<Integer> s = (Stack<Integer>)dfp.pathTo(v);
				while (!s.isEmpty()) {
					System.out.print(s.pop());
				}
				
			}
			System.out.println();
		}
	}
}

//6
//8
//0 5
//2 4
//2 3
//1 2
//0 1
//3 4
//3 5
//0 2
