package string;

public class LongestPalindromicSubStr {
	//[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)
	public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String maxStr = "";
        for (int i = 0; i < n; i ++) {
            int left, right, len;
            len = 1;
            right = i;
            while (right < n - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right ++;
                len ++;
            }
            left = i;
            while (left > 0 && s.charAt(left) == s.charAt(left - 1)) {
                left --;
                len ++;
            }
            left --;
            right ++;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
                len += 2;
            }
            if (len > max) {
                max = len;
                maxStr = s.substring(left+1, right);
            }
        }
        return maxStr;
    }
}
