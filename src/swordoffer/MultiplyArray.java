package swordoffer;

public class MultiplyArray {
	// [牛客-构建乘积数组](https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	// 递归定义子问题　假设已知　A[n] 的乘积数组　B[n], 则　Ａ[n+1] 的乘积数组　B[n+1]就可以通过如下方式构造；
    // B[i] = B[i] * A[n+1] if i <= n
    // B[n+1] = A[0]*A[1]*...A[n] if i = n+1
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        multiply(A, B, n);
        return B;
    }
    public void multiply(int[] A, int[] B, int n) {
        if (n == 2) {
            B[0] = A[1];
            B[1] = A[0];
            return;
        }
        multiply(A, B, n-1);
        B[n-1] = 1;
        for (int i = 0; i < n - 1; i ++) {
            B[i] = B[i] * A[n-1];
            B[n-1] *= A[i];
        }
        return ;
    }
    
    // 法二，尾递归可以直接转换为for loop
    public int[] multiply１(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        B[0] = A[1];
        B[1] = A[0];
        for (int i = 2; i < n; i ++) {
            B[i] = 1;
            for (int j = 0; j < i; j++) {
                B[j] *= A[i];
                B[i] *= A[j];
            }
        }
        return B;
    }
}
