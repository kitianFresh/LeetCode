package graph;

public class GraphCycle {
	boolean[] marked;
	boolean hasCycle = false;
	public GraphCycle(Graph G) {
		this.marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			dfs(G, v, v);
		}
	}
	
	public void dfs(Graph G, int start, int end) {
		marked[start] = true;
		for (int w : G.adj(start)) {
			if (!marked[w]) {
				dfs(G, w, end);
			}
			else if (w == end) hasCycle = true;
		}
	}
	public boolean isCycle() { return hasCycle; }
}
