package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] nums = {2, 7, 11, 15};
		int[] res =  ts.twoSum1(new int[]{1}, 18);
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
	// O(n^2) 暴力求解
	public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        int i,j,n;
        n = nums.length;
        for (i=0;i<n-1;i++) {
            for (j=i+1;j<n;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
        
    }
	
	// O(n) hash 方法
	public int[] twoSum1(int[] nums, int target) {
		if (nums == null || nums.length < 2) return null;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
			    return new int[]{map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
	// Two Pointers O(n)
	public int[] twoSumSorted(int[] numbers, int target) {
		if (numbers == null || numbers.length == 1)  return null;
        int i,j,sum;
        for (i=0,j=numbers.length-1;i<j;) {
            sum = numbers[i] + numbers[j];
            if (sum > target) {
                j --;
            }
            if (sum < target) {
                i ++;
            }
            if (sum == target) {
                return new int[]{i+1,j+1};
            }
        }
        return null;
	}
	
	// a+b+c = 0 的所有不同de三元组
	// O(n^2) 就是将 threeSum 转换为 已排序的 twoSum 问题，但是为了避免重复，需要核查
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {          // 除了开始以外，其他检查过得元素需要比较是否相等，相等则说明是同一个 target，不需要了
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++; // lo后面相等的都跳过
                        while (lo < hi && num[hi] == num[hi-1]) hi--; // hi前面相等的也跳过
                        lo++; hi--;                                     // 然后lo 和 hi 各自前进后退一步
                    } else if (num[lo] + num[hi] < sum) lo++; // 小于 sum 说明 lo 太小，前进
                    
                    else hi--; // 大于 sum 说明 hi 太大，后退
               }
            }
        }
        return res;
    }
    // a+b+c 和 target 最接近；首先排序，然后使用 target - a；问题转化为找 b 和 c 使得他和 target - a 最接近； 
    // 由于数组有序， 双指针 nums[left] + nums[right] > target-a 的话，必定需要right--，因为此时如果left++必定更大，就不是更接近了，排除；
    // 同理，当 nums[left] + nums[right] < target-a， 必定left++, 因为此时如果 right--的话，就会更小，远离结果了；
    public int threeSumClosest(int[] nums, int target) {
    	if (nums == null || nums.length < 3) return 0;
    	Arrays.sort(nums);
    	int res, newTarget;
    	int i,left,right,minDiff;
    	res = nums[0] + nums[1] + nums[nums.length-1];
    	minDiff = Integer.MAX_VALUE;
    	for (i=0;i<nums.length-2;i++) {
    		newTarget = target - nums[i];
    		for (left=i+1,right=nums.length-1;left<right;) {
    			if (Math.abs(newTarget-nums[left]-nums[right]) < minDiff) {
    				res = nums[i] + nums[left] + nums[right];
    				minDiff = Math.abs(newTarget-nums[left]-nums[right]);
    			}
    			if (nums[left]+nums[right] > newTarget) {
    				right --;
    			}
    			else if (nums[left]+nums[right] < newTarget) {
    				left ++;
    			}
    			else {
    				return target;
    			}
    		}
    	}
        return res;
    }
    
    // O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	if (nums == null) return null;
    	List<List<Integer>> lists = new LinkedList<List<Integer>>(); // 这里只涉及插入，不涉及查询，因此采用LinkedList更好
    	if (nums.length < 4) return lists;
    	int twoTarget,threeTarget,k,i,left,right,n;
    	Arrays.sort(nums);
    	n = nums.length;	
    	for (k=0;k<n-3;k++) {
    		//减小问题规模，首先转换为 threeSum 子问题;
        	threeTarget = target - nums[k];
        	// threeSum
        	for (i=k+1;i<n-2;i++) {
        		// 再次缩小，改变为 twoSum 子问题
        		twoTarget = threeTarget - nums[i];
        		for (left=i+1,right=n-1;left<right;) {
        			if (nums[left]+nums[right]==twoTarget) {
        				lists.add(Arrays.asList(nums[k],nums[i],nums[left],nums[right]));
        				// 忽略相同的元素，防止重复
            			while (left < right && nums[left] == nums[left+1]) left ++;
            			while (left < right && nums[right] == nums[right-1]) right --;
            			left ++;
        				right --;
        			}
        			else if (nums[left]+nums[right]>twoTarget) {
        				right --;
        			}
        			else {
        				left ++;
        			}
        		}
        		while (i<n-3 && nums[i] == nums[i+1]) i++;
        	}	
            while (k<n-4 && nums[k] == nums[k+1]) k++;
    	}
    	
        return lists;
    }
    
    // Space O(n^2) Time O(n^2) A[i]+B[j]+C[k]+D[l] = 0 等价于  A[i]+B[j]=-(C[k]+D[l]); 分成两部分来看待，问题化简为 n^2 和 n^2 个数相加的问题，问题规模降低到 n^2; 分别求出两部分的所有的和，此时再采用hash，类比 twoSum,即可得到 O(n^2)。
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	if (A == null || B == null || C == null | D == null) return 0;
    	Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    	int count=0;
    	int i,j,sum=0;
    	for (i=0;i<A.length;i++) {
    		for (j=0;j<B.length;j++) {
    			sum = A[i] + B[j];
    			map.put(sum, map.getOrDefault(sum, 0) + 1);
    		}
    	}
    	
    	for (i=0;i<C.length;i++) {
    		for (j=0;j<D.length;j++) {
    			count += map.getOrDefault(-C[i]-D[j], 0);
    		}
    	}
    	
        return count;
    }
}
