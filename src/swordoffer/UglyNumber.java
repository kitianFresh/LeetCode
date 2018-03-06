package swordoffer;

public class UglyNumber {
	
	// [**丑数**](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public int GetUglyNumber_Solution(int index) {
        if (index <= 1) return index;
        int[] numbers = new int[index];
        numbers[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        for (int i = 1; i < index; i ++) {
            int nextUgly = Math.min(Math.min(numbers[multiply2] * 2, numbers[multiply3] * 3), numbers[multiply5] * 5);
            numbers[i] = nextUgly;
            while (numbers[multiply2] * 2 <= numbers[i]) multiply2 ++;
            while (numbers[multiply3] * 3 <= numbers[i]) multiply3 ++;
            while (numbers[multiply5] * 5 <= numbers[i]) multiply5 ++;
        }
        return numbers[index-1];
    }
}
