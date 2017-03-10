package sort.comparebased;

public class SelectSort {
	// a = a - b; b = a + b; a = b - a;
	// a = a ^ b; b = a ^ b; a = a ^ b;
	// 但是对于数组，如果交换的是同一个值，那么以上操作将会失效，该数会被修改！！！
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void selectSort(int[] A) {
		int n = A.length;
		int i, j, k, min;
		for (i = 0; i < n-1; i++) {
			min = A[i]; k = i;
			for (j = i + 1; j < n; j++) {
				if (A[j] < min) {
					k = j;
					min = A[j];
				}
			}
			swap(A, k, i);
		}
	}
}
