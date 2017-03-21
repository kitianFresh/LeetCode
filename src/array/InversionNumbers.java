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
	public static int mergeCrossInversionNumbers(int[] A, int l, int mid, int r) {
		int count = 0;
		int[] a = new int[mid-l+2];
		int[] b = new int[r-mid+1];
		int i,j;
		for (i=0;i<a.length-1;i++) {
			a[i] = A[l+i];
		}
		a[i] = Integer.MAX_VALUE;
		for (j=0;j<b.length-1;j++) {
			b[j] = A[mid+1+j];
		}
		b[j] = Integer.MAX_VALUE;
		i = j = 0;
		int k = l;
		int nlower = 0; // 记录当前b[]中 因为小于 a 而放入 A 中的数的个数,那么当a要放入的时候，就说明b中比她小的个数就是nlower，加上即可作为当前逆序对数
		while (i < a.length-1 || j < b.length-1) {
			if (a[i] <= b[j]) {
				A[k++] = a[i++];
				count += nlower;
			}
			else {
				A[k++] = b[j++];
				nlower += 1;
			}
		}
//		count = ((count==0) ? (nlower) : (count));
		return count;
	}
	
	public static int inversionNumbersDC(int[] A, int l, int r) {
		if (l >= r) return 0;
		int mid = (l+r)/2;
		int left = inversionNumbersDC(A, l, mid);
		int right = inversionNumbersDC(A, mid+1, r);
		int cross = mergeCrossInversionNumbers(A, l, mid, r);
		return left + cross + right;
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
