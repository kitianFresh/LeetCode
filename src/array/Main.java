package array;

import java.util.Scanner;
public class Main {
    public static int minimalTimeSchedule(int[] tasks) {
        int n = tasks.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            tasks[i] = tasks[i] / 1024;
            sum += tasks[i];
        }
        int[][] dp = new int[n+1][sum/2+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum/2 + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= tasks[i-1] && dp[i-1][j-tasks[i-1]]+tasks[i-1] > dp[i-1][j]) {
                    dp[i][j] = dp[i-1][j-tasks[i-1]]+tasks[i-1];
                }
                
            }
        }
        return Math.max(sum - dp[n][sum/2], dp[n][sum/2])  * 1024;
    }
    public static void main(String[] args) {
   		Scanner sin = new Scanner(System.in);
        int n, i=0;
        int[] tasks;
        n = sin.nextInt();
        tasks = new int[n];
        while (i < n) {
            tasks[i] = sin.nextInt();
            i ++;
        }
        System.out.println(Main.minimalTimeSchedule(tasks));
    }
}