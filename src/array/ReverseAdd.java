package array;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseAdd {
	public static void main(String[] args) {
		char c;
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
        String[] ss = temp.split(",");
        int a = Integer.valueOf(ss[0]);
        int b = Integer.valueOf(ss[1]);
//        String ans = reverseAdd(a, b);
		System.out.println(reverseAdd1(a, b));
	}
    
    public static LinkedList<Integer> getNum(int num) {
		LinkedList<Integer> nums = new LinkedList<Integer>();
		for (;num != 0;) {
			nums.add(num%10);
			num /= 10;
		}
		return nums;
	}

	
	public static int reverseAdd1(int a, int b) {
		int r;
		int newA, newB;
		newA = 0;
		newB = 0;
		while (a!=0) {
			r = a%10;
			newA = newA*10 + r;
			a = a / 10;
		}
		System.out.println(newA);
		while (b!=0) {
			r = b%10;
			newB = newB*10 + r;
			b = b / 10;
		}
		System.out.println(newB);
		return newA+newB;
	}
}
