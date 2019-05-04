package advancedstructure;

public class SegmentSumTree {
	public static void main(String[] args) {
		int[] heights = new int[]{6, 2, 5, 4, 5, 1, 6};
		SegmentSumTree sst = new SegmentSumTree(heights);
		sst.constructTree(1, 0, heights.length-1);
		sst.print();
		System.out.println(sst.querySum(0, heights.length-1, 1, 4));
	}
	
	int[] st = null;
	int n = 0;
	SegmentSumTree(int[] arr) {
		if (arr == null) return;
		n = arr.length;
		st = new int[2*n]; // 线段树是平衡二叉树，节点数满足 n 个叶节点和 n-1 个内部节点；这里为了能够以 1 为下标， 分配 2n 个空间；
		
		for (int i=0;i<n;i++) {
			st[n+i] = arr[i];
		}
	}
	
	public int constructTree(int cur, int ss, int se) {
		if (ss > se || se > n-1) throw new IllegalArgumentException();
		if (ss == se) return st[n+ss];
		int mid = (ss+se)/2;
		st[cur] = constructTree(2*cur, ss, mid) + constructTree(2*cur+1, mid+1, se);
		return st[cur];
	}
	// 查询[l,r]区间元素的和；
	public int querySum(int ss, int se, int l, int r) {
		if (l > r || r > n-1) throw new IllegalArgumentException();
		int mid = (ss+se)/2;
		if (l == r) return st[n+l];
		
		else if (l > mid) { //在 右子树
			return querySum(mid+1, se, l, r);
		}
		else if (r < mid+1) { //在 左子树
			return querySum(ss, mid, l, r);
		}
		else {
			return querySum(ss, mid, l, mid) + querySum(mid+1, se, mid+1, r);
		}
	}
	
	public void print() {
		for (int i = 1; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
	}
}
