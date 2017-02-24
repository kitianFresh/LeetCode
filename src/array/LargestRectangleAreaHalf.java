package array;

import java.util.Random;

public class LargestRectangleAreaHalf {
	public static void main(String[] args) {
		int[] heights = new int[2000];
		Random r = new Random();
		for (int i = 0; i < 2000; i++) {
			heights[i] = i;
		}
		LargestRectangleAreaDC LRA = new LargestRectangleAreaDC();

		heights = new int[]{6, 2, 5, 4, 5, 1, 6};
		SegmentTreeRMQ strmq = new SegmentTreeRMQ(heights, heights.length);
		strmq.print();
	
		System.out.println("half-dc version: " + LRA.largestRectangleArea(heights));
	}
	public int largestRectangleArea(int[] heights) {
		if (heights == null) return 0;
		return largestRectangleAreaHalf(heights, 0, heights.length-1);
	}
	public int min(int a, int b) {
		return a > b ? b : a;
	}
	public int max(int a, int b, int c) {
		return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
	}
	// 分治法； 二分； T(n) = 2*T(n/2) + O(n); 和归并排序一样，复杂度恒定在 O(n*lgn)
	public int largestRectangleAreaHalf(int[] heights, int l, int r) {
		if (heights == null)
			return 0;
		if (l == r)
			return heights[l];
		if (l > r)
			return 0;
		// 均匀分摊，(l-r)/2; 最大面积三种： 1. 左半部分； 2. 右半部分； 3. 包含中间值(两个mid 和
		// mid+1)（但是最终的高度不一定是中间值，最终高度以最低的为准），左右展开到某端点的部分；即计算中间部分需要耗时O(n);
		int mid, area = 0, height;
		int i, j;

		mid = (l + r) / 2;
		i = mid;
		j = mid + 1;
		height = min(heights[i], heights[j]);
		while (i >= l && j <= r) {
			height = min(height, min(heights[i], heights[j]));
			if ((j - i + 1) * height > area) {
				area = (j - i + 1) * height;
			}
			
			if (i == l) {
				++j;
			} else if (j == r) {
				--i;
			} else {
				// if both sides have not reached the boundary,
				// compare the outer bars and expand towards the bigger side
				if (heights[i - 1] > heights[j + 1]) {
					--i;
				} else {
					++j;
				}
			}
		}

		return max(largestRectangleAreaHalf(heights, l, mid), largestRectangleAreaHalf(heights, mid + 1, r), area);

	}
}
