package tree.bst;

import tree.TreeNode;

public class BST {
	/**
	 * 
	 * BST 删除的方法其实非上多，但是保持的原则和依据就是BST的中序遍历是有序的，采用前驱或者后继覆盖删除节点 或者 直接重新调整指针而不是进行复制 都是可以的！
	 * 对于不含有指向双亲的类型的树节点，必须另设置双亲变量跟踪，以及左右孩子的判断指示器。比较麻烦。而且 Java 如果 没办法 修改指针，及使用指针的指针，
	 * 比如 单纯使用 getSuccessor 函数就无法获得 successor 的双亲，除非设置 成员变量。或者不写成函数。
	 */
    
    // Iteratively. 
	// 1. 如果是叶子节点，直接将双亲节点的相应指针置空; 
	// 2. 只有右孩子，复制并重接右孩子；只有左孩子复制重接左孩子；
	// 3. 左右孩子都有，找到这个节点的后继 s， 将 s 赋值给 current，然后将 s 的双亲的左指针指向 s 的右孩子即可。
	// 如果后继就是 current 的右孩子的话，直接将 s 赋值给 current， 然后将 current 的右孩子指针指向 s 的右孩子。
    
    // 这里采用另一种 递归分治法 的写法，思想是 把 所有的删除都转换到叶子的删除上，因为叶子的删除不涉及树的大范围调整，只是简单的置空。代码会更加简单易懂
    // 1. 如果 root.val > key 则在左子树中删除，并将 root.left 指向 deleteNode() 调用后新返回的树根;
    // 2. 如果 root.val < key, 则在右子树中删除，并将 root.right 指向 deleteNode() 调用后新返回的树根;
    // 3. 如果 找到当前删除节点，则分三种情况：
	//		I: 只有左子树，返回删除节点的左孩子为新树的树根。
	//		II: 只有右子树，返回欲删除节点的右孩子为新树的树根。
	//		III: 左右孩子都有，找到 欲删除节点的 后继，然后将后继的值v复制给 欲删除节点，然后问题转换为 删除 欲删除节点右子树上值为 v 的节点。将 root.right 指向 deleteNode(root.right, val) 返回的新树根。
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        else {
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            else {
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }
                TreeNode s = getSuccessor(root);
                root.val = s.val;
                root.right = deleteNode(root.right, s.val);
            }
        }
        return root;
    }
    
    public TreeNode getSuccessor(TreeNode current) {
        current = current.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
