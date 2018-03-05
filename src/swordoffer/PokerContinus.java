package swordoffer;

import java.util.Arrays;

public class PokerContinus {
	// [扑克牌顺序](https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);
        int zeros = 0;
        int seps = 0;
        int i, j;
        for (i = 0; i < numbers.length - 1; i ++) {
            if (numbers[i] == 0) zeros ++;
            else break;
        }
        for (j = i; j < numbers.length - 1; j ++) {
            if (numbers[j] == numbers[j+1]) return false;
            else {
                seps += numbers[j+1] - numbers[j] - 1;
            }
        }
        return zeros >= seps;
    }
}
