package math;

public class ExcelSheet {
	// [171. Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/description/)
	public int titleToNumber(String s) {
        int sum = 0;
        int length = s.length();
        for (int i = length - 1; i >= 0; i --) {
            int r = s.charAt(i) - 'A' + 1;
            sum += r * (int)Math.pow(26, (length - i - 1));
        }
        return sum;
    }
	
	// [168. Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/description/)
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int r = n % 26;
            if (r == 0) r = 26;
            sb.insert(0, (char)('A' + r - 1));
            n = n / 26;
        }
        return sb.toString();
    }
}
