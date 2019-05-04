package swordoffer;

public class RotateOrder {
	// [翻转单词顺序](https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	public String ReverseSentence(String str) {
		if (str.trim().equals(""))
			return str;
		String[] sentence = str.trim().split(" ");
		int i = 0;
		int j = sentence.length - 1;
		while (i < j) {
			String temp = sentence[i];
			sentence[i] = sentence[j];
			sentence[j] = temp;
			i++;
			j--;
		}
		return String.join(" ", sentence);
	}

	// [左转字符串](https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public String LeftRotateString(String str, int n) {
		if (str == null || str.trim().equals(""))
			return str;
		char[] t = str.toCharArray();
		int len = str.length();
		n = n % len;
		if (n == 0)
			return str;
		reverse(t, 0, len - 1);
		reverse(t, 0, len - n - 1);
		reverse(t, len - n, len - 1);
		return String.valueOf(t);
	}

	public void reverse(char[] array, int l, int r) {
		int i = l;
		int j = r;
		while (i < j) {
			char ch = array[i];
			array[i] = array[j];
			array[j] = ch;
			i++;
			j--;
		}
		return;
	}
}
