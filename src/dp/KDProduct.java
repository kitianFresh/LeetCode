package dp;

import java.util.Scanner;

public class KDProduct {
	// testcase
	/**
	 * 47
	 * -41 -5 -10 -31 -44 -16 -3 -33 -34 -35 -44 -44 -25 -48 -16 -32 -37 -8 -33 -30 -6 -18 -26 -37 -40 -30 -50 -32 -5 -41 -32 -12 -33 -22 -14 -34 -1 -41 -45 -8 -39 -27 -23 -45 -10 -50 -34
	 * 6 3
	 */
	// 错误理解一， 未考虑最内层循环在寻找最小 maxProduct[i][j] 的时候，由于是需要往前搜索所有 满足 间隔小于d 的解的过程，
	// 如果这里只是不断的给 maxProduct[i][j] 赋值，那么就不是在求解最大值或者最小值了，必须对于前面的搜索完一次就让其参与比较！
	public static int kdProduct1(int[] A, int k, int d) {
		int n = A.length;
		int res = Integer.MIN_VALUE;
		int[][] maxProduct = new int[n+1][k+1];
		int[][] minProduct = new int[n+1][k+1];
		for (int i=0;i<=n;i++) maxProduct[i][0] = minProduct[i][0] = 1;
		for (int j=0;j<=k;j++) maxProduct[0][j] = minProduct[0][j] = 1;
		
		for (int i=1; i<=n; i++) {
			for (int j=1;j<=k;j++) {
				for (int m=i-1; m>=Math.max(0,i-d); m--) {
					maxProduct[i][j] = Math.max(maxProduct[m][j-1]*A[i-1], minProduct[m][j-1]*A[i-1]);
					minProduct[i][j] = Math.min(minProduct[m][j-1]*A[i-1], maxProduct[m][j-1]*A[i-1]);
					System.out.println("i: " + i + "\tj: " + j + "\tm: " + m); 
//					display(maxProduct, minProduct, n, k);
				}
			}
		}
//		display(maxProduct, minProduct, n, k);
		
		
		return maxProduct[n][k];
	}
	// 错误理解2，如果让 maxProduct[i][j] 参与比较，那么首次比较的时候 maxProduct[i][j] 还没有值啊，对，因此这里需要给 maxProduct[i][j]
	// 不影响比较过程的初始值，由于是找最大最小，因此这里给出初始化的值maxProduct[i][j] = Integer.MIN_VALUE;minProduct[i][j] = Integer.MAX_VALUE;
	public static int kdProduct2(int[] A, int k, int d) {
		int n = A.length;
		int res = Integer.MIN_VALUE;
		int[][] maxProduct = new int[n+1][k+1];
		int[][] minProduct = new int[n+1][k+1];
		for (int i=0;i<=n;i++) maxProduct[i][0] = minProduct[i][0] = 1;
		for (int j=0;j<=k;j++) maxProduct[0][j] = minProduct[0][j] = 1;
		
		for (int i=1;i<=n;i++) {
			for (int j=1; j<=k; j++) {
				maxProduct[i][j] = Integer.MIN_VALUE;
				minProduct[i][j] = Integer.MAX_VALUE;
			}
		}
//		display(maxProduct, minProduct, n, k);
		for (int i=1; i<=n; i++) {
			for (int j=1;j<=k;j++) {
				for (int m=i-1; m>=Math.max(0,i-d); m--) {
					maxProduct[i][j] = Math.max(maxProduct[i][j],Math.max(maxProduct[m][j-1]*A[i-1], minProduct[m][j-1]*A[i-1]));
					minProduct[i][j] = Math.min(minProduct[i][j],Math.min(minProduct[m][j-1]*A[i-1], maxProduct[m][j-1]*A[i-1]));
					System.out.println("i: " + i + "\tj: " + j + "\tm: " + m); 
//					display(maxProduct, minProduct, n, k);
				}
			}
		}
		
		return maxProduct[n][k];
	}
	
	// 从 n 个数中选出 k 个数，且k个数相邻两个数的间距不超过d，找出这k个数，他们乘积最大，返回最大值。
	// -50 <= A[i] <= 50. 1<=d<=50。
	// 还是dp，这里关键是要找出 maxProduct[i][j] 表示前i个数中取j个数，且以第i个数结尾！(i = 0 to n)，我们知道最大值一定在这其中，
	// 这个事实标准很重要，因为会便于我们推到递推公式，如果不规定是以第i个数结尾，会非常麻烦！因为你不知道减小问题规模后，到哪里结束。对于d就很难利用
	// 为什么要以 第 i 个数为结尾作为下标呢？因为这样我们就能将 d 变量这一维度拿出来了！对于d的限制，由于我们知道是以 i 作为结尾，在求解 maxProduct[i][j];
	// 他的可能就只会是 maxProduct[i-d][j] maxProduct[i-d+1][j]....maxProduct[i-1][j] 中选择！
	// maxProduct[i][j] = Max(maxProduct[i-1][j-1]*A[i], minProduct[i-1][j-1]*A[i]);
	public static long kdProduct0(int[] A, int k, int d) {
		int n = A.length;
		long res = A[0];
		long[][] maxProduct = new long[n+1][k+1];
		long[][] minProduct = new long[n+1][k+1];
		for (int i=1;i<=n;i++) maxProduct[i][0] = minProduct[i][0] = 1;
		for (int j=0;j<=k;j++) maxProduct[0][j] = minProduct[0][j] = 1;
		
		for (int i=1;i<=n;i++) {
			for (int j=1; j<=k; j++) {
				maxProduct[i][j] = Long.MIN_VALUE;
				minProduct[i][j] = Long.MAX_VALUE;
			}
		}
		display(maxProduct, minProduct, n, k);
		for (int i=1; i<=n; i++) {
			maxProduct[i][1] = minProduct[i][1] = A[i-1];
			for (int j=1;j<=k;j++) {
				for (int m=i-1; m>=Math.max(0,i-d); m--) {
					maxProduct[i][j] = Math.max(maxProduct[i][j],Math.max(maxProduct[m][j-1]*A[i-1], minProduct[m][j-1]*A[i-1]));
					minProduct[i][j] = Math.min(minProduct[i][j],Math.min(minProduct[m][j-1]*A[i-1], maxProduct[m][j-1]*A[i-1]));
					System.out.println("i: " + i + "\tj: " + j + "\tm: " + m); 
					display(maxProduct, minProduct, n, k);
				}
				res = Math.max(res, Math.max(maxProduct[i][j], minProduct[i][j])); 
			}
			
		}
		//并不是返回 maxProduct[n][k],他是包含 n 的最大乘积，我们需要寻找最大乘积，虽然不一定是 maxProduct[n][k];但一定在 某一个 i 为尾节点的地方！
		return res;
	}
	
	public static Long kdProduct(int[] A, int k, int d) {
		int n = A.length;
		long res = Long.MIN_VALUE;
		long[][] maxProduct = new long[n][k];
		long[][] minProduct = new long[n][k];
		for (int i=0;i<n;i++) maxProduct[i][0] = minProduct[i][0] = A[i];// 第一列表示从 i 个数取 1 个，且包含i为尾部，则是他自己
		
		for (int i=0;i<n;i++) {
			for (int j=1; j<k; j++) {
				maxProduct[i][j] = 0;
				minProduct[i][j] = 0;
			}
		}

		for (int i=0; i<n; i++) {
			for (int j=1;j<k;j++) {
				for (int m=i-1; m>=Math.max(0,i-d); m--) {
					maxProduct[i][j] = Math.max(maxProduct[i][j],Math.max(maxProduct[m][j-1]*A[i], minProduct[m][j-1]*A[i]));
					minProduct[i][j] = Math.min(minProduct[i][j],Math.min(minProduct[m][j-1]*A[i], maxProduct[m][j-1]*A[i]));
				}
				res = Math.max(res, Math.max(maxProduct[i][j], minProduct[i][j])); 
			}
			
		}
		//并不是返回 maxProduct[n][k],他是包含 n 的最大乘积，我们需要寻找最大乘积，虽然不一定是 maxProduct[n][k];但一定在 某一个 i 为尾节点的地方！
		return res;
	}
	public static void display(long[][] maxProduct, long[][] minProduct, int n, int k) {
		for (int i=0;i<=n;i++) {
			for (int j=0;j<=k;j++) {
				System.out.print("(" + maxProduct[i][j] +", "+ minProduct[i][j] + ")" + "\t");
			}
			System.out.println();
		}
		System.out.println("----------------------------------");
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++){
			A[i] = sc.nextInt();
			System.out.println("A[" + i + "]: " + A[i]);
		}
		int k = sc.nextInt();
		int d = sc.nextInt();
		System.out.println("k: " + k + "\td: " + d);
		KDProduct kdp = new KDProduct();
		System.out.println(kdp.kdProduct0(A, k, d));
	}
}
