package swordoffer;

public class ReplaceSpace {
	// [替换空格](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	public String replaceSpace(StringBuffer str) {
        int length = str.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') count ++;
        }
        for (int i = 0; i < count * 2; i ++) {
            str.append('0');
        }
        int i = length - 1;
        int j = str.length() - 1;
        while (i >= 0 && j >= 0) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(j--, str.charAt(i--));
            }
            else {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
                i --;
            }
        }
        return str.toString();
    }
}
