import java.util.Scanner;

public class SumBT {
	public static int findRoot(int[] arr, int l, int r, int target) {
		for (int i = l; i <= r; i++) {
			if (arr[i] == target) return i;
		}
		return -1;
	}
	public static int sum(int[] arr, int l, int r) {
		int sum = 0;
		for (int i = l; i <= r; i ++) {
			sum += arr[i];
		}
		return sum;
	}
	public static void sumBT(int[] preOrder, int pl, int pr, int[] inOrder, int il, int ir, int[] res) {
		if (pl > pr || il > ir) return;
		int root = preOrder[pl];
		int inorder_root_index = findRoot(inOrder, il, ir, root);
		res[inorder_root_index] = sum(inOrder, il, inorder_root_index-1) + sum(inOrder, inorder_root_index+1, ir);
		int left_childs = inorder_root_index - il;
		sumBT(preOrder, pl+1, pl+left_childs, inOrder, il, inorder_root_index-1, res);
		sumBT(preOrder, pl+left_childs+1, pr, inOrder, inorder_root_index+1, ir, res);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String preOrder = sc.nextLine();
		String inOrder = sc.nextLine();
		String[] pre = preOrder.split(" ");
		String[] in = inOrder.split(" ");
		int[] a1 = new int[pre.length];
		int[] a2 = new int[in.length];
		for (int i = 0; i < a1.length; i ++) a1[i] = Integer.valueOf(pre[i]);
		for (int i = 0; i < a2.length; i ++) a2[i] = Integer.valueOf(in[i]);
		int[] res = new int[a1.length];
		sumBT(a1, 0, a1.length-1, a2, 0, a2.length-1, res);
		for (int i = 0; i < res.length; i ++) {
			System.out.print(res[i]);
			System.out.print(" ");
		}
	}
}
