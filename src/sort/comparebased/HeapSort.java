package sort.comparebased;

import sort.Util;

public class HeapSort {
	
	// bottom up; 堆是完全二叉树，因此下标从 0 开始的数组 父节点 i 的左右孩子分别为 2*i+1,2*i+2; 
	// 并且如果存在孩子节点，只可能是左孩子或左右孩子，不可能只含右孩子
	public static void maxHeapify(int[] A, int start, int end) {
		int left = 2 * start + 1;
		int right = 2 * start + 2;
		int max;
		if (left <= end && A[left] > A[start]) {
			max = left;
		}
		else {
			max = start;
		}
		if (right <= end && A[right] > A[max]) {
			max = right;
		}
		if (max != start) {
			swap(A, start, max);
			maxHeapify(A, max, end);
		}
	}
	// 循环多余了, 因为调整一个父节点只可能影响一条分支! 递归下降只是在一条路径上, 即最大是树的深度.
	public static void maxHeapify1(int[] A, int start, int end) {
		if (start >= end) return ;
		for (int i = (end-1)/2; i >= start; i--) {
			int left = 2 * i + 1;
			int right = left + 1;
			if (right <= end) {
				int max = A[left] > A[right] ? left : right;
				if (A[left] > A[i] || A[right] > A[i]) {
					swap(A, max, i);
					maxHeapify1(A, max, end);
				}
			}
			if (left <= end && right > end) {
				if (A[left] > A[i]) {
					swap(A, left, i);
					maxHeapify1(A, left, end);
				}
			}
		}
	}
	
	// 初始化一个堆也是采用自底向上的方式。从每一个有孩子的父节点开始最大堆化
	public static void initHeap(int[] A, int start, int end) {
		for (int i = (end-1)/2; i >= start; i--) {
			maxHeapify(A, i, end);
		}
	}
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void heapSort(int[] A, int start, int end) {
		initHeap(A, start, end);
		for (int i = end; i > start; i--) {
			swap(A, i, start);
			maxHeapify(A, start, i-1);
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{4,1,3,0,9,2,6,8,7,5};
		Util.display(A);
		heapSort(A, 0, A.length-1);
		Util.display(A);
		
		A = new int[]{9,8,7,6,5,4,3,2,1,0};
		Util.display(A);
		heapSort(A, 0, A.length-1);
		Util.display(A);
	}
}
