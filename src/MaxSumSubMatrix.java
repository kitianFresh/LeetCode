import java.util.*;

public class MaxSumSubMatrix{
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i ++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static int maxSubMatrix(int[][] matrix, int n) {
        int[] aux = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            for (int pos = 0; pos < n; pos ++) {
                aux[pos] = 0;
            }
            for (int j = i; j < n; j ++) {
                for (int k = 0; k < n; k ++) {
                    aux[k] += matrix[j][k];
                }
                max = Math.max(maxSubArray(aux), max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        int row = 0;
        int col = 0;
        while(sc.hasNextInt()) {
            col = 0;
            while (col < N){
                matrix[row][col] = sc.nextInt();
                col ++;
            }
            row ++;
        }
        System.out.println(maxSubMatrix(matrix, N));
    }
}