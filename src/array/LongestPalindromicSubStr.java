package array;

public class LongestPalindromicSubStr {
	// [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)
	// 此题目的关键在于双指针法向两边延伸的时候需要分奇偶，如果不分就会出错，
	// 这里让代码优雅起来的关键是直接以回文是偶数长度和奇数长度做假设，把两种情况都统计出来比较谁长；
	public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        String maxStr = "";
        int len = s.length();
        for (int m = 0; m < len; m ++) {
            String s1 = extendsPalindrome(s, m, m);
            String s2 = extendsPalindrome(s, m, m+1);
            if (s1.length() > maxStr.length()) maxStr = s1;
            if (s2.length() > maxStr.length()) maxStr = s2;
        }
        return maxStr;
    }
    
    public String extendsPalindrome(String s, int l, int r) {
        int len = s.length();
        while (l >= 0 && r < len) {
            if (s.charAt(l) != s.charAt(r)) break;
            l --;
            r ++;
        }
        return s.substring(l+1, r);
    }
}
