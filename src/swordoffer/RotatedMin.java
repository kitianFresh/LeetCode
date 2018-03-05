package swordoffer;

public class RotatedMin {
	public int minNumberInRotateArray(int [] array) {
        if (array.length == 1) return array[0];
        int low = 0;
        int high = array.length - 1;
        int mid = high;
        while (array[low] >= array[high]) {
            mid = (low + high) / 2;
            if (high - low == 1) return array[high];
            if (array[mid] == array[high] && array[mid] == array[low]) {
                return minOrder(array, low, high);
            }
            if (array[mid] >= array[high]) {
                low = mid;
            }
            else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }
    public int minOrder(int[] array, int low, int high) {
        int min = array[low];
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
