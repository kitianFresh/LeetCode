import java.util.Scanner;
import java.util.HashMap;
public class Fib {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int fib(int k) {
        if (k <= 2) return 1;
        int a, b;
        a = 1;
        b = 1;
        int temp;
        for (int i = 3; i <= k; i ++) {
            temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }
    public static void main(String[] args) {
        Fib m = new Fib();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (sc.hasNext()) {
            int k = sc.nextInt();
            int res;
            //if (m.cache.containsKey(k)) res = m.cache.get(k);
            //else {
            //    res = m.fib(k);
            //}
            res = m.fib(k);
            System.out.println(res);
        }
    }
}