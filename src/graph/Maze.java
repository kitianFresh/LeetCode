package graph;

//write your code here
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
	
	// 图中的非带权路径最短路径问题，可以不使用迪杰斯特拉算法或弗洛伊德算法， 一般使用BFS既可以解决！
	// 因为BFS是广度有限搜索，对于求最短路径即多少条边也属于一种贪心算法.每一步都是沿着周围先试探一圈，保证路径最短。
	// 因此，最后问题需要路径长度，问题就归结为BFS，类似于树的层次遍历算法，添加size 控制层数
	// [走迷宫](https://www.nowcoder.com/practice/6276dbbda7094978b0e9ebb183ba37b9)
	public static final int N = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			char[][] maze = new char[N][N];
			for (int i = 0; i < N; i++) {
				maze[i] = scanner.nextLine().toCharArray();
			}

			System.out.println(minStep(maze));
		}
		scanner.close();
	}

	public static int minStep(char[][] maze) {
		int m = maze.length;
		int n = maze[0].length;
		int[] dr = new int[] { 0, -1, 0, 1 };
		int[] dc = new int[] { -1, 0, 1, 0 };// left, up, right, down
		boolean[][] marked = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 1 });// first start point
		int minStep = -1;
		marked[0][1] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			minStep++;
			while (size-- > 0) {
				int[] node = queue.poll();
				if (node[0] == m - 1 && node[1] == n - 2)
					return minStep;
				for (int k = 0; k < 4; k++) {
					int r = node[0] + dr[k];
					int c = node[1] + dc[k];
					if (0 <= r && r <= m && 0 <= c && c <= n && !marked[r][c] && maze[r][c] == '.') {
						queue.offer(new int[] { r, c });
						marked[r][c] = true;
					}
				}
			}
		}
		return 0;
	}
}