import java.util.Scanner;

public class LCSeq {
	public static int maxLCS(String A, String B) {
		int m = A.length();
		int n = B.length();
		int[][] dp = new int[m+1][n+1];
		for (int i = 0; i < m + 1; i ++) dp[i][0] = 0;
		for (int j = 0; j < n + 1; j ++) dp[0][j] = 0;
		for (int i = 1; i < m + 1; i ++) {
			for (int j = 1; j < n + 1; j ++) {
				if (A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = Math.max(dp[i-1][j-1]+1, Math.max(dp[i-1][j], dp[i][j-1]));
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(maxLCS(a, b));
	}
}
