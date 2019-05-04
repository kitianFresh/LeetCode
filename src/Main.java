import java.util.Scanner;

public class Main {
    public static int solutions(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 3;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i-1] + dp[i-2] + 1;
        }
        return dp[n]+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solutions(n));
    }
}