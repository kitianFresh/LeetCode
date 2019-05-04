package sort.comparebased;

public class ShellSort {
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void shellSort(int[] A, int increment) {
		int n = A.length;
		for (int k = increment; k>=1; k/=2) {
			// 按照间隔 increment 比较
			for (int i = 0; i < n - k; i++) {
				for (int j = i+k; j < n; j++) {
					if (A[i] > A[j]) {
						swap(A, i, j);
					}
				}
			}
		}
	}
}
