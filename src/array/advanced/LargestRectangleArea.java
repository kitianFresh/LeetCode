package array.advanced;

import java.util.Random;

class SegmentTreeRMQ {
	int[] st = null;
	int n;

	SegmentTreeRMQ(int arr[], int n) {
		// Allocate memory for segment tree, index 0 not used
		st = new int[2 * n]; // Memory allocation 2 * n
		this.n = n;
		// build segment tree
		for (int i = 0; i < n; i++) {
			st[n + i] = arr[i];
		} // 赋值叶节点
		for (int i = n - 1; i > 0; i--) {
			st[i] = st[i << 1] > st[i << 1 | 1] ? st[i << 1 | 1] : st[i << 1];
		} // 内部节点, 取左右节点的较小者

	}

	// [l, r)
	public int queryMin(int l, int r) {
		int min = Integer.MAX_VALUE;

		for (l += n, r += n; l < r && l > 0; l >>= 1, r >>= 1) {
			if ((l & 1) == 1) {
				if (min > st[l]) {
					min = st[l]; // l 为奇数说明他是右子节点，需要参与比较之后，再往前移动；
				}
				l++;
			}
			if ((r & 1) == 1) {
				r--;
				if (min > st[r]) {
					min = st[r]; // r 为奇数说明是右节点，而右端点是左节点，注意[),所以 st[r-1]
				}
			}
		}

		return min;
	}

	// 难点在于 l r 在往父节点走动的时候，已经不是原来数组的索引了，因此会出错！！
	// 左闭右开[l,r)
	public int queryMinIndex(int l, int r) {
		int min = Integer.MAX_VALUE;
		int index = l;

		for (l += n, r += n; l < r && l > 0; l >>= 1, r >>= 1) {
			if ((l & 1) == 1) {
				if (min > st[l])
					min = st[index = l];
				l++; // l
						// 为奇数说明他是右子节点，区间左端点为树的右节点，而且包含，因此需要参与比较之后，再往前移动一个元素；最后再直接找父亲(因为左端点往右的部分是包含的)；
			}
			if ((r & 1) == 1) {
				r--;
				if (min > st[r])
					min = st[index = r];
			} /// r 为奇数说明是右节点，即区间右端点是树中左节点，注意[),所以 先 移动到正确的位置，再比较；
		}
		// System.out.println("min: " + min);
		// System.out.println("index: " + index);
		// 再使用 index 查找一次，抵达叶子节点即可。此时按照树状结构应该是 lg(n)
		for (; 2 * index < 2 * n;) {
			index = (st[index] == st[index * 2]) ? (2 * index) : (2 * index + 1);
		}

		return index - n;
	}

	public void modify(int p, int value) {
		p += n;
		st[p] = value;
		for (p >>= 1; p > 0; p >>= 1) {
			st[p] = st[p << 1] > st[p << 1 | 1] ? st[p << 1 | 1] : st[p << 1];
		}
	}

	public void print() {
		for (int i = 1; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
	}
}

public class LargestRectangleArea {
	public static void main(String[] args) {
		int[] heights = new int[2000];
		Random r = new Random();
		for (int i = 0; i < 2000; i++) {
			heights[i] = i;
		}
		LargestRectangleArea LRA = new LargestRectangleArea();

//		heights = new int[]{6, 2, 5, 4, 5, 1, 6};
		SegmentTreeRMQ strmq = new SegmentTreeRMQ(heights, heights.length);
		strmq.print();
		System.out.println("query min: " + strmq.queryMin(1, 4));
		System.out.println("query minIndex: " + strmq.queryMinIndex(1, 4));
		System.out.println("RMQ-MaxArea: " + LRA.largestRectangleArea(heights));
	}

	public int max(int a, int b, int c) {
		return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
	}

	// 分治法，Divide-and-Conquer， 注意区间是左闭右开,
	// 该分治法的缺点是左右区间是不稳定的，和快速排序一样，二叉树可能会退化成一维线性的；
	public int largestRectangle(SegmentTreeRMQ strmq, int l, int r) {
		if (l >= r)
			return 0;
		if (l == r - 1)
			return strmq.st[strmq.n + l];
		// 找出最小的 height；
		int minIndex = strmq.queryMinIndex(l, r);
		System.out.println("minIndex: " + minIndex);
		// 最大面积分三种情况，1. 在左边部分； 2. 在右边部分； 3. 当前最小值 * length;
		return max(largestRectangle(strmq, l, minIndex), largestRectangle(strmq, minIndex + 1, r),
				strmq.st[minIndex + strmq.n] * (r - l));
	}

	public int largestRectangleArea(int[] heights) {
		if (heights == null)
			return 0;
		if (heights.length == 1)
			return heights[0];
		SegmentTreeRMQ strmq = new SegmentTreeRMQ(heights, heights.length);
		return largestRectangle(strmq, 0, heights.length);
	}

	public int largestRectangleArea2(int[] heights) {
		if (heights == null)
			return 0;
		int maxArea = 0;
		int i, j, height = 0, sum = 0;
		for (i = 0; i < heights.length; i++) {
			height = heights[i];
			// 直接排除掉比上一次开始的高度小的，因为已经比较过一次了，这一次如果比上一次小，那么必定至少比上一次少1，直接排除
			for (; height >= (i == 0 ? 1 : heights[i - 1]); height--) {
				sum = height;
				for (j = i + 1; j < heights.length; j++) {
					if (heights[j] >= height) {
						sum += height;
					} else {
						break;
					}
				}

				if (sum > maxArea) {
					maxArea = sum;
				}
			}
		}
		return maxArea;
	}

	public int largestRectangleArea1(int[] heights) {
		if (heights == null)
			return 0;

		int maxArea = 0;
		int i, j, height, sum = 0;
		for (i = 0; i < heights.length; i++) {
			// 第一个,以他最高的高度开始往下降低
			height = heights[i];
			for (; height >= 1; height--) {
				sum = height;
				// 后续的如果一直递增，那么就可以以第一个为高，累加起来；如果遇到低的，那么就需要跳出来；
				for (j = i + 1; j < heights.length; j++) {
					if (heights[j] >= height) {
						sum += height;
					} else {
						break;
					}
				}
				// 更换当前最大面积
				if (sum > maxArea) {
					maxArea = sum;
				}
			}
		}
		return maxArea;
	}
}
