package array;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class InversionNumbers {
	//牛客网-特殊交换
	// O(n^2) brute-force
	public static int inversionNumbers(int[] nums) {
		int numbers = 0;
		for (int i=0; i<nums.length-1; i++) {
			for (int j=i;j<nums.length; j++) {
				if (nums[i] > nums[j]) {
					numbers++;
				}
			}
		}
		return numbers;
	}
	
	// 分治法，假设左半部分子问题和右半部分子问题的逆序数已经知道，加上 左右两个集合合起来的逆序数，由于左右部分都已经排序了，
	// 左右集合合起来的逆序数可以在合并的过程中计算！合并O(n)，由于是 bottom-up 的计算，因此算法是正确的，尽管最后破坏了原来数组的顺序！
	// 为什么？因为归并排序从最底层开始比较，每次比较只涉及两个元素交换！先递归下降到最左边，然后不断的走完左子树，相当于后序遍历的过程，
	// 内部的逆序数发生了改变，但每一次都不改变 左右分开的集合的逆序数！！
	// 即 2 3 8 6 1, 2 3 8 和 6 1 两部分，左子集中 大于 右子集 的逆序对不会因为 左右部分内部的变化而变化！这个规律就让 左右部分可以不断的拆分
	// 直到 左右部分都是只包含一个数的集合，逆序数也容易求！
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
	
	public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));  
        int n = cin.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = cin.nextInt();
        }
        System.out.println(InversionNumbers.inversionNumbersDC(nums, 0, nums.length-1));
    }
}
