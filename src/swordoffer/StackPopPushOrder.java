package swordoffer;

import java.util.Stack;

public class StackPopPushOrder {
	
	// [栈的压入弹出序列](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int i,j;
        int length = pushA.length;
        i = j = 0;
        while (i < length || j < length) {
            if (stack.isEmpty()) {
                stack.push(pushA[i]);
                i ++;
            }
            else {
                if (stack.peek() == popA[j]) {
                    stack.pop();
                    j ++;
                }
                else {
                    if (i == length) return false;
                    stack.push(pushA[i]);
                    i ++;
                }
            }
        }
        return true;
    }
}
