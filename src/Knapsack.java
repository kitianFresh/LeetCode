import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {
	public static int maxValue;
	public static List<Integer> list = new ArrayList<Integer>();

	public static int bag(int[][] arr, int capacity) {
		int N = arr.length;
		int[][] dp = new int[N + 1][capacity + 1];
		for (int i = 0; i < N + 1; i++)
			dp[0][i] = 0;
		for (int i = 0; i < capacity + 1; i++)
			dp[i][0] = 0;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;

				} else {
					if (j < arr[i][0]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						int value = arr[i][1];
						int weight = arr[i][0];
						dp[i][j] = Math.max(dp[i - 1][j - weight] + value, dp[i - 1][j]);
					}
				}

//				System.out.println("dp" + "[" + i + "]" + "[" + j + "]" + dp[i][j]);
			}
		}
		maxValue = dp[N][capacity];
		int m = N;
		int n = capacity;
		int all = dp[m][n];
		// 寻找哪些物品放入背包
		while (all >= 0) {
			if (m > 0 && dp[m][n] == dp[m - 1][n]) {
				m = m - 1;

			} else {
				list.add(arr[m][0]);
				// System.out.println(arr[m]+"加入背包");
				m = m - 1;
				if (m == 0) {
					return 0;
				} else {
					n = n - arr[m][0];
					all = all - arr[m][1];
				}
			}
		}
		return all;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
//		char[] ac = a.toCharArray();
		String[] aa = a.split(" ");
		int N = Integer.valueOf(aa[0]);
		int C = Integer.valueOf(aa[1]);
		System.out.println(N);
		System.out.println(C);
		int[][] arr = new int[N][2];
		int i = 0;
		while (sc.hasNextLine()) {
			a = sc.nextLine();
			aa = a.split("");
			int w = Integer.valueOf(aa[0]);
			int v = Integer.valueOf(aa[1]);
			arr[i][0] = w;
			arr[i][1] = v;
			i ++;
		}
		Knapsack.bag(arr, C);
		System.out.println(Knapsack.maxValue);
		for (Integer ele : list) {
			System.out.print(ele + ' ');
		}
	}
}