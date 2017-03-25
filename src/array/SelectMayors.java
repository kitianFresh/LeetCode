package array;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectMayors {
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int cases = cin.nextInt();
        while (cases-- > 0) {
            int n = cin.nextInt();
            int r = cin.nextInt();
            int[][] g = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    g[i][j] = 0;
                }
            } // init
//            System.out.println("n: " + n);
//            System.out.println("r: " + r);
            while (r-- > 0) {
                int i = cin.nextInt() - 1;
                int j = cin.nextInt() - 1;
                if (i != j) g[i][j] = 1;
            }
            int mayor = selectMayorsOpt(g, n);

            System.out.println(mayor == -1 ? 0 : 1);
            System.out.println(mayor == -1 ? "": mayor);
        }
    }
    
    public static List<Integer> selectMayors(int[][] g, int n) {
        // 统计出度,认识人的
        int[] out = new int[n];
        // 统计入度，被谁认识
        int[] in = new int[n];
        for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
            	out[i] += g[i][j];
                in[i] += g[j][i];
            }
        }
        
        List<Integer> mayors = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            if (in[i] == (n-1) && out[i] == 0) {
                mayors.add(i+1);
//                System.out.println(i+1);
            }
        }
        return mayors;
    }
    
    public static int selectMayors1(int[][] g, int n) {
        // 统计出度,认识的人
        int[] out = new int[n];
        // 统计入度，被谁认识
        int[] in = new int[n];
        for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
            	out[i] += g[i][j];
                in[i] += g[j][i];
            }
        }
      
        for (int i=0; i<n; i++) {
            if (in[i] == (n-1) && out[i] == 0) {
//            	System.out.println("select: " + (i-1));
                return i+1;
            }
        }
        return -1;
    }
    
    public static int selectMayorsOpt(int[][] g, int n) {
    	int out = 0;
    	int in = 0;
    	for (int i=0;i<n;i++) {
    		
			for (int j=0;j<n;j++) {
            	out += g[i][j];
                in += g[j][i];
            }
			if (in == n-1 && out == 0) {
				return i + 1;
			}
			in = out = 0;
        }
      
        return -1;
    }
    // 前面几个空间都特别大，10^5 * 10^5 而存储出入度只要　10^5 *2 ;因为很多边都是没有的，所以不需要，直接计算出度入度即可，在数据输入的时候及可以统计．
    public static void selectMayor() {
        Scanner cin = new Scanner(System.in);
        int cases = cin.nextInt();
        while (cases-- > 0) {
            int n = cin.nextInt();
            int r = cin.nextInt();
            int[] out = new int[n];
            int[] in = new int[n];
            
            while (r-- > 0) {
                int i = cin.nextInt() - 1;
                int j = cin.nextInt() - 1;
                if (i != j) {
                    out[i] += 1;
                    in[j] += 1;
                }
            }
            int mayor = -1;
			for (int i = 0; i < n; i++) {
                if (in[i] == n-1 && out[i] == 0) {
                    mayor = i+1;
                    break;
                }
            }
            System.out.println(mayor == -1 ? 0 : 1);
            System.out.println(mayor == -1 ? "": mayor);
        }
    }
}
