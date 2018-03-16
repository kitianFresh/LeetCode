package swordoffer;

public class InversePairs {

	// [数组的逆序对](https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	// 法一，　暴力　O(n^2) 冒泡排序等于暴力
	public int InversePairs(int[] array) {
		int n = array.length;
		int pairs = 0;
		boolean ordered = false;
		for (int i = 1; i < n; i++) {
			if (ordered)
				return pairs;
			ordered = true;
			for (int j = 0; j < n - 1; j++) {
				if (array[j] > array[j + 1]) {
					pairs++;
					swap(array, j, j + 1);
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
	
	// 法二，归并排序的变种，　子问题，左边的逆序数＋右边的逆序数＋交叉的逆序数
	public int InversePairs1(int [] array) {
        if (array == null || array.length <= 1) return 0;
        int[] aux = new int[array.length];
        int res = inversePairs(array, aux, 0, array.length - 1)%1000000007;
        return res;
    }
 
    public int inversePairs(int[] nums, int[] aux, int l, int r) {
        if (l == r) return 0;
        int m = (l + r) / 2;
        int left = inversePairs(nums, aux, l, m)%1000000007;
        int right = inversePairs(nums, aux, m+1, r)%1000000007;
        for (int index = l; index <= r; index ++) {
            aux[index] = nums[index];
        }
        int cross = 0;
        int i = l;
        int j = m + 1;
        int k = l;
        int nlower = 0;
        while (i <= m || j <= r) {
            if (i == m + 1) break;
            if (j == r + 1) break;
            if (aux[i] <= aux[j]) {
                nums[k++] = aux[i++];
                cross += nlower;
                if (cross >= 1000000007) {
                    cross %= 1000000007;
                }
            }
            else {
                nlower ++;
                nums[k++] = aux[j++];
            }
        }
        if (i < m + 1 && j == r + 1) {
            while (i <= m) {
                nums[k++] = aux[i++];
                cross += nlower;
                if (cross >= 1000000007) {
                    cross %= 1000000007;
                }
            }
        }
        if (j < r + 1 && i == m + 1) {
            while (j <= r) {
                nums[k++] = aux[j++];
            }
        }
 
         
        return (cross + left + right)%1000000007;
    }
	
	
}
