package math;

import java.util.HashSet;

public class HappyNumber {
	// [202. Happy Number](https://leetcode.com/problems/happy-number/description/)
	public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                int r = n % 10;
                n = n / 10;
                sum += r * r;
            }
            if (set.contains(sum)) return false;
            if (sum == 1) return true;
            set.add(sum);
            n = sum;
        }
    }
	
	// 借鉴链表找环的思路,如果有环儿的话, 快慢指针肯定会相遇. space O(1)
	int digitSquareSum(int n) {
	    int sum = 0, tmp;
	    while (n != 0) {
	        tmp = n % 10;
	        sum += tmp * tmp;
	        n /= 10;
	    }
	    return sum;
	}

	boolean isHappy1(int n) {
	    int slow, fast;
	    slow = fast = n;
	    do {
	        slow = digitSquareSum(slow);
	        fast = digitSquareSum(fast);
	        fast = digitSquareSum(fast);
	    } while(slow != fast);
	    if (slow == 1) return true;
	    else return false;
	}
}
