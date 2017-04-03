# Binary Tree(二叉树)
## 基本概念和性质
### 定义
**二叉树和树是递归定义的数据结构！每一个节点可以含有两个孩子，但每一个孩子最多只含有一个双亲！每一个节点的左右孩子还是一棵二叉树．这也是为什么二叉树很多时候使用递归算法或者栈来处理！**
### 性质
二叉树的节点数目之间的关系，我们假设二叉树中出度(节点孩子数目)为 0 1 2 的节点数目分别为 n0 n1 n2,　那么树的总的节点数目就是 n0+n1+n2, 另外，我们知道一棵树上的每个孩子都可以找到一个连接她的边，除了根不是孩子，其他节点都是孩子，因此　边数=n0+n1+n2-1,而边数就是二叉树的出度数即 2\*n2+n1,于是有 n0+n1+n2 - 1= 2\*n2+n1 得 n2 = n0 - 1;
这个性质可以推广到　k 叉树, n0 + n1 + n2 + ... + nk - 1 = k\*nk + (k-1)\*nk-1 + ... + 2\*n2 + n1 

树这种结构一般直接可以联想到和 O(lgn) 有关的算法．

一棵普通二叉树的最大高度是它退化为线性表的时候，即n个节点的二叉树的最大高度为 n, 最小高度是他为完全二叉树的时候，即 lg(n+1)向下取整数。我们设 完全二叉树的高的为 h, 那么节点数目一定满足 2^(h-1) - 1 < n <= 2^h - 1; 可解得 lg(n+1) <= h < lg(n+1) + 1

### 满二叉树

### 完全二叉树

### 平衡二叉树
左右子树的高度差绝对值小于等于1,一棵高度为h的平衡二叉树的节点个数至少是N(h) = N(h-1) + N(h-2) + 1;节点个数至多当然就是一颗满二叉树了，2^h-1.

显然， **满二叉树，完全二叉树都属于平衡二叉树，另外还有，AVL或者红黑树都是。**还有一种**通过不断的平均二分得到的树(在均匀分治法当中，每次都一分为二)，例如，二分查找过程，也是一棵平衡二叉树，但是他不一定是完全二叉树！**

### 线段树


## 二叉树的存储
### 顺序存储
二叉树的顺序存储，使用数组比较合适，而且必须满足数组是一个完全二叉树数组，即双亲和孩子的索引满足以下关系, 若双亲节点索引为 i(下标从0开始)，则左右孩子的下标分别是 2\*i+1 和 2\*i+2, 根据左孩子求父亲就是 (c-1)/2, 根据右孩子求父亲 (c-2)/2.
### 链表指针

## 实现
这是最简单的定义，其实很多树还会记录其他卫星数据，还可能增加　parent 指针域指向双亲或者 next 指针域指向兄弟;
```java
//链接法
class TreeNode {
	int val;
	TreeNode left, right;
	//TreeNode parent; // optional, point to parents
	//TreeNode next; // optional, point to brothers
	public TreeNode(int val) {val = val;}
}

//数组法,这是一个完全二叉树的表示方法，n 代表叶子的数目
int[] Tree = new int[2*n-1];
```

## 遍历 Traversal
树的遍历操作都是 O(n)　的时间复杂度，因为没一个节点只会访问一次，因此一般对树的算法的时间复杂度的估算，我们一般会看节点是否是只遍历了一次．对 BT 的操作集中在 traversal 遍历上面，包括　PreOrder, InOrder, PostOrder, 但是千万也要灵活记得 ReversePreOrder, ReverseInOrder, ReversePostOrder．最后是层次遍历 level order．

### 先序遍历和逆先序遍历 PreOrder　& ReversePreOrder
root->left->right
```

```

root->right->left
```
```
### 中序遍历和逆中序遍历 InOrder & ReverseInOrder
left->root->right

right->root->left

### 后序遍历和逆后序遍历 PostOrder & ReversePostOrder
left->right->root

right->left->root


先序中序后序遍历都是深度优先搜索 DFS！可以采用递归解决．另一种是显式栈的方法实现！


### 层次遍历 LevelOrder
层次遍历是广度优先搜索 BFS！可以采用队列来解决.有一种带有　next　指针域的LinkTree 可以实现不使用队列也能层次访问的方法！

### 基础遍历列举
 - [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/#/description)
 - [145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/#/description)
 - [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/#/description)
 - [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/?tab=Description)
 - [107. Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/?tab=Description)
 - [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?tab=Description)
 - [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/#/description)

## 构建二叉树

构建一颗二叉树，根据给定的输入进行，如果给定的输入是完全二叉数组表示法，
### 完全二叉数组表示的输入
[]

### 中序遍历＋前序遍历（或后序遍历）
必须要含有中序才可以构建出一颗唯一确定的二叉树！

### 二叉树构建列举
 - [106. Construct Binary Tree from Inorder and Postorder Traversal未](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/#/description)
 - [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/#/description)
 - [108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description)
 - [109. Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/#/description)
 
 
# Binary Search Tree(二叉搜索(查找)树)
**BST逆中序遍历和中序遍历是有序的！**,使用前缀和和后缀和

DFS & BFS 递归 分治法 recursive
 |     |
 |     |
Stack Queue iterative


 