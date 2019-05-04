# 图
一种保存两点之间路径的方法是,使用一个数组,这个数组采用 树的 双亲数组表示法! 因为 DFS 递归遍历的过程中会获得一棵最小生成树, 因此如果要保存起点到其他连通点的所有路径,使用一个 **双亲表示法的数组树** 即可得到所有的路径.

# DFS & BFS
 - [走迷宫](https://www.nowcoder.com/practice/6276dbbda7094978b0e9ebb183ba37b9) [source-code](./Maze.java)
 - [迷宫问题](https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc) [source-code](./MazeWithPath.java)
 - [200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/) [source-code](./Islands.java)
 - [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/description/) [source-code](./Islands.java)
	

# Java
java 中的 Stack 类的 foreach loop 尽然打印出来是 bottom up 的! 这不符合常理啊.并没有实现 LIFO 的输出, 要想按照 栈式 的pop输出元素,必需使用 pop才行,这样的后果就是会破坏原来栈中的数据! 要想不破坏栈,还实现栈式的LIFO的输出,需要使用 Deque 双端队列, 他既可以做栈,也可以当队列.

> A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, which should be used in preference to this class. For example:

   Deque<Integer> stack = new ArrayDeque<Integer>();
   

```java
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] numbers = new int[]{1,2,3,4,5};
		for (int i : numbers) {
			stack.push(i);
			deque.push(i);
			queue.offer(i);
		}
		
		for (int i : stack) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i : queue) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i : deque) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
//	1 2 3 4 5 
//	1 2 3 4 5 
//	5 4 3 2 1 

```