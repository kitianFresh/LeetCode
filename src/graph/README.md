# 图
一种保存两点之间路径的方法是,使用一个数组,这个数组采用 树的 双亲数组表示法! 因为 DFS 递归遍历的过程中会获得一棵最小生成树, 因此如果要保存起点到其他连通点的所有路径,使用一个 **双亲表示法的数组树** 即可得到所有的路径.