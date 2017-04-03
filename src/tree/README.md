

# java 1.8 List Join 方法

```java
// String.join
List<String> cities = Arrays.asList("Milan", 
                                    "London", 
                                    "New York", 
                                    "San Francisco");
		
String citiesCommaSeparated = String.join(",", cities);
 
System.out.println(citiesCommaSeparated);

// map-reduce

String citiesCommaSeparated = cities.stream().map(Object::toString)
                                    .collect(Collectors.joining(","));
 
System.out.println(citiesCommaSeparated);
```

## pathSum & advanced
 - [*257. Binary Tree Paths*](https://leetcode.com/problems/binary-tree-paths/?tab=Description)
 - [112. Path Sum](https://leetcode.com/problems/path-sum/?tab=Description)
 - [**113. Path Sum II**](https://leetcode.com/problems/path-sum-ii/?tab=Description)
 - [**437. Path Sum III**](https://leetcode.com/problems/path-sum-iii/?tab=Description)
 - [129. Sum Root to Leaf Numbers还可以继续优化](https://leetcode.com/problems/sum-root-to-leaf-numbers/?tab=Description)
 - [***124. Binary Tree Maximum Path Sum***未做](https://leetcode.com/problems/binary-tree-maximum-path-sum/?tab=Description)
 - [508. Most Frequent Subtree Sum未做](https://leetcode.com/problems/most-frequent-subtree-sum/#/description)
 
## Symmetric & Mirror & Invert & Recursion & Divide Conquer
 - [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/?tab=Description)
 - [**101. Symmetric Tree**](https://leetcode.com/problems/symmetric-tree/#/description)
 - [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/#/description)
 - [222. Count Complete Tree Nodes less O(n)未完待续](https://leetcode.com/problems/count-complete-tree-nodes/#/solutions)
 
## Binary Search Tree(BST)
 - [>_<501. Find Mode in Binary Search Tree](https://leetcode.com/problems/find-mode-in-binary-search-tree/?tab=Solutions)
 - [538. Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/#/description)
 - [**230. Kth Smallest Element in a BST**](https://leetcode.com/problems/kth-smallest-element-in-a-bst/?tab=Description)
 - [450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/?tab=Description)
 - [173. Binary Search Tree Iterator未做](https://leetcode.com/problems/binary-search-tree-iterator/#/description)
 - [99. Recover Binary Search Tree未做](https://leetcode.com/problems/recover-binary-search-tree/#/description)
 
 
## Basic Tree Traversal
 - [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/#/description)
 - [145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/#/description)
 - [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/#/description)
 - [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/?tab=Description)
 - [107. Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/?tab=Description)
 - [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?tab=Description)
 - [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/#/description)
 
## Tree Construct
 - [106. Construct Binary Tree from Inorder and Postorder Traversal未](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/#/description)
 - [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/#/description)
 - [108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description)
 - [109. Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/#/description)

## Binary Tree Height & Width & Level Order
 - [binary-tree-vertical-order-traversal未做](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)
 - [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/?tab=Description)
 - [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/?tab=Description)
 - [110. Balanced Binary Tree未做](https://leetcode.com/problems/balanced-binary-tree/?tab=Description)
 - [打印一颗树]()

 
## Binary Tree & LinkedList
 - [116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/#/description)
 - [117. Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/#/description)
 - [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/#/description)