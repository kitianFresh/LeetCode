# LeetCode
Code Algorithms

## Segment Tree
 - [Largest Rectangular Area in a Histogram | Set 1](http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/)
 - [Largest Rectangular Area in a Histogram | Set 2](http://www.geeksforgeeks.org/largest-rectangle-under-histogram/)
 - [Segment tree with single element modifications](http://codeforces.com/blog/entry/18051?)
 - [Classic Segment Tree](http://codeforces.com/blog/entry/15890)
 - [夜深人静写算法（7）：线段树](http://blog.jobbole.com/98591/)
 - [数据结构之线段树](http://dongxicheng.org/structure/segment-tree/)
 - [线段树和树状数组](http://poj.org/summerschool/1_interval_tree.pdf)
 
## Increasing Stack
 - [maximize-the-rectangular-area-under-histogram](http://stackoverflow.com/questions/4311694/maximize-the-rectangular-area-under-histogram)
 - [Judges' Comments on the Problems and their Solutions](http://www.informatik.uni-ulm.de/acm/Locals/2003/html/judge.html)
 
## Sum Problem Series
 - [two-sum](https://leetcode.com/problems/two-sum/?tab=Description)
 - [two-sum-ii-input-array-is-sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?tab=Description)
 - [3sum](https://leetcode.com/problems/3sum/?tab=Description)
 - [3sum-closest](https://leetcode.com/problems/3sum-closest/?tab=Description)
 - [3sum-smaller](https://leetcode.com/subscribe/)

```
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2: [-2, 0, 1] [-2, 0, 3]

Follow up:
Could you solve it in O(n2) runtime?
```
 - [Two Sum III - Data structure design](https://leetcode.com/subscribe/)

```
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
```
 - [4sum](https://leetcode.com/problems/4sum/?tab=Description)
 - [4sum-ii](https://leetcode.com/problems/4sum-ii/?tab=Description)
 - [k-sum-general(DFS)](https://huntzhan.org/k-sum-xi-lie-yu-combination-xi-lie/)
 - [k-sum-only-distinct-positive-integer(dp)](http://www.lintcode.com/en/problem/k-sum/)

combination
 - [39. Combination Sum](https://leetcode.com/problems/combination-sum/?tab=Description)
 - [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/?tab=Description)
 - [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/?tab=Description)
### 参考答案
 - [Two Sum系列 Leetcode解题记录](https://segmentfault.com/a/1190000006697526)
 - [K Sum 系列与 Combination 系列](https://huntzhan.org/k-sum-xi-lie-yu-combination-xi-lie/)
 
## Tree
 - [Print all k-sum paths in a binary tree](http://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/)
 
# Linux文件转码工具
```
$ sudo apt-get install enca
$ enca -L zh_CN ListNode.java 
7bit ASCII characters
  CRLF line terminators
$ enca -L zh_CN ListRotate.java 
Simplified Chinese National Standard; GB2312
  CRLF line terminators
$ enca -L zh_CN -x utf-8 *
$ enca -L zh_CN ListRotate.java 
Universal transformation format 8 bits; UTF-8

```

# Ubuntu package manager broken & gnome-software 100% cpu

```
sudo rm /var/lib/apt/lists/lock
sudo rm /var/cache/apt/archives/lock
//直接删掉所有的，然后重新update
sudo rm -r /var/lib/apt/lists
sudo apt-get autoremove gnome-software
```

 - [Reinstall or Fix Broken Packages in Linux Ubuntu 15.04 or Ubuntu 14.04](http://sourcedigit.com/16797-reinstall-or-fix-broken-packages-in-linux-ubuntu-15-04-or-ubuntu-14-04/)
 - [Repairing a badly damaged package system in Ubuntu](http://mergy.org/2013/03/repairing-a-badly-damaged-package-system-in-ubuntu/)
 - [PackageManagerTroubleshootingProcedure](https://help.ubuntu.com/community/PackageManagerTroubleshootingProcedure)

# Eclipse突然连接不上git
重新加载原来的RSA到eclipse SSH2 Home,然后重启还是不能解决，以前用的好好的，突然就不能用了，然后发现原来是走代理导致的，代理突然无法解析 github.com 网站，导致 eclipse EGIT不能使用，既不是公钥问题，也不是协议设置问题，以前设置了 eclipse network 的代理，现在修改成直接连接了