import java.util.HashSet;
import java.util.Scanner;
//public class Main {
//    public static int leastAttacks(int hp, int normal, int buffed) {
//        if (hp == 0) return 0;
//        if (hp <= normal) return 1;
//        if (hp <= buffed) return 2;
//        int[] dp = new int[hp+1];
//        dp[0] = 0;
//        for (int i = 1; i <= normal; i ++) {
//            dp[i] = 1;
//        }
//        for (int i = normal+1; i <= buffed; i ++) {
//            dp[i] = 2;
//        }
//        for (int i = buffed+1; i <= hp; i ++) {
//            if (i - normal < 0 || i - buffed < 0) {
//            		dp[i] = 0;
//            }
//            else {
//                dp[i] = Math.min(dp[i-normal] + 1, dp[i-buffed] + 2);
//            }
//        }
//        return dp[hp];
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int hp = sc.nextInt();
//        int normal = sc.nextInt();
//        int buffed = sc.nextInt();
//        System.out.println(hp);
//        System.out.println(normal);
//        System.out.println(buffed);
//        System.out.println(Main.leastAttacks(hp, normal, buffed));
//    }
//}




import java.util.Scanner;
import java.util.HashMap;
public class Remainder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int r = a % b;
        int pos = 0;
        while (r != 0 ) {
            map.put(r, pos);
            pos ++;
            r = (r * 10) % b;
            if (map.containsKey(r)) {
                break;
            }
        }
        if (r == 0) {
            System.out.println(pos + " " + 0);
        }
        else {
            System.out.println(map.get(r) + " " + (pos - map.get(r)));
        }
    }
}