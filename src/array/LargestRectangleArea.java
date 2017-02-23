package array;

import java.util.Scanner;

class SegmentTree {
	int[] st = null;
	int n;
	SegmentTree(int arr[], int n)
    {
        // Allocate memory for segment tree, index 0 not used
        st = new int[2*n]; // Memory allocation 2 * n
        this.n = n;
        // build segment tree
        for (int i=0;i<n;i++) {
        	st[n+i] = arr[i];
        }// 赋值叶节点
        for (int i=n-1;i>0;i--) {
        	st[i] = st[i<<1] + st[i<<1|1];
        }// 内部节点， 取左右节点的和
        
    }
	public int querySum(int l, int r) {
		int sum = 0;
		for (l+=n,r+=n;l<r;l>>=1,r>>=1) {
			if ((l&1) == 1) sum += st[l++]; // l 为奇数说明他是右子节点，需要先加上，再往后移动到后一个数；为偶数则直接往父节点走即可；
			if ((r&1) == 1) sum += st[--r]; // r 为奇数说明是右节点，因为 [l,r) 默认左闭右开，因此先减去再加上前一个；
		}
		return sum;
	}
	
	public void modify(int p, int value) {
		p += n;
		st[p] = value;
		for (p>>=1;p>0;p>>=1) {
			st[p] = st[p<<1] + st[p<<1|1];
		}
	}
	
	public void print() {
		for (int i=1; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
	}
	
	public void printArray(int[] arr) {
		for (int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

class SegmentTreeRMQ {
	int[] st = null;
	int n;
	SegmentTreeRMQ(int arr[], int n)
    {
        // Allocate memory for segment tree, index 0 not used
        st = new int[2*n]; // Memory allocation 2 * n
        this.n = n;
        // build segment tree
        for (int i=0;i<n;i++) {
        	st[n+i] = arr[i];
        }// 赋值叶节点
        for (int i=n-1;i>0;i--) {
        	st[i] = st[i<<1]>st[i<<1|1]?st[i<<1|1]:st[i<<1];
        }// 内部节点, 取左右节点的较小者
        
    }
	public int queryMin(int l, int r) {
		int sum = 0;
		for (l+=n,r+=n;l<r;l>>=1,r>>=1) {
			if ((l&1) == 1) sum += st[l++]; // l 为奇数说明他是右子节点，需要先加上，再往后移动到后一个数；为偶数则直接往父节点走即可；
			if ((r&1) == 1) sum += st[--r]; // r 为奇数说明是右节点，因为 [l,r) 默认左闭右开，因此先减去再加上前一个；
		}
		return sum;
	}
	
	public void modify(int p, int value) {
		p += n;
		st[p] = value;
		for (p>>=1;p>0;p>>=1) {
			st[p] = st[p<<1] + st[p<<1|1];
		}
	}
	
	public void print() {
		for (int i=1; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
	}
	
	public void printArray(int[] arr) {
		for (int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
public class LargestRectangleArea {
	public static void main(String[] args) {
		int[] heights = {9,8,7,6,5,4,3,2,1};
		LargestRectangleArea LRA = new LargestRectangleArea();
		long start, end;
		start = System.currentTimeMillis();
		System.out.println(LRA.largestRectangleArea(heights,0,8));
		end = System.currentTimeMillis();
		System.out.println(end-start);
		SegmentTree st = new SegmentTree(heights, heights.length);
		st.print();
//		st.modify(1, 777);
		st.print();
		System.out.println(st.querySum(0, 3));
	}

	public int max(int a, int b, int c) {
		return (a>b)?(a>c?a:c):(b>c?b:c);
	}
	// 分治法，Divide-and-Conquer
	public int largestRectangleArea(int[] heights, int l, int r) {
		if (heights == null) return 0;
		if (l==r) return heights[l];
		if (l > r) return 0;
		// 找出最小的 height；
		int minHeight = Integer.MAX_VALUE;
		int i, minIndex = l;
		for (i=l;i<=r;i++) {
			if (heights[i] < minHeight) {
				minHeight = heights[i];
				minIndex = i;
			}
		}
		// 最大面积分三种情况，1. 在左边部分； 2. 在右边部分； 3. 当前最小值 * length;
		return max(largestRectangleArea(heights, l, minIndex-1), largestRectangleArea(heights, minIndex+1, r), heights[minIndex] * (r-l+1));
	}
	
	public int largestRectangleArea2(int[] heights) {
		if (heights == null) return 0;
		int maxArea = 0;
		int i,j,height=0,sum=0;
		for (i=0;i<heights.length;i++) {
			height = heights[i];
			// 直接排除掉比上一次开始的高度小的，因为已经比较过一次了，这一次如果比上一次小，那么必定至少比上一次少1，直接排除
			for (;height>=(i==0?1:heights[i-1]);height--) {
				sum = height;
				for (j=i+1;j<heights.length;j++) {
					if (heights[j] >= height) {
						sum += height;
					}
					else {
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
        if (heights == null) return 0;
        
        int maxArea = 0;
        int i,j,height,sum=0;
        for (i=0; i<heights.length; i++) {
            // 第一个,以他最高的高度开始往下降低 
            height = heights[i];
            for (;height>=1;height--) {
                sum = height;
                // 后续的如果一直递增，那么就可以以第一个为高，累加起来；如果遇到低的，那么就需要跳出来；
                for (j=i+1; j<heights.length;j++) {
                    if (heights[j] >= height) {
                        sum += height;
                    }
                    else {
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
