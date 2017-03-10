package sort.comparebased;

public class InsertSort {
	public static void insertSort(int[] A) {
		int n = A.length;
		int i, j;
		for (i = 1; i < n; i++) {
			int key = A[i];
			j = i - 1;
		
			while (j >= 0 && A[j] > key) {
				A[j+1] = A[j];
				j --;
			}
			A[j+1] = key;
		}
	}
}
