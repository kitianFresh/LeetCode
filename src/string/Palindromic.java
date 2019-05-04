package string;

public class Palindromic {
	
	/* [合并构造回文序列的最小代价](https://www.nowcoder.com/questionTerminal/0147cbd790724bc9ae0b779aaf7c5b50)
	 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
		{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列, 
		{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
		现在给出一个数字序列，允许使用一种转换操作：
		选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
		现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
	 */
	// 首尾指针跟踪, 两个数不相等就进行加法：小的数加上相邻的值. 因为只有先合并较小的才会代价最小. 为什么往两边合并? 因为夹逼准则
	public static int minComb(int[] arr) {
        int head = 0;
        int tail = arr.length - 1;
        int times = 0;
        while (head < tail) {
            if (arr[head] < arr[tail]) {
                head ++;
                arr[head] += arr[head-1];
                times ++;
            }
            else if (arr[head] > arr[tail]) {
               	tail --;
                arr[tail] += arr[tail+1];
                times ++;
            }
            else {
                head ++;
                tail --;
            }
        }
        return times;
    }
}
