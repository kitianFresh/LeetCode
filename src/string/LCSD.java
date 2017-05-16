package string;

import java.util.HashMap;

public class LCSD {
	// [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/#/solutions)
	// [解析](https://leetcode.com/articles/longest-substring-without-repeating-characters/)
	// O(n) Space, O(n) time Hash table 存放 start 和 i 之间已经扫描过的字符, 发现有重复则更新 start, 继续扫描, 无重复直接继续扫描, 计算 curLen = i - start + 1;
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        int i,j;
        i = j = 0;
        char ch;
        int curLen, max, start;
        start = curLen = max = 0;
        for (; i < s.length(); i++) {
            ch = s.charAt(i);
            if (hash.containsKey(ch)) {
                start = Math.max(hash.get(ch) + 1, start); // 含有则需要看是否在 start之 后, 在 start 之后, 则更新
               
            }
            hash.put(ch, i);
            curLen = i - start + 1;
            if (curLen > max) {
                max = curLen;
            }
        }
        return max;
    }
}
