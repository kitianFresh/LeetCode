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
Linux文件转码工具
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

Ubuntu package manager broken & gnome-software 100% cpu

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