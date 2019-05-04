package dp;

public class JumpGame {
	// [55. Jump Game](https://leetcode.com/problems/jump-game/description/)
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length < 2) return true;
		int n = nums.length;
		int[] cans = new int[nums.length];
		cans[n-1] = 1;
		for (int k = n - 2; k >= 0; k --) {
			for (int i = 1; i <= nums[k] && k + i < n; i ++) {
				if (cans[k+i] == 1) {
					cans[k] = 1;
					break;
				}
			}
		}
		return cans[0] == 1;
	}
	
	public boolean canJump1(int[] nums) {
		if (nums == null || nums.length < 2) return true;
		int n = nums.length;
		int canIndex = n - 1;
		for (int k = n - 2; k >= 0; k --) {
			if (nums[k] > 0 && k + nums[k] >= canIndex) {
				canIndex = k;
			}
		}
		return canIndex == 0;
	}
	
}
