package array.advanced;

public class MaxSquare {
	public static void main(String[] args) {
		MaxSquare ms = new MaxSquare();
		char[][] squares = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(ms.maximalSquare1(squares));
	}
	public void print(int[][] dp, int m, int n) {
		int i,j;
		for (i=0;i<m;i++) {
			for (j=0;j<n;j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public int min(int a, int b, int c) {
		return (a<b)?(a<c?a:c):(b<c?b:c);
	}
	public int maximalSquare(char[][] matrix) {
		if (matrix == null) return 0;
		if (matrix.length == 0) return 0;
		int m, n;
		m = matrix.length;
		n = matrix[0].length;
		// dp[i][j]存放以 (i,j) 为正方形右下角的正方形的边长
		int[][] dp = new int[m][n];
		
		int i,j;
		for (i=0; i<m; i++) {
			for (j=0; j<n; j++) {
				dp[i][j] = matrix[i][j] - 48;
			}
		}
		int max = dp[0][0];
		for (i=0;i<m;i++) {
			for (j=0;j<n;j++) {
				if (i > 0 && j > 0 && matrix[i][j] == '1' && matrix[i][j-1] == '1' &&
					matrix[i-1][j] == '1' && matrix[i-1][j-1] == '1') {
					dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1;
				}
				else {
					dp[i][j] = matrix[i][j] - 48;
				}
				if (dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		}
		
		return max*max;
    }
	
	public int maximalSquare1(char[][] matrix) {
		if (matrix == null) return 0;
		if (matrix.length == 0) return 0; // [[]]
		int m,n;
		m = matrix.length;
		n = matrix[0].length;
		// 实际上dp在计算过程中始终只会用到 2 行，计算第 i 行只需要第 i-1 行 和 第 i 行的信息， 因此可以进行迭代使用，从而节省空间；dp[i][j]存放以 (i,j) 为正方形右下角的正方形的边长
		int[][] dp = new int[2][n];
		int i,j;
		for (j=0; j<n; j++) {
			dp[0][j] = matrix[0][j] - 48;
		}
		if (matrix.length > 1) {
			dp[1][0] = matrix[1][0] - 48;
		}
		
		for (j=0;j<n;j++) {
			System.out.print(dp[0][j] + " ");
		}
		System.out.println();
		for (j=0;j<n;j++) {
			System.out.print(dp[1][j] + " ");
		}
		System.out.println();
		System.out.println("||||--------------------------||||");
		
		int max = dp[0][0];
		for (i=0;i<m;i++) {
			for (j=0;j<n;j++) {
				if (i > 0 && j > 0 && matrix[i][j] == '1' && matrix[i][j-1] == '1' &&
					matrix[i-1][j] == '1' && matrix[i-1][j-1] == '1') {
					dp[1][j] = min(dp[0][j-1], dp[1][j-1], dp[0][j]) + 1;
				}
				else {
					dp[1][j] = matrix[i][j] - 48;
				}
				if (dp[1][j] > max) {
					max = dp[1][j];
				}
			}
			for (j=0;j<n;j++) {
				System.out.print(dp[0][j] + " ");
			}
			System.out.println();
			for (j=0;j<n;j++) {
				System.out.print(dp[1][j] + " ");
			}
			System.out.println();
			System.out.println("--------------------------");
			// 一行更新完之后， 交换位置进行交替的迭代赋值； 更新的行在进行下一轮计算时成为旧的行，即dp[0] 这一行；
			int[] temp = null;
			temp = dp[0];
			dp[0] = dp[1];
			dp[1] = temp;
			
			for (j=0;j<n;j++) {
				System.out.print(dp[0][j] + " ");
			}
			System.out.println();
			for (j=0;j<n;j++) {
				System.out.print(dp[1][j] + " ");
			}
			System.out.println();
			System.out.println("--------------------------");
				
		}
		
		return max*max;
	}
}
