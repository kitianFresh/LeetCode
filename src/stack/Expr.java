package stack;

import java.util.HashMap;
import java.util.Stack;

public class Expr {
	public static void main() {
		
	}
	public static boolean match(char a, char b) {
		return a == '[' && b == ']' || a == '{' && b == '}' || a == '(' && b == ')';
	}
	public static boolean bracketMatch(String expr) {
		if (expr == null || expr.length() == 0) return true;
		Stack<Character> stack = new Stack<Character>();
		char ch;
		int i=0;
		while (i<expr.length()) {
			ch = expr.charAt(i);
			switch(ch) {
				case '{':
				case '[':
				case '(':
					stack.push(ch);
					break;
				case '}':
				case ']':
				case ')':
					if (stack.isEmpty()) return false;
					if (match(stack.pop(), ch)) break;
					else return false;
				default:
					return false;
			}
			i ++;
		}
		
		return stack.isEmpty()?true:false;
	}
	
	
	static HashMap<Character, Integer> precedenceTable = new HashMap<Character, Integer>();
	static {
		precedenceTable.put('(', 1);
		precedenceTable.put(')', 1);
		precedenceTable.put('^', 2);
		precedenceTable.put('/', 3);
		precedenceTable.put('%', 3);
		precedenceTable.put('*', 3);
		precedenceTable.put('+', 4);
		precedenceTable.put('-', 4);
		precedenceTable.put('$', 5);
		System.out.println("precedenceTable init");
	}
	
	public static int getOperatorPrecedence(char ch) {
		return precedenceTable.getOrDefault(ch, 0);
	}
	public static boolean isOperand(char ch) {
		if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
			return true;
		}
		else {
			return false;
		}
	}
	public static String infixExprToPostfix(String expr) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		stack.push('$');
		int i=0;
		char ch;
		while (i < expr.length()) {
			ch = expr.charAt(i);
			if (isOperand(ch)) {
				sb.append(ch);
			}
			else {
				if (!stack.isEmpty() && ch != ')' && getOperatorPrecedence(ch) < getOperatorPrecedence(stack.peek())) {
					stack.push(ch);
				}
				else {
					if (ch == ')') {
						while (!stack.isEmpty()) {
							if (stack.peek() == '(') {
								stack.pop();
								break;
							}
							sb.append(stack.pop());
						}
					}
					else {
						while (!stack.isEmpty() && stack.peek() != '(' && getOperatorPrecedence(ch) >= getOperatorPrecedence(stack.peek())) {
							sb.append(stack.pop());
						}
						stack.push(ch);
					}
				}
			}
			for (Character c : stack) {
				System.out.print(c + " ");
			}
			System.out.println();
			i ++;
		}
		while (!stack.isEmpty() && stack.peek() != '$') {
			if (stack.peek() == '(') throw new IllegalArgumentException();
			else {
				sb.append(stack.pop());
			}
		}
		return sb.toString();
	}
	
	
	
	
	
	// 更加紧凑的代码如下，如果逻辑判断之间不是完全符合左右分支，那么使用 switch 可能更好。
	public static String inToPost(String expr) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		stack.push('$');
		int i=0;
		char ch;
		while (i < expr.length()) {
			ch = expr.charAt(i);
			switch(ch) {
				case '+':
				case '-':
				case '*':
				case '/':
				case '%':
					gotOperator(stack, sb, ch);
					break;
				case '^':
					// ^ 指数运算特殊的地方在于，连续的同一级优先权的^ 运算顺序是从右往左，而不是从左往右
					stack.push(ch); // 由于 '^' 在当前运算符中优先级是最高的，所以直接进栈即可。
					if (expr.charAt(i+1) == '(') { //但是此处必须判断后面的数是否是数，如果是运算符，那么就需要跳出来，进入下一层循环。这里只考虑 (),还有其他的比如 ++i 就不考虑了
						break;
					}
					sb.append(expr.charAt(++i));
					break;
				case '(':
	                stack.push(ch);
	                break;
	            case ')':
	                gotParenthesis(stack,sb, ch);
	                break;
	            default:
	            	sb.append(ch);
			}
			i ++;
		}
		while (!stack.isEmpty() && stack.peek() != '$') sb.append(stack.pop());
		return sb.toString();
	}
	public static void gotOperator(Stack<Character> stack, StringBuilder sb, char op) {
		if (getOperatorPrecedence(op) < getOperatorPrecedence(stack.peek())) {
			stack.push(op);
		}
		else {
			while (getOperatorPrecedence(op) >= getOperatorPrecedence(stack.peek())) {
				if (stack.peek() == '(') break;
				sb.append(stack.pop());
			}
			stack.push(op);
		}
	}
	
	public static void gotParenthesis(Stack<Character> stack, StringBuilder sb, char op) {
		while (!stack.isEmpty() && stack.peek() != '$') {
			if (stack.peek() == '(') {
				stack.pop();
				break;
			}
			sb.append(stack.pop());
		}
	}
}
