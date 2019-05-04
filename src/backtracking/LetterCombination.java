package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {
	// [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)
	// 法一 自顶向下的递推方式
	String[] digitsMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits, digits.length() - 1);
    }
    
    public List<String> letterCombinations(String digits, int n) {
        List<String> combs = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return combs;
        String letters = digitsMap[digits.charAt(n) - '0'];
        if (n == 0) {
            
            for (int i = 0; i < letters.length(); i ++) {
                combs.add(String.valueOf(letters.charAt(i)));
            }
            return combs;
        }
        List<String> subCombs = letterCombinations(digits, n - 1);
        for (String subComb: subCombs) {
            for (int i = 0; i < letters.length(); i++) {
                combs.add(subComb + String.valueOf(letters.charAt(i)));
            }
        }
        return combs;
    }
    
    
    // 法二 采用queue ,类似于 bfs. 你可以把这个带限制的排列问题, 想象成一个树的构建过程, 如从根节点 第一个数字开始, 映射出多个字母孩子节点,
    // 接下来的第二个数字,对于上一层次的每一个字母,都可以再次映射出该层数字对应的字母组合,这样你可以使用queue保存上一层所有的结果, 然后从队列中取出
    // 上一层所有的结果,尾部添加新元素构成新的叶子节点.
	public List<String> letterCombinations1(String digits) {
        String[] digitsMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> queue = new LinkedList<String>();
        if (digits == null || digits.length() == 0) return queue;
        queue.offer("");
        for (int i = 0; i < digits.length(); i ++) {
            while (queue.peek().length() == i) {
                String letters = digitsMap[digits.charAt(i) - '0'];
                String parent = queue.poll();
                for (char letter : letters.toCharArray()) {
                    queue.offer(parent + String.valueOf(letter));
                }
            }
        }
        return queue;
    }
}
