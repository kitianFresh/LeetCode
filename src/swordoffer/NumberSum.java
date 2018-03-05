package swordoffer;

import java.util.ArrayList;

public class NumberSum {
	// [和为S的两个数字](https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int a, b, min;
		int i, j;
		int n = array.length;
		ArrayList<Integer> res = new ArrayList<Integer>();
		i = 0;
		j = n - 1;
		min = Integer.MAX_VALUE;
		while (i < j) {
			if (array[i] + array[j] > sum)
				j--;
			else if (array[i] + array[j] < sum)
				i++;
			else {
				if (array[i] * array[j] < min) {
					res.clear();
					a = Math.min(array[i], array[j]);
					b = Math.max(array[i], array[j]);
					min = a * b;
					res.add(a);
					res.add(b);
				}
				i++;
				j--;
			}
		}
		return res;
	}

	// [和为S的连续正数序列](https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		int small = 1;
		int big = 2;
		int bound = sum / 2 + 1;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		while (big <= bound) {
			int s = (small + big) * (big - small + 1) / 2;
			if (s < sum) {
				big++;
			} else if (s > sum) {
				small++;
			} else {
				ArrayList<Integer> seq = new ArrayList<Integer>();
				for (int i = small; i <= big; i++)
					seq.add(i);
				res.add(seq);
				big++;
			}
		}
		return res;
	}
}
