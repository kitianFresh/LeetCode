package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors; 

public class TreePath {
	
	// 先序遍历的思想，即使用一个list存储遍历过程的路径，每次进入一层就加入node，退出一层就删除刚加入的node，并且当到达叶节点时，将路径加入集合。
	public void binaryTree(TreeNode root, LinkedList<Integer> list, LinkedList<String> res) {
		list.add(root.val);
        if (root.left != null) {
        	binaryTree(root.left, list, res);
        }
        if (root.right != null){
        	binaryTree(root.right, list, res);
        }
        if (root.left == null && root.right == null) {
        	String listString = list.stream().map(Object::toString)
                    .collect(Collectors.joining("->"));
            res.add(listString);
        }
        list.removeLast();
        return;
        
    }
	public List<String> binaryTreePaths1(TreeNode root) {
		Stack<Integer> s = new Stack<Integer>();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<String> res = new LinkedList<String>();
		if (root == null) return res;
		
        binaryTree(root, list, res);
        return res;
    }
	
	// 分治思想，如果左子树和右子树两个子问题的所有路径已经求得在list中，那么只需要讲路径中的每一个元素前面加上 root.val + "->"
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		if (root == null) return paths;
		if (root.left == null && root.right == null) {
			paths.add(Integer.toString(root.val));
			return paths;
		}
		if (root.left != null) {
			for (String path : binaryTreePaths(root.left)) {
				paths.add(root.val + "->" + path);
			}
		}
		if (root.right != null) {
			for (String path : binaryTreePaths(root.right)) {
				paths.add(root.val + "->" + path);
			}
		}
		return paths;
	}
	
	public List<List<Integer>> pathSumII(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		if (root == null) return paths;
		if (root.left == null && root.right == null && root.val == sum) {
		    ArrayList<Integer> l = new ArrayList<Integer>();
		    // 这里必须使用 ArrayList<Integer> 类型，即新申请一个；不能使用 Arrays.asList(), 他返回的是 List<Integer> ，
		    // 并且也不能使用强制转换，只有子类可以被强制转换为父类，没有父类被强制转换为子类的规矩。
		    // 因为 List<Integer> 导致了后面再取出元素的时候抛出UnsupportedOperationException。
		    l.add(root.val);
		    paths.add(l);
		    return paths;
		}
	
		for (List<Integer> path : pathSumII(root.left, sum-root.val)) {
		    path.add(0, root.val);
		    paths.add(path);
		}
		
		for (List<Integer> path : pathSumII(root.right, sum-root.val)) {
			path.add(0, root.val);
		    paths.add(path);
		}
        return paths;
    }
	
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) return true;
            else return false;
        }
        
        boolean left, right;
        left = false;
        right = false;
        if (root.left!=null) {
            left = hasPathSum(root.left, sum-root.val);
        }
        if (root.right!=null) {
            right = hasPathSum(root.right, sum-root.val);
        }
        return left || right; 
    }
	
	/*// 难题，不好理解，容易出错, 这个是错误的版本，因为 pathSumIII(root.left, sum-root.val) 和 pathSumIII(root.right, sum-root.val) 是有重复的！！！比如root 本生就是一个路径
	public int pathSumIII(TreeNode root, int sum) {
        LinkedList<Integer> path = new LinkedList<Integer>();
        
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            if (root.val == sum) return 1;
            else return 0;
        }
        if (root.val == sum) return pathSumIII(root.left, sum) + pathSumIII(root.right, sum) + 1;
        return pathSumIII(root.left, sum) + pathSumIII(root.left, sum-root.val) + pathSumIII(root.right, sum) + pathSumIII(root.right, sum-root.val);
    }*/
	
	
	/*
	// 错误的！！
	public int pathSumIII(TreeNode root, int sum) {
		if (root == null) return 0;
		
		return findPath(root, sum) + findPath(root.left, sum) + findPath(root.right, sum);
	}
	// 这个是包含root的find pathsum
	public int findPath(TreeNode root, int sum) {
		int count = 0;
		if (root == null) return 0;
		if (root.val == sum) {
			count ++;
		}
		count += findPath(root.left, sum-root.val);
		count += findPath(root.right, sum-root.val);
		return count;
	}
	*/
	
	// T(n) = T(n-p) + T(p) + nlgn 平均O(n^2)，最好是 p = n/2 为 nlgn
	// 分治法，三种情况的子问题，包含root的整个树，不包含root的左子树，不包含root的右子树
	public int pathSumIII(TreeNode root, int sum) {
		if (root == null) return 0;
		
		return findPath(root, sum) + pathSumIII(root.left, sum) + pathSumIII(root.right, sum);
	}
	// 这个是包含root的find pathsum,且可以到达中间任意节点，因此当自身和sum相等时，就加1；也是分治法，最好情况O(nlgn),最坏情况树退化呈线性 O(n^2)
	public int findPath(TreeNode root, int sum) {
		if (root == null) return 0;
		
		return (root.val == sum ? 1: 0) + findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
	}
	
	// HashMap + prefixSum / suffixSum 可以将线性查找问题变换为计算问题，从而降低时间复杂度,类比求连续相加求和等于特定数，可以先求前缀和。
	// 升级版！ 先序遍历的过程中采用前缀和presum。时间复杂度 O(n),空间复杂度 O(n), HashMap
	public int pathSumIII1(TreeNode root, int sum) {
		if (root == null) return 0;
		HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
		preSum.put(0, 1); // 空数组的前缀和为 0， 有一个
		return inOrderPreSum(root, 0, sum, preSum);
	}
	
	public int inOrderPreSum(TreeNode root, int curSum, int target, HashMap<Integer, Integer> preSum) {
		int count = 0;
		if (root == null) return 0;
		curSum += root.val;
		count += preSum.getOrDefault(curSum-target, 0);
		preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
		
		count += inOrderPreSum(root.left, curSum, target, preSum) + inOrderPreSum(root.right, curSum, target, preSum);
		// 由于递归返回的时候，先序遍历完成左右子树的遍历，回到当前根节点，这个前缀和显然不能再供其他遍历使用了！
		// 因为必须保证前缀！只有左孩子和有孩子的父亲节点才是他们的前缀，其他的叔叔阿姨都不是！
		preSum.put(curSum, preSum.get(curSum) - 1);
		return count;
	}
	
	// 129. Sum Root to Leaf Numbers. 解法空间复杂度和时间复杂度都值得优化
	public List<List<Integer>> sumPath(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        if (root == null) return paths;
        if (root.left == null && root.right == null) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            paths.add(path);
        }
        for (List<Integer> path : sumPath(root.left)) {
            path.add(0, root.val);
            paths.add(path);
        }
        for (List<Integer> path : sumPath(root.right)) {
            path.add(0, root.val);
            paths.add(path);
        }
        return paths;
    }
    
    public int getNumber(List<Integer> path) {
        int number = 0;
        for (Integer i : path) {
            number = 10 * number + i;
        }
        return number;
    }
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        for (List<Integer> path : sumPath(root)) {
            sum += getNumber(path);
        }
        return sum;
    }
}
