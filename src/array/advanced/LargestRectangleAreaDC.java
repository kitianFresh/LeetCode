package array.advanced;

import java.util.Random;

public class LargestRectangleAreaDC {
	public static void main(String[] args) {
		int[] heights = new int[2000];
		Random r = new Random();
		for (int i = 0; i < 2000; i++) {
			heights[i] = i;
		}
		LargestRectangleAreaDC LRA = new LargestRectangleAreaDC();

//		heights = new int[]{6, 2, 5, 4, 5, 1, 6};
		heights = new int[]{2,1,5,6,2,3};
		SegmentTreeRMQ strmq = new SegmentTreeRMQ(heights, heights.length);
		strmq.print();
		System.out.println("NonOptimal-DC-MaxArea: " + LRA.largestRectangleAreaNo(heights, 0, heights.length - 1));
		System.out.println(
				"SortedOptimal-DC-MaxArea : " + LRA.largestRectangleAreaSorted(heights, 0, heights.length - 1));
		System.out.println("sorted optimal version: " + LRA.largestRectangleArea(heights));
	}
	
	public int largestRectangleArea(int[] heights) {
		if (heights == null) return 0;
//		return largestRectangleAreaNo(heights, 0, heights.length-1);
		return largestRectangleAreaSorted(heights, 0, heights.length-1);
	}
	public int max(int a, int b, int c) {
		return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
	}

	// 分治法，Divide-and-Conquer, 但是采用 O(n) 时间复杂度查询分界点 即 T(n) = T(n-m) + T(m) +
	// O(n)；该种方法是非均匀分治，左右两边不对等
	// 缺点是左右区间是不稳定的，和快速排序一样，二叉树可能会退化成一维线性的；
	public int largestRectangleAreaNo(int[] heights, int l, int r) {
		if (heights == null)
			return 0;
		if (l == r)
			return heights[l];
		if (l > r)
			return 0;
		// 找出最小的 height；
		int minHeight = Integer.MAX_VALUE;
		int i, minIndex = l;
		for (i = l; i <= r; i++) {
			if (heights[i] < minHeight) {
				minHeight = heights[i];
				minIndex = i;
			}
		}
		// 最大面积分三种情况，1. 在左边部分； 2. 在右边部分； 3. 当前最小值 * length;
		return max(largestRectangleAreaNo(heights, l, minIndex - 1), largestRectangleAreaNo(heights, minIndex + 1, r),
				heights[minIndex] * (r - l + 1));
	}

	public boolean checkSorted(int[] heights, int l, int r) {
		if (heights == null)
			return true;
		if (heights.length == 1)
			return true;
		int i;
		boolean sorted = true;
		for (i = l; i < r; i++) {
			if (heights[i] < heights[i + 1])
				continue;
			else {
				sorted = false;
				break;
			}
		}
		if (sorted)
			return true;
		sorted = true;
		for (i = l; i < r; i++) {
			if (heights[i] > heights[i + 1])
				continue;
			else {
				sorted = false;
			}
		}
		if (sorted)
			return true;
		return false;
	}

	public int largestRectangleAreaSorted(int[] heights, int l, int r) {
		if (heights == null)
			return 0;
		if (l == r)
			return heights[l];
		if (l > r)
			return 0;
		// 找出最小的 height；
		int minHeight = Integer.MAX_VALUE;
		int i, minIndex = l;
		for (i = l; i <= r; i++) {
			if (heights[i] < minHeight) {
				minHeight = heights[i];
				minIndex = i;
			}
		}
		if (checkSorted(heights, l, r)) {
			return heights[(l + r) / 2 + 1] * ((r - l) / 2 + 1);
		}

		// 最大面积分三种情况，1. 在左边部分； 2. 在右边部分； 3. 当前最小值 * length;
		return max(largestRectangleAreaSorted(heights, l, minIndex - 1),
				largestRectangleAreaSorted(heights, minIndex + 1, r), heights[minIndex] * (r - l + 1));
	}

}
