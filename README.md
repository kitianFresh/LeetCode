# LeetCode
Code Algorithms



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