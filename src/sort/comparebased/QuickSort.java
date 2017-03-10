package sort.comparebased;

import sort.Util;

public class QuickSort {

	public static void main(String[] args) {
		int[] A = new int[]{9,5,4,6,7,3,8,2,0,1};
//		A = new int[]{2,2,2,2,2,2,2,2,2};
		QuickSort.quickSort(A, 0, A.length-1);
		Util.display(A);
	}
	
	public static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p;
		int j = r;
		while (i < j) {
			while (i < j && A[i] < x) i ++;
			if (i < j) {
				A[j] = A[i];
				j --;
			}
			while (i < j && A[j] > x) j --;
			if (i < j) {
				A[i] = A[j];
				i ++;
			}
		}
		A[i] = x;
		System.out.println(i + ": " + A[i]);
		return i;
	}
	
	// 算法导论版本的partition，讲数组分为A[p...i]为比 x 小的部分， A[i+1...j]为比x大的部分，A[j+1...r-1]为待排序部分，A[r] 为选择的分区点
	// 循环不变式是初始化 i 为空，即 p-1. 从 j = p 开始比较到 j=r-1。i始终代表当前比x小的最后一个值，j代表当前比较对象。
	public static int partition1(int[] A, int p, int r) {
		int x = A[r];
		int temp;
		int i =  p - 1;
		int j = p;
		for (;j <= r-1; j++) {
			if (A[j] <= x) {
				i ++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		if (i+1 == r) return (p+r)/2;
		return i+1;
	}
	
	public static void quickSort(int[] A, int p, int r) {
		
		if (p < r) {
			int q = partition1(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
		
		return;
	}
}
