package array;

public class MaxDistanceArrays {
	//[624. Maximum Distance in Array](https://leetcode.com/articles/maximum-distance-in-array/)
	
	// 法一 brute force time O(n^2) Space O(1)
	// 每个数组看成一个区间 [l1 r1], [l2,r2]. 那么最大差值绝对值一定是 |r2-l1| 或者 |l2 - r1|
	public int maxDistance(int[][] list) {
		int ans = 0;
		for (int i = 0; i < list.length - 1; i ++) {
			for (int j = i + 1; j < list.length; j ++) {
				ans = Math.max(ans, Math.abs(list[i][0] - list[j][list[j].length -1]));
				ans = Math.max(ans, Math.abs(list[i][list[i].length -1] - list[j][0]));
			}
		}
		return ans;
	}
	
	// 法二 单遍扫描 Time O(n) Space O(1)
	// 由于最后总是min max 是到目前为止（除了一行a）的左端点最小值和右端点最大值，因为只有这样后续的公式
	// |max - a[0]| 或者 |a[n-1] - min| 才可能更大, 因此我们扫描的过程中记录 min max 即可
	public int maxDistance1(int[][] list) {
		int min = list[0][0];
		int max = list[0][list[0].length-1];
		int ans = 0;
		for (int i = 1; i < list.length; i ++) {
			ans = Math.max(ans, Math.abs(max - list[i][0]));
			ans = Math.max(ans, Math.abs(list[i][list[i].length-1] - min));
			max = Math.max(max, list[i][list[i].length - 1]);
			min = Math.min(min, list[i][0]);
		}
		return ans;
	}
}
