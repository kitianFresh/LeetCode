package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	// [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/description/)
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap<String, List>();
        List<List<String>> res = new ArrayList<List<String>>();
        for (String str: strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> val = new ArrayList<String>();
                val.add(str);
                map.put(key, val);
            }
        }
        for (List<String> val: map.values()) {
            res.add(val);
        }
        return res;
    }
	// user defined hash func to compute hash key, 不同的素数相乘绝对不可能得到相同的结果，　因为一个数的因式分解有且仅有一种
	// Using prime, fast but maybe overflow for long string , 
	public static List<List<String>> groupAnagrams1(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };// 最多10609个z

		List<List<String>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}
	
	// user defined hash func, use character counting method to compute hash key.
	public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
