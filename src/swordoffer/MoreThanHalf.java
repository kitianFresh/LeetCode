package swordoffer;

public class MoreThanHalf {
	
	// [数组中出现次数超过一半的数字](https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return -1;
        int count = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i ++) {
            if (array[i] == result) {
                count ++;
            }
            else {
                count --;
                if (count == 0) {
                    count = 1;
                    result = array[i];
                }
            }
        }
        if (checkMoreThanHalf(array, result)) {
            return result;
        }
        else {
            return 0;
        }
    }
    
    public boolean checkMoreThanHalf(int[] nums, int result) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                count ++;
            }
        }
        return 2 * count <= nums.length ? false : true;
    }
}
