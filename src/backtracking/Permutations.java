package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	// 排列问题, 就是每个排列的长度确定了, 然后确定每个位置该选那些元素, 那些元素可以选择,那些不可以选择. 
	// 不同元素的排列(已经选择的元素不能再选择) permute, 不同元素的全排列(选择元素可以重复选择) nbits / nchars
	// 含有相同元素的排列(已经选择的元素不能再选择) permute II , 含有相同元素的全排列(选择元素可以重复选择)
	// 法一 子问题划分, 自顶向下的递归法, 数学公式清晰. Permute[n] = [insertEveryWhere(elem) for elem in Permute[n-1]]
	public List<List<Integer>> permuteI(int[] nums) {
        return permute(nums, nums.length - 1);
    }
    
    public List<List<Integer>> permute(int[] nums, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n == -1) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        if (n == 0) {
            List<Integer> e = new ArrayList<Integer>();
            e.add(nums[0]);
            res.add(e);
            return res;
        }
        List<List<Integer>> subs = permute(nums, n - 1);
        for (List<Integer> p : subs) {
            int size = p.size();
            for (int i = 0; i <= size; i ++) {
                ArrayList<Integer> subP = new ArrayList<Integer>(p);
                subP.add(i, nums[n]);
                res.add(subP);
            }
        }
        return res;
    }
    
    // 法二　法一的非递归写法．自底向上
    public List<List<Integer>> permuteI1(int[] nums) {
        return null;
    }
    
    // 法三 DFS 采用深度优先搜索该问题的解空间树, 将解存在一个数组 path 中, 从第一个位置开始选择剩余可以选择的元素,直到选到最后一个元素;
    // 搜索返回的时候记住必须标记会被选择的元素为 还未选择,从新开始搜索树的下一个兄弟分支;
    public List<List<Integer>> permuteI2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        boolean[] leftedNums = new boolean[n];
        int[] path = new int[n];
        dfs(res, leftedNums, nums, path, n);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, boolean[] leftedNums, int[] nums, int[] path, int n) {
        if (n <= 0) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            for (int p: path) {
                t.add(p);
            }
            res.add(t);
            return;
        }
        int size = leftedNums.length;
        for (int i = 0; i < size; i ++) {
            if (leftedNums[i]) continue;
            int selected = nums[i];
            path[n-1] = selected;
            leftedNums[i] = true;
            dfs(res, leftedNums, nums, path, n - 1);
            leftedNums[i] = false;
        }
    }
    
    // 法四　剑指offer 的版本．想法是把字符串分成左右两部分，第一部分是第一个字符，第二部分是后面的字符串．
    // 第一个字符可以有多种不同的选择，从第一个到最后一个(如果没有重复元素的话), 选定一个之后，第二部分就可以作为相同性质的子问题，
    // 这里对全排列的另一种演算方式是交换任意两个位置元素的过程，由基础排列开始，第一个元素可以和第二部分任意元素交换，
    // 交换之后子问题一样的方式进行, 但是子问题求完之后再换回来就可以恢复原样
    // 这种方法的好处是有的，就是当含有重复元素的时候，(可以对字符串排序)
    public ArrayList<String> Permutation(String str) {
        char[] chs = str.toCharArray();
        //Arrays.sort(chs);
        StringBuilder sb = new StringBuilder(String.valueOf(chs));
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0) return res;
        permute(res, sb, 0);
        return res;
     }
     
     public void permute(ArrayList<String> res, StringBuilder sb, int pos) {
        if (pos == sb.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = pos; i < sb.length(); i++) {
        	if (i != pos && sb.charAt(i) == sb.charAt(pos)) continue; // 在不同的位置上相同的值,交换了也没用
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(pos));
            sb.setCharAt(pos, temp);
            permute(res, sb, pos + 1);
            temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(pos));
            sb.setCharAt(pos, temp);
        }
        return;
     }
    
 // T(n) = 2 * T(n-1) + O(1); NP 2^n
 	public void nBits(int n, int[] A) {
 		if (n <= 0) {
 			System.out.println(Arrays.toString(A));
 		}
 		else {
 			A[n-1] = 0;
 			nBits(n-1, A);
 			A[n-1] = 1;
 			nBits(n-1, A);
 		}
 	}
 	
 	public void nChars(StringBuilder sb, String result, int len) {
 		if (len == sb.length()) {
 			System.out.println(result);
 		}
 		else {
 			for (int i = len; i < sb.length(); i++) {
 				
 			}
 		}
 	}
 	
    
}
