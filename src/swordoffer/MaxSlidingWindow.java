package swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
	// [滑动窗口的最大值](https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (size == 0 || size > num.length)  return res;
        for (int i = 0; i < size; i ++) {
            pq.offer(num[i]);
        }
        for (int i = size; i < num.length; i++) {
            res.add(pq.peek()); //注意peek 是取最大元素但是不删除，poll是取最大元素但是删除
            pq.remove(num[i-size]); //使用remove 删除窗口最左边元素，而不是 poll, poll　删除的不一定是窗口最左边元素
            pq.offer(num[i]);
        }
        res.add(pq.peek());
        return res;
    }
}
