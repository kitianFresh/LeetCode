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

## [**丑数**](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) [source-code](./UglyNumber.java)