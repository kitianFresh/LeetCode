import java.util.Scanner;

public class MaxCommonDivisor {

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {
            return maxCommonDivisor(n, m);
        }
        while (m % n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return n;
    }

    public static int minCommonMultiple(int m, int n) {
        return m * n / maxCommonDivisor(m, n);
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 1;
        for (int i = 1; i <= n; i ++){
            a = minCommonMultiple(a,i);
            System.out.println(a);
        }
        int b = a;
        int m = n + 1;
        b = minCommonMultiple(b, m);
        System.out.println(b);
        a = m;
        while (b != a) {
            m ++;
            b = minCommonMultiple(b, m);
            a = minCommonMultiple(a, m);
            System.out.println(b);
        }
        System.out.println(m);
    }

    

}