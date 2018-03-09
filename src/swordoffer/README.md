# 剑指offer
## [牛客-构建乘积数组](https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./MultiplyArray.java)
top-down递归定义子问题, bottom-up for loop

## [调整数组顺序，奇数在前偶数在后,且相对位置不变](https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)　[source-code](./ReorderArray.java)
稳定性！！快速排序不稳定，冒泡或者插入排序才是稳定的

## [翻转单词顺序](https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) [source-code](./RotateOrder.java)

## [左转字符串](https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./RotateOrder.java)
数组即向量，向量元素位置变化，即是矩阵变换，乘以旋转矩阵，可以得到其实是操作了两次内部旋转再加一次大旋转


## [和为S的两个数字](https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./NumberSum.java)


## [*和为S的连续正数序列*](https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./NumberSum.java)
还是双指针的使用，但是需要理解这个两个指针是自然数，并且根据连续自然数之和(small + big)(big-small+1)/2与sum比较，t > sum, small++; t < sum, big++; t == sum, big++;

## [**扑克牌顺序**](https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)　[source-code](./PokerContinus.java)
建模，扑克牌排序，排序完成之后，统计０的个数，然后统计需要插入数据的插槽个数，前者大于等于后者才胜利，并且不能有重复的非王元素

## [**旋转数组最小值**](https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)　[source-code](./RotatedMin.java)
注意带重复数据的时候，无法断定左右两部分，因此需要顺序扫描求出最小值

## [**含有重复字符的字符串的全排列**](https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)　[source-code](./DupPermute.java)
注意理解交换的思想

## [把数组排成最小的数](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./ReorderMinNumber.java)
关键是找到一种比较顺序

## [***丑数***](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./UglyNumber.java)
空间换时间，按序存储以前的丑数，顺序得来靠的是　一个法则，　后面的丑数一定是前面的丑数乘以　2或３或5得到的，找出他们第一个大于当前最大丑数的值，取三个中的最小值

## [替换空格](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) [source-code](./ReplaceSpace.java)
注意从后往前思维，因为最终的长度是已知的

## [二进制中一的个数](https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)　[source-code](./NumberOfOne.java)

## [数值的整数次方](https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) [source-code](./Power.java)
注意exponent 可能是负数！！！

## [*平衡二叉树*](https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./BalancedBinaryTree.java)
使用高度可以只遍历一遍节点！　另外是让求高度的算法返回一个额外的负数当做不平衡的标志，从而是算法非常优雅！

## [**树的子结构**](https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./HasSubTree.java)
注意递归定义的时候，三种情况，第一种是从根开始包含而不是从根开始就判断两棵树是否相等，是如果根相等，就继续判断左右是否还继续包含；另外两种情况就是，B 属于　A.left 的子结构　或者　A.right 的子结构！

## [二叉树的镜像](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./MirrorTree.java)

## [对称二叉树](https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)　[source-code](./MirrorTree.java)
方法一是递归，方法而是层次遍历，每一层的数据存在一个数组中，看数组是否对称

## [把二叉树打印成多行](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./BinaryTreeLevel.java)

## [**二叉树中和为某一值的路径**](https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) [source-code](./TreeRootPath.java)
