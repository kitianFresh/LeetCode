package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BreathFirstPath {
	boolean[] marked;
	int[] edgeTo;
	int s;
	public BreathFirstPath(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		for (int i=0; i<G.V(); i++) {
			marked[i] = false;
		}
		this.s = s;
		bfs(G,s);
	}
	// 广度优先搜索, 得到森林, 且是最短路径,无权最短路径,即边的条数
	public void bfs(Graph G, int s) {
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);
		marked[s] = true;
		while (!queue.isEmpty()) {
			s = queue.poll();
			for (int v : G.adj(s)) {
				if (!marked[v]) {
					queue.offer(v);
					edgeTo[v] = s;
					marked[v] = true; // 进队之后立即标记
				}
			}
		}
	}
	// 错误的, 必须是进队就是已经访问,而不是出队列时, 因为这里需要判断是否已经访问过, 进队时候就已经访问了, 
	// 如果是出队的时候才访问,那么就晚了, 因为已经访问过的还在队列中,然后又被重复加入到队列中了
	/*
	public void bfs(Graph G, int s) {
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);
		while (!queue.isEmpty()) {
			s = queue.poll();
			marked[s] = true;
			for (Integer v : G.adj(s)) {
				System.out.print(v + " ");
				if (!marked[v]) {
					queue.offer(v);
					edgeTo[v] = s;
				}
			}
			System.out.println();
		}
	}
	*/
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
		Graph G = new Graph(0);
		G.buildGraph();
		BreathFirstPath bfp = new BreathFirstPath(G, 0);
		for (int v= 0; v < G.V(); v++) {
			if (bfp.hasPathTo(v)) {
				Stack<Integer> s = (Stack<Integer>)bfp.pathTo(v);
				while (!s.isEmpty()) {
					System.out.print(s.pop());
				}
				
			}
			System.out.println();
		}
	}
}
