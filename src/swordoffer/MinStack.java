package swordoffer;

import java.util.Stack;


// [包含min函数的栈](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
public class MinStack {
	
	
	Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    int curMin = Integer.MAX_VALUE;
    public void push(int node) {
        if (node < curMin) {
            curMin = node;
        }
        dataStack.push(node);
        minStack.push(curMin);
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
