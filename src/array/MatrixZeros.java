package array;

public class MatrixZeros {
	
	// [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/#/solutions)
	// 法一是开辟一个矩阵的复制本, 然后扫描复制本,置0矩阵;
    // 法二, 空间可以压缩到 O(m+n); 把最左和最上边的一列和一行当做一个坐标, 扫描一遍矩阵标记对应行列需要置0的 i 和 j, 然后再次根据坐标标记置0;
	public void setZeros1(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] x = new int[n];
        int[] y = new int[m];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    x[j] = 1;
                    y[i] = 1;
                }
            }
        }
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (x[j] == 1 || y[i] == 1) matrix[i][j] = 0;
            }
        }
	}
	
	// 注意不要碰到0就直接讲本行本列置0, 因为这样后面不就全是0了;
    // 法三，空间可以进一步压缩至(1). 其实可以想办法利用矩阵本身的某行某列来标记坐标位置是否置0
	// 对于第一行第一列，可以把他们当做标记坐标系，当扫描到某个matrix[i][j] = 0 的时候，就将matrix[0][j] 和　matrix[i][0] 标记为　0, 
	// 表明该行该列将要置０，但是有可能第一行第一列本身也会置0，因此需要用变量记录下来，看最后是否置0
	public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean fr = false;
        boolean fc = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        
        if (fr) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        return ;
    }
}
