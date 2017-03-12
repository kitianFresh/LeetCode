

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

## pathSum
 - [*257. Binary Tree Paths*](https://leetcode.com/problems/binary-tree-paths/?tab=Description)
 - [112. Path Sum](https://leetcode.com/problems/path-sum/?tab=Description)
 - [**113. Path Sum II**](https://leetcode.com/problems/path-sum-ii/?tab=Description)
 - [**437. Path Sum III**](https://leetcode.com/problems/path-sum-iii/?tab=Description)
 - [129. Sum Root to Leaf Numbers还可以继续优化](https://leetcode.com/problems/sum-root-to-leaf-numbers/?tab=Description)
 - [***124. Binary Tree Maximum Path Sum***未做](https://leetcode.com/problems/binary-tree-maximum-path-sum/?tab=Description)
 
## 
 - [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/?tab=Description)
 
## Binary Search Tree(BST)
 - [>_<501. Find Mode in Binary Search Tree](https://leetcode.com/problems/find-mode-in-binary-search-tree/?tab=Solutions)
 - [230. Kth Smallest Element in a BST未做](https://leetcode.com/problems/kth-smallest-element-in-a-bst/?tab=Description)
 - [450. Delete Node in a BST未做](https://leetcode.com/problems/delete-node-in-a-bst/?tab=Description)
 
## Binary Tree Height & Width & Level Order
 - [102. Binary Tree Level Order Traversal未做](https://leetcode.com/problems/binary-tree-level-order-traversal/?tab=Description)
 - [107. Binary Tree Level Order Traversal II未做](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/?tab=Description)
 - [103. Binary Tree Zigzag Level Order Traversal未做](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?tab=Description)
 - [binary-tree-vertical-order-traversal未做](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)
 - [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/?tab=Description)
 - [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/?tab=Description)
 - [110. Balanced Binary Tree未做](https://leetcode.com/problems/balanced-binary-tree/?tab=Description)
