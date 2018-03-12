package swordoffer;

public class SeqOfPostOrder {
	// [二叉搜索树的后序遍历序列](https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	public boolean VerifySequenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return postOrderCheck(sequence, 0, sequence.length-1);
    }
    
    public boolean postOrderCheck(int[] sequence, int l, int r) {
        if (l >= r) return true;
        int index = l;
        while (index < r && sequence[index] < sequence[r]) index ++;
        int mid = index;
        while (index < r && sequence[index] > sequence[r]) index ++;
        if (index != r) return false;
        return postOrderCheck(sequence, l, mid-1) && postOrderCheck(sequence, mid, r-1);
    }
}
