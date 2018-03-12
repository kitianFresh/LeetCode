package swordoffer;

public class InversePairs {
	 public int InversePairs(int [] array) {
	        int n = array.length;
	        int pairs = 0;
	        boolean ordered = false;
	        for(int i = 1; i < n; i++) {
	            if (ordered) return pairs;
	            ordered = true;
	            for (int j = 0; j < n - 1; j ++) {
	                if (array[j] > array[j+1]) {
	                    pairs ++;
	                    swap(array, j, j+1);
	                    ordered = false;
	                }
	            }
	        }
	        return pairs % 1000000007;
	    }
	    public void swap(int[] array, int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
}
