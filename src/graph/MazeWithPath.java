package graph;

import java.util.*;

public class MazeWithPath {
	
	// [迷宫问题](https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] maze = new int[m][n];
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    maze[i][j] = sc.nextInt();
                }
            }
            Stack<Node> stack = new Stack<Node>();
            Node node = maze(maze);
            while (node != null) {
                stack.push(node);
                node = node.parent;
            }
            while (!stack.isEmpty()) {
                node = stack.pop();
                int x = node.point[0];
                int y = node.point[1];
                System.out.println("(" + x + "," + y + ")");
            }
        }
    }
    
    public static class Node {
        int[] point = null;
        Node parent = null;
        
    }
    public static Node maze(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] marked = new boolean[m][n];
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,-1,0,1};
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                Queue<Node> queue = new LinkedList<Node>();
                Node entry = new Node();
                entry.point = new int[]{0,0};
                entry.parent = null;
                queue.offer(entry);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    while (size-- > 0) {
                        Node parent = queue.poll();
                        if (parent.point[0] == m-1 && parent.point[1] == n-1) return parent;
                        for (int k = 0; k < 4; k ++) {
                            int x = parent.point[0] + dr[k];
                            int y = parent.point[1] + dc[k];
                            if (0<=x && x<m && 0<=y && y<n && !marked[x][y] && maze[x][y] == 0) {
                                Node node = new Node();
                                node.point = new int[]{x,y};
                                node.parent = parent;
                                queue.offer(node);
                                marked[x][y] = true;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
