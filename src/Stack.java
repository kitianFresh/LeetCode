import java.util.*;

public class Stack {
    public int getHeight(int[][] actors, int n) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                }
                else if (a[0] > b[0]) {
                    return 1;
                }
                else {
                    if (a[1] < b[1]) return -1;
                    else if (a[1] > b[1]) return 1;
                    else return 0;
                }
            }
        };
        Arrays.sort(actors, cmp);
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i ++) {
            int t = 0;
            for (int j = 0; j < i; j ++) {
                if (actors[i][1] > actors[j][1]) {
                    t = Math.max(t, dp[j]);
                }
            }
            dp[i] = t+1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

