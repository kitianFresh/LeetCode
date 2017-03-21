package array.advanced;

import java.util.Random;
import java.util.Stack;

public class LargestRectHist {
	public static void main(String[] args) {
		int[] heights = new int[2000];
		Random r = new Random();
		for (int i = 0; i < 2000; i++) {
			heights[i] = i;
		}
		LargestRectHist lrh = new LargestRectHist();
		heights = new int[]{6, 2, 5, 4, 5, 1, 6};
//		heights = new int[]{2,1,5,6,2,3};
		System.out.println(lrh.largestRectangleArea(heights));
		
	}
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) return 0;
		int cur, h, max = 0;
		int area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<height.length+1; i++) {
			cur = (i == height.length) ? -1 : height[i]; // 最后一个柱子的右端需要特殊处理，加入一个-1即可；
			while(!stack.isEmpty() && cur < height[stack.peek()]) {
				h = stack.pop();
				 // h 当前计算的柱子， i 是最右端，stack.peek() 是最左端， 对第一个柱子需要特殊处理，此时第一个柱子弹出之后，没有左端；
				area = height[h] * (stack.isEmpty()?i:(i - stack.peek() - 1));
				max = Math.max(max,  area);
			}
			stack.push(i);
		}
		return max;
	}
}
