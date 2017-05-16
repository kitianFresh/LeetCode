# Array
 - [189. Rotate Array](https://leetcode.com/problems/rotate-array/#/description)
 - [61. Rotate List](https://leetcode.com/problems/rotate-list/#/description)
 - [33. Search in Rotated Sorted Array未做](https://leetcode.com/problems/search-in-rotated-sorted-array/#/description)
 - [153. Find Minimum in Rotated Sorted Array未做](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description)
 - [440. K-th Smallest in Lexicographical Order未做](https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/#/description)
 - [牛客-左右最值最大差-未做](https://www.nowcoder.com/practice/f5805cc389394cf69d89b29c0430ff27?tpId=49&&tqId=29359&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking)
 - [牛客网-有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。给定数组A及它的大小n，请返回最大差值。](https://www.nowcoder.com/practice/1f7675ae7a9e40e4bd04eb754b62fd00?tpId=49&tqId=29281&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2F2016test%2Fquestion-ranking&tPage=1)
 - [牛客网-排序形式的相邻最大差值](https://www.nowcoder.com/practice/376ede61d9654bc09dd7d9fa9a4b0bcd?tpId=49&tqId=29366&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2F2016test%2Fquestion-ranking&tPage=5)
 
## 基于排序的算法
基于排序的算法，本质上是需要排序或者在排序的过程中计算，如果是基于比较的排序，那么他的下界可以使用决策树证明是 O(nlgn);基于比较的算法都是通过交换或者移动一次，来减少逆序数，直到逆序数消失！！一个1～n的数组，最大逆序数当然是 n(n-1)/2; 最小是0; 对于冒泡排序和插入排序，由于每次比较交换或者移动都只是减少一个逆序对，因此逆序对的数目可以通过这个两个排序过程中交换或移动次数来决定！

对于题目特殊交换，由于每次只能交换相邻的两个数，即每次最多只可能减少一个逆序对，因为相邻两数的交换，即不影响他们前面的数，也不影响他们后面的数的逆序数！可以证明，最后要想排好序，必须交换数组中逆序数个数的次数。即最少交换数就是逆序数个数。
 - [牛客网-特殊交换](https://www.nowcoder.com/questionTerminal/a619f76bcd034124bb4ab726506364c9?toCommentId=106891)
 - [算法导论-逆序数]()
 - [牛客网-搜狗矩阵元素相乘-未做](https://www.nowcoder.com/questionTerminal/935fbb71542345ef87a7acc190e2577b?orderByHotValue=1&difficulty=00100&commentTags=C/C++)
 - [牛客网-挑选镇长](https://www.nowcoder.com/questionTerminal/01c630ecb9cf42738d37788c2a0fbc83)
 
## BestTimeBuyStock 系列
 - [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description)
 - [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description)
 - [123. Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/#/description)
 - [188. Best Time to Buy and Sell Stock IV未做](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/#/description)
 - [309. Best Time to Buy and Sell Stock with Cooldown未做](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/#/description)

### 参考
 - [Best Time to Buy and Sell Stock 买卖股票的最佳时机](https://segmentfault.com/a/1190000003483697)
 
## SignleNumber 系列
 - [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/#/solutions)
 - [136. Single Number](https://leetcode.com/problems/single-number/#/description)
 - [137. Single Number II](https://leetcode.com/problems/single-number-ii/#/description)
 - [260. Single Number III](https://leetcode.com/problems/single-number-iii/#/description)
 - [268. Missing Number](https://leetcode.com/problems/missing-number/#/description)
 - [389. Find the Difference](https://leetcode.com/problems/find-the-difference/#/description)
 - [41. First Missing Positive**hard未做](https://leetcode.com/problems/first-missing-positive/#/description)
 - [350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/#/description)
 - [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/#/description)
 - [421. Maximum XOR of Two Numbers in an Array未做](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/#/description)

## 新增
 - [480. Sliding Window Median未做](https://leetcode.com/problems/sliding-window-median/#/description)
 - [239. Sliding Window Maximum未做](https://leetcode.com/problems/sliding-window-maximum/#/description)
 - [316. Remove Duplicate Letters未做](https://leetcode.com/problems/remove-duplicate-letters/#/description)
 - [42. Trapping Rain Water未做](https://leetcode.com/problems/trapping-rain-water/#/description)
 
## 字符串系列
### 回文串
 - [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/#/description)
 - [516. Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/#/description)
 - [115. Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/#/description)
 - [336. Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/#/description)
 - [214. Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/#/description)
 
#### 参考
 - [Manacher](https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.05.md)
 - [Manacher's ALGORITHM: O(n)时间求字符串的最长回文子串  不指定]()

### LCS LCStr LIS LCSD
 - [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/#/description)
 - [334. Increasing Triplet Subsequence未做](https://leetcode.com/problems/increasing-triplet-subsequence/#/description)
 - [354. Russian Doll Envelopes未做hard](https://leetcode.com/problems/russian-doll-envelopes/#/description)
