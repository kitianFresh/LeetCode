package tree;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBinaryTree {

	
	@Before
	public void init(){
		
	}
	
	@After
	public void destroy(){
		
	}
	
	
	@org.junit.Test
	public void testBinaryTree() {
		List<Integer> list = new ArrayList<Integer>();
		String[] arr = new String[]{"10","5","-3","3","2",null,"11","3","-2",null,"1"};
		for (int i=0; i < arr.length; i++) {
			if (arr[i] == null) {
				list.add(null);
			}
			else {
				list.add(Integer.valueOf(arr[i]));
			}
		}
		
		
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.buildBTreeByPerfectArray(list, 0);
		System.out.println("\n----------PreOrder------------");
		List<Integer> order1 = new LinkedList<Integer>();
		bt.preOrder(root, order1);
		Util.display(order1);
		
		System.out.println("\n-----------InOrder------------");
		List<Integer> order2 = new LinkedList<Integer>();
		bt.inOrder(root, order2);
		Util.display(order2);
		
		
		System.out.println("\n-----------PostOrder-----------");
		List<Integer> order3 = new LinkedList<Integer>();
		bt.postOrder(root, order3);
		Util.display(order3);
		
		List<Integer> order;
		System.out.println("\n-----------LevelOrder-----------");
		order = bt.levelOrder(root);
		Util.display(order);
		
		
		System.out.println("\n-----------PreOrderStack-----------");
		order = bt.preOrderStack(root);
		Util.display(order);

		System.out.println("\n-----------InOrderStack-----------");
		order = bt.inOrderStack(root);
		Util.display(order);
		
		System.out.println("\n-----------PostOrderStack-----------");
		order = bt.postOrderStack(root);
		Util.display(order);
		
		System.out.println("\n-----------PostOrderStack1-----------");
		order = bt.postOrderStack1(root);
		Util.display(order);
		
		
	}

}
