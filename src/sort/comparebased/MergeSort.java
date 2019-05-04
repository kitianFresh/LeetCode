package sort.comparebased;

public class MergeSort {
	
	public static void merge(int[] A, int start, int mid, int end) {
		int i,j,k;
		i = j = k = 0;
		int[] a = new int[mid-start+2];
		int[] b = new int[end-mid+1];
		
		for (i = 0; i < a.length -1; i++) {
			a[i] = A[i+start];
		}
		a[i] = Integer.MAX_VALUE;
		for (i = 0; i < b.length -1; i++) {
			b[i] = A[i+mid+1];
		}
		b[i] = Integer.MAX_VALUE; 
		while (i < a.length - 1 || j < b.length - 1) {
			
			if (a[i] <= a[j]) {
				A[k++] = a[i++];
			}
			else {
				A[k++] = a[j++];
			}
		}
	}
	
	public static void mergeSort(int[] A, int start, int end) {
		if (start < end) {
			int mid = (start+end)/2;
			
			mergeSort(A, start, mid);
			mergeSort(A, mid+1, end);
			merge(A, start, mid, end);
		}
	}
}
