import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class MinWindow {
    public static void minWindow(int[] a, HashMap<Integer, Integer> map) {
        int len = a.length;
        int begin = 0;
        int end = begin;
        int cnt = 0;
        int total = map.size();
        int minLen = len + 1;
        int minBegin = 0, minEnd = 0;
        ArrayList<int[]> res = new ArrayList<int[]>();
        while (end < len) {
            int ch = a[end];
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch)>=0) {
                    cnt ++;
                }
            }
            while (cnt == total) {
                ch = a[begin];
                if (end - begin + 1 <= minLen) {
                    minBegin = begin;
                    minEnd = end;
                    minLen = end - begin + 1;
                    int[] temp = new int[3];
                    temp[0] = minLen;
                    temp[1] = minBegin;
                    temp[2] = minEnd;
                    res.add(temp);
                }
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch)+1);
                    if (map.get(ch) > 0){
                        cnt --;
                    }
                }
                begin ++;
            }
            end ++;
        }
        int sum = 0;
        for (int[] r : res) {
            if (r[0] == minLen) {
                sum ++;
            }
        }
        System.out.println(minLen + " " + sum);
        for (int[] r : res) {
            if (r[0] == minLen) {
                System.out.print("[" + (r[1]+1) + ", " + (r[2]+1) + "] ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        sc.nextLine();
        while (sc.hasNextLine()) {
        	if (i == 10) break;
            a[i] = sc.nextInt();
            map.put(a[i], 1);
            System.out.println(a[i]);
            i ++;
        }
        minWindow(a, map);
    }
}