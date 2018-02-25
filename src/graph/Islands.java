package graph;

public class Islands {
	
	// [200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/)
	
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
}
