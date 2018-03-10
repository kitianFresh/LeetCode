package swordoffer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class BinaryTreeNextNode {
	// [二叉树中序遍历的下一个节点](https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        
        if (pNode.right != null) { // 有右孩子，则在右孩子的最左边
            return findLeftMost(pNode.right);
        }
        else {//无右孩子,则分两种情况, pNode 是左孩子, 则父亲就是next, pNode是右孩子,则得看父亲是左孩子还是右孩子
            while (pNode.next != null) {
                if (pNode.next.left == pNode) return pNode.next;
                if (pNode.next.right == pNode) pNode = pNode.next;
            }
            return null;
        }
        
    }
    public TreeLinkNode findLeftMost(TreeLinkNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
