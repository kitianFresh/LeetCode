package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//501. Find Mode in Binary Search Tree
public class FindMode {
	// 先序遍历，使用 HashMap 存储所有频次
    public void find(TreeNode root, HashMap<Integer, Integer> maps) {
        if (root == null) return ;
        maps.put(root.val, maps.getOrDefault(root.val, 0) + 1);
        find(root.left, maps);
        find(root.right, maps);
    }
    
    // O(n) time complexity， O(n) space complexity. HashMap
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> modes = new ArrayList<Integer>();
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        find(root, maps);
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            int mode = entry.getKey();
            int freq = entry.getValue();
            System.out.println(mode + ": " + freq);
            if (freq > max) {
                max = freq;
                modes.clear(); // O(1)
                modes.add(mode); // O(1)
            }
            else if (freq == max) {
                modes.add(mode);
            }
            else {
                continue;
            }
        }
        int[] arr = new int[modes.size()];
        for (int i=0; i<arr.length; i++) {
            arr[i] = modes.get(i);
        }
        return arr;
    }
    
    // O(1) space, O(n) time, Because it is a BST, so inOrder is sorted! This problem equals to find a mode in a sorted array.
    public int[] findModeO1(TreeNode root) {
    	ArrayList<Integer> modes = new ArrayList<Integer>();
    	inOrder(root, modes);
    	int[] arr = new int[modes.size()];
    	for (int i=0; i<modes.size();i++) {
    		arr[i] = modes.get(i);
    	}
    	return arr;
    }
    Integer pre = null;
    int count = 1;
    int max = Integer.MIN_VALUE;
    public void inOrder(TreeNode root, List<Integer> modes) {
    	if (root == null) return;
    	inOrder(root.left, modes);
    	if (pre != null) { //首次递归为空，直接跳过
    		if (root.val == pre) {
        		count ++;
        	}
        	else {
        		count = 1;
        	}
    	}
    	if (count > max) {
			max = count;
			modes.clear();
			modes.add(root.val);
		}
		else if (count == max) {
			modes.add(root.val);
		}
		else {
			;
		}
    	pre = root.val;
    	inOrder(root.right, modes);
    }
}
