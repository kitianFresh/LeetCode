package array;

import java.util.Stack;

public class MaxRectangle {
	public static void main(String[] args) {
		MaxRectangle mr = new MaxRectangle();
//		char[][] squares = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//		char[][] squares = {{'1'},{'0'},{'1'},{'1'},{'1'},{'1'},{'0'}};
		char[][] squares = {{'0','0','0','0','1','1','1','0','1'},{'0','0','1','1','1','1','1','0','1'},{'0','0','0','1','1','1','1','1','0'}};
		System.out.println(mr.maximalRectangle(squares));
	}
	public void print(int[][][] dp, int m, int n) {
		int i,j;
		for (i=0;i<m;i++) {
			for (j=0;j<n;j++) {
				System.out.print(dp[i][j][0]+ "," + dp[i][j][1] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printMatrix(char[][] matrix, int m, int n) {
		int i,j;
		for (i=0;i<m;i++) {
			for (j=0;j<n;j++) {
				System.out.print(matrix[i][j]+ "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public int min(int a, int b, int c) {
		return (a<b)?(a<c?a:c):(b<c?b:c);
	}
	public int max(int a, int b, int c) {
		return (a>b)?(a>c?a:c):(b>c?b:c);
	}
	public int maximalRectInHist(int[] height) {
		if (height == null || height.length == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int cur,h,area,max;
		max = 0;
		for (int i=0; i<height.length+1; i++) {
			cur = (i == height.length) ? -1 : height[i];
			while (!stack.isEmpty() && cur < height[stack.peek()]) {
				h = stack.pop();
				area = height[h] * ((stack.isEmpty()?i:(i-stack.peek()-1)));
				max = Math.max(max, area);
			}
			stack.push(i);
		}
		return max;
	}
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int m,n;
		m = matrix.length;
		n = matrix[0].length;
		int[] height = new int[n];
		int max = 0;
		int i,j;
		for (i=0; i<n; i++) {
			height[i] = 0;
		}
		
		for (i=0;i<m;i++) {
			for (j=0;j<n;j++) {
				if (matrix[i][j] == '1') {
					height[j] += matrix[i][j] - 48;
				}
				else {
					height[j] = 0;
				}
			}
			max = Math.max(max,maximalRectInHist(height));
		}
		
		return max;
	}
}
