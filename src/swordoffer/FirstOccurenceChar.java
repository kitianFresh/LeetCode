package swordoffer;

public class FirstOccurenceChar {
	
	// [字符串中第一个只出现一次的字符](https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	//　使用一个 map 计数即可解决，然后重新扫描字符串，看看首次只出现一次的返回即可
	public int FirstNotRepeatingChar(String str) {
        short[] map = new short[128];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)] ++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (map[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
	
	// [字符流中第一个不重复的字符](https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=3&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	// 由于字符流无限，直接计数的话，无法再次重新扫描字符串了，因此你需要记住只出现一次的字符的位置，然后比较他们的位置来找到首次只出现一次的字符
	// 这里就是将出现多次的置位负数，讲出现一次的直接值他出现的位置，初始化默认-1
	int[] map = new int[128];
    {
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
    }
    int pos = 0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (map[ch] == -1) {
            map[ch] = pos;
        }
        else {
            map[ch] = -2;
        }   
        pos ++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int minPos = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < map.length; i++) {
            if (map[i] >= 0) {
                if (map[i] < minPos) {
                    minPos = map[i];
                    ch = (char)i;
                }
            }
        }
        return ch;
    }
}
