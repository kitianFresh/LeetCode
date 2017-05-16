package graph;

import java.util.Deque;
import java.util.LinkedList;

public class TwoColor {
	// 二分图问题, 如电影演员图,可以把节点完全分为 电影节点 和 演员节点两类, 其中演员和演员没有直接链接, 电影和电影之间也没有直接链接!
	boolean[] marked;
	boolean[] color;
	boolean isTwoColorable = true;
	public TwoColor(Graph G) {
		this.marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			dfs(G, v);
		}
	}
	
	public void dfs(Graph G, int s) {
		marked[s] = true;
		for (int v : G.adj(s)) {
			if (!marked[v]) {
				color[v] = !color[s];
				dfs(G, v);
			}
			else if(color[v] == color[s]) isTwoColorable = false;
		}
	}
	
	public boolean isBiPartie() {
		return isTwoColorable;
	}
	
	// 两个同色节点之间的间隔度数,即他们之间至少有多少个另一种颜色的节点
	public int gapDegrees(Graph G, int u, int v) {
		
		if (color[u] != color[v]) throw new IllegalArgumentException();
		return bfs(G, u, v);
	}
	
	public int bfs(Graph G, int u, int v) {
		for (int i = 0; i < G.V(); i++) {
			marked[i] = false;
		}
		int degree = 0;
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.offer(u);
		marked[u] = true;
		while (!queue.isEmpty()) {
			u = queue.poll();
			if (color[u]) degree ++; // 每次碰到另一种颜色,度数加 1
			for (Integer w : G.adj(u)) {
				if (!marked[w]) {
					marked[w] = true;
					queue.offer(w);
					if (w == v) return degree;
				}
			}
		}
		return 0;
	}
}
