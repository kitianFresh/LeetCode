package array;

public class Colors {
	// 75. Sort Colors
	// 法3 合并两个循环
	public void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors3(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int twos = n - 1;
        for (int i = 0; i <= twos; i++) {
            while(nums[i] == 2 && i < twos) swap(nums, i, twos--); //循环,因为如果两个都是2,那么交换无效,应该和前一个继续交换,直到换一个不为2的
            while (nums[i] == 0 && i > zeros) swap(nums, i, zeros++);
        }
        
    }
	
    // 法二
	public int transferToEnd(int[] nums, int n, int color) {
		int i, j;
		i = 0;
		j = n;
		while (i < j) {
			while (j >= 0 && nums[j] == color) {
				j--;
			}
			while (i <= n && nums[i] != color) {
				i++;
			}
			if (i < j) {
				nums[i] = nums[j];
				nums[j] = color;
			}
		}
		return j;
	}

	public void sortColors(int[] nums) {
		int n;
		n = nums.length;
		int k = transferToEnd(nums, n - 1, 2);
		transferToEnd(nums, k, 1);

	}

	public void sortColors1(int[] nums) {
		int i, j, n;
		n = nums.length;
		i = 0;
		j = n - 1;
		while (i < j) {
			while (j >= 0 && nums[j] == 2) {
				j--;
			}
			while (i < n && nums[i] != 2) {
				i++;
			}
			if (i < j) {
				nums[i] = nums[j];
				nums[j] = 2;
			}
		}

		i = 0;
		n = j + 1;
		while (i < j) {
			while (j >= 0 && nums[j] == 1) {
				j--;
			}
			while (i < n && nums[i] != 1) {
				i++;
			}
			if (i < j) {
				nums[i] = nums[j];
				nums[j] = 1;
			}
		}
	}
}
