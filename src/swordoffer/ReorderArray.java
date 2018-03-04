package swordoffer;

public class ReorderArray {
	// [调整数组顺序，奇数在前偶数在后](https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	// 不稳定的交换, 基于快速排序的方法，是不稳定的
	public void reOrderArray(int [] array) {
        if (array == null || array.length == 1) return;
        int length = array.length;
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            while (i < length && array[i] % 2 == 1) i ++;
            while (j >= 0 && array[j] % 2 == 0) j --;
            if (i < length && j >= 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i ++;
                j --;
            }
        }
        return;
    }
	
	// 基于插入或者冒泡排序的方法才是稳定的
	public void reOrderArray１(int [] array) {
        if (array == null || array.length == 1) return;
        int length = array.length;
        for (int i = 1; i < length; i ++) {
            for (int j = 0; j < length - i; j ++) {
                if (array[j] % 2 == 0 && array[j+1] % 2 == 1) {
                    swap(array, j, j+1);
                }
            }
        }
        return;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
