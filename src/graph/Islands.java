package graph;

import java.util.Stack;

public class Islands {
	// [200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/)
	// [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/description/)
	
	// 法一 DFS; 这里的图中的节点可以看成矩形中的每个为1的元素,图的邻接点只有 上下左右 四个方向,因此 对邻接点的循环DFS改成四个条件判断进行. 
	// 普通的图是要循环因为不知道有多少个邻接点;这里能够确定最多四个
	public void dfs(char[][] grid, int i, int j, boolean[][] marked) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[i][j] == '0') return;
        marked[i][j] = true;
        if (j > 0 && j < col && grid[i][j-1] == '1' && !marked[i][j-1]) dfs(grid, i, j-1, marked);
        if (i > 0 && i < row && grid[i-1][j] == '1' && !marked[i-1][j]) dfs(grid, i-1, j, marked);
        if (j >= 0 && j < col - 1 && grid[i][j+1] == '1' && !marked[i][j+1]) dfs(grid, i, j+1, marked);
        if (i >= 0 && i < row - 1 && grid[i+1][j] == '1' && !marked[i+1][j]) dfs(grid, i+1, j, marked);
        return;
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] marked = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    count ++;
                    dfs(grid, i, j, marked);
                }
            }
        }
        return count;
    }
    
    // 法一 dfs 递归版本
    private int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, visited, i, j, row, col);
                    if (area > max) {
                        max = area;
                    }
                    area = 0;
                }
            }
        }
        return max;
    }
    
    public void dfs(int[][] grid, boolean[][] visited, int i, int j, int row, int col) {
        if (grid[i][j] == 0) return;
        if (visited[i][j]) return;
        visited[i][j] = true;
        area ++;
        if (i >= 0 && i < row && j >= 1 && j < col && grid[i][j-1] == 1) {
            dfs(grid, visited, i, j-1, row, col);
        }
        if (i >= 0 && i < row && j >= 0 && j < col - 1 && grid[i][j+1] == 1) {
            dfs(grid, visited, i, j+1, row, col);
        }
        if (j >= 0 && j < col && i >= 1 && i < row && grid[i-1][j] == 1) {
            dfs(grid, visited, i-1, j, row, col);
        }
        if (j >= 0 && j < col && i >= 0 && i < row - 1 && grid[i+1][j] == 1) {
            dfs(grid, visited, i+1, j, row, col);
        }
        return;
    }
    
    // 法二 iterative by stack, like binary tree 先序遍历的非递归
    public int maxAreaOfIslandIterative(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        // 四个方向
        int[] dr = new int[]{0,0,-1,1};
        int[] dc = new int[]{-1,1,0,0};
        boolean[][] marked = new boolean[r][c];
        
        int max = 0;
        
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !marked[i][j]) {
                    Stack<int[]> stack = new Stack<int[]>();
                    stack.push(new int[]{i, j});
                    int area = 0;
                    marked[i][j] = true;
                    while (!stack.isEmpty()) {
                        int[] pos = stack.pop();
                        area ++;
                        for (int k = 0; k < 4; k ++) { // left, right, up, down
                            int x = pos[0] + dr[k];
                            int y = pos[1] + dc[k];
                            if (0 <= x && x < r && 0<=y && y < c && !marked[x][y] && grid[x][y] == 1) {
                                stack.push(new int[]{x, y});
                                marked[x][y] = true;
                            }
                        }
                    }
                    max = Math.max(max, area);   
                }
            }
        }
        return max;
    }
}
