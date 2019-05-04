package swordoffer;


public class ReorderMinNumber {
	
	// [把数组排成最小的数](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public String PrintMinNumber(int [] numbers) {
        int n = numbers.length;
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < n - 1; j ++) {
                if (compare(numbers[j], numbers[j+1]) == 1) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num:numbers) {
            sb.append(String.valueOf(num));
        }
        return sb.toString();
    }
    
    public int compare(int a, int b) {
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        int lenA = sa.length();
        int lenB = sb.length();
        int i = 0;
        int j = 0;
        while (i < lenA || j < lenB) {
            char aa = (i >= lenA ? sa.charAt(lenA-1) : sa.charAt(i));
            char bb = (j >= lenB ? sb.charAt(lenB-1) : sb.charAt(j));
            if (aa > bb) {
                return 1;
            }
            else if (aa < bb) {
                return -1;
            }
            else {
                i ++; j++;
            }
        }
        return 0;
    }
}
