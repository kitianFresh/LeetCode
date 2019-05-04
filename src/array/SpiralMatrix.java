package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	// 法三
	// 利用矩阵乘法, 记住,数组即向量, 对数组的操作很多时候可以理解成使用矩阵对数组做矩阵变换,从而转为一个计算问题.比如 魔术圈,rotate array
	
	// 法二
	// 利用方向 O(m+n)
	public List<Integer> spiralOrderOpt(int[][] matrix) {
        List<Integer> path = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return path;
        if (matrix[0] == null || matrix[0].length == 0) return path;
        int m = matrix.length; //行数
        int n = matrix[0].length; // 列数
        
        // 四个方向分别表示向 right, down, left, up, 0,1,2,3里面的值表示的是如果朝着这个方向,下一步坐标x,y需要变化的值
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int[] nSteps = new int[]{n, m-1}; //nSteps[0] 表示左右方向需要走的步数, nSteps[1] 表示上下方向需要走的步数, 初始的时候分别是 n, m-1
        
        int idxDir = 0; // 初始方向 即 向right
        int ir = 0, ic = -1; // x,y 位置
        while (nSteps[idxDir%2] != 0) { 
            for (int i=0; i < nSteps[idxDir%2]; i++) { // 控制方向的步数, 一直走到该方向最后一个元素
                ir += directions[idxDir][0]; ic += directions[idxDir][1];
                path.add(matrix[ir][ic]);
            }
            nSteps[idxDir%2]--; // 该方向走完之后,即可减去1, 因为不需要
            idxDir = (idxDir+1)%4; // 更换方向索引,四个方向,依次按顺序进行,因此 +1 对4 取模即可
        }
        
        return path;
    }
	// 法一
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> path = new ArrayList<Integer>();
        if (matrix == null || matrix.length < 1) return path;
        int m, n, left, right, top, down;
        m = matrix.length;
        n = matrix[0].length;
        left = 0;
        right = n - 1;
        top = 0;
        down = m  - 1;
        int row, col;
        // 按照一行一列完成之后直接去掉来循环,不要想着左右边界上下边界
        while (left <= right && top <= down) {
            // left to right 
            for (col = left; col <= right; col ++) {
                path.add(matrix[top][col]);
            }
            top ++; // 最上面一行完成, 去掉
            
            // top to down 
            for (row = top; row <= down; row++) {
                path.add(matrix[row][right]);
            }
            right --; // 最右边一列完成, 去掉
            
            
            if (top > down) break; // 由于可能此时已经没的最后一行了,需要检查
            
            // right to left
            for (col = right ;col >= left; col--) {
                path.add(matrix[down][col]);
            }
            down --; // 最下面一行完成, 去掉
            
            
            if (left > right) break;  // 由于此时可能已经没的最左边一列了,需要检查
            
            for (row = down;row >= top; row--) {
                path.add(matrix[row][left]);
            }
            left ++; // 最左边一列完成, 去掉
        }
        return path;
    }
	public List<Integer> spiralOrderWrong(int[][] matrix) {
        if (matrix == null || matrix.length < 1) return null;
        List<Integer> path = new ArrayList<Integer>();
        int m,n,i,j,k;
        m = matrix.length;
        n = matrix[0].length;
        if (m == 1) {
            for (i = 0; i < n; i++) {
                path.add(matrix[0][i]);
            }
            return path;
        }
        if (n == 1) {
            for (i=0; i<m; i++) {
                path.add(matrix[i][0]);
            }
            return path;
        }
        k = 0;
        i = j = 0;
        int bound = (int) Math.min(Math.ceil(1.0 * m / 2), Math.ceil(1.0 * n / 2));
        for (k = 0; k < bound; k++) {
            i = j = k;
            for (j = k; j < n - k - 1; j ++) {
                path.add(matrix[k][j]);
            }
            
            for (i = k; i < m - k - 1; i ++) {
                path.add(matrix[i][n-k-1]);
            }
            
            for (;j > k; j--) {
                path.add(matrix[m-k-1][j]);
            }
            
            for (;i > k; i --) {
                path.add(matrix[i][k]);
            }
        }
        if (i == j) path.add(matrix[i][j]);
        return path;
    }
}
