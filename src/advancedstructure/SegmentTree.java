package advancedstructure;

public class SegmentTree {
	int[] st = null;
	int n;
	
	public static void main(String[] args) {
		int[] heights = {9,8,7,6,5,4,3,2,1};
		SegmentTree st = new SegmentTree(heights, heights.length);
		st.print();
//		st.modify(1, 777);
		st.print();
		System.out.println(st.querySum(0, 7));
		System.out.println(st.querySumClose(0, 7));
		
	}
	
	SegmentTree(int arr[], int n)
    {
        // Allocate memory for segment tree, index 0 not used
        st = new int[2*n]; // Memory allocation 2 * n
        this.n = n;
        // build segment tree
        for (int i=0;i<n;i++) {
        	st[n+i] = arr[i];
        }// 赋值叶节点
        for (int i=n-1;i>0;i--) {
        	st[i] = st[i<<1] + st[i<<1|1];
        }// 内部节点， 取左右节点的和
        
    }
	// sum on interval [l, r)
	public int querySum(int l, int r) {
		int sum = 0;
	/*
	 * 错误解法，如果使用 [l,r] 闭区间查询，那么会在 l == r 的时候有同时进行递归的情况，然后导致一直往父节点走，如果把 l<=r 判断改成 l < r， 那么又无法判断l=r的参数；
		for (l+=n,r+=n;l<=r;l>>=1,r>>=1) {
			if ((l&1) == 1) sum += st[l++]; // l 为奇数说明他是右子节点，需要先求和，再往后移动到后一个数；为偶数则直接往父节点走即可；
			if ((r&1) == 0) sum += st[r--]; // r 为偶数数说明是左节点
		}
		*/
		
		for (l+=n,r+=n;l<r;l>>=1,r>>=1) {
			if ((l&1) == 1) sum += st[l++]; // l 为奇数说明他是右子节点，需要先求和，再往后移动到后一个数；为偶数则直接往父节点走即可；
			if ((r&1) == 1) sum += st[--r]; // r 为奇数说明是右节点,右端点为左节点，因为规定是 左闭右开的区间 [l,r)， 必须这样写，要不然闭区间会遇到同时增长的情况，容易错误
		}
		return sum;
	}
	
	public int querySumClose(int l, int r) {
		int sum = 0;
	/*
	 * 错误解法，如果使用 [l,r] 闭区间查询，那么会在 l == r 的时候有同时进行递归的情况，然后导致一直往父节点走，如果把 l<=r 判断改成 l < r， 那么又无法判断l=r的参数；
		for (l+=n,r+=n;l<=r;l>>=1,r>>=1) {
			if ((l&1) == 1) sum += st[l++]; // l 为奇数说明他是右子节点，需要先求和，再往后移动到后一个数；为偶数则直接往父节点走即可；
			if ((r&1) == 0) sum += st[r--]; // r 为偶数数说明是左节点
		}
		*/
		if (l == r) return st[l+n]; //[0,0]
		for (l+=n,r+=n;l<r;l>>=1,r>>=1) {
			if ((l&1) == 1) sum += st[l++]; // l 为奇数说明他是右子节点，需要先求和，再往后移动到后一个数；为偶数则直接往父节点走即可；
			if ((r&1) == 0) sum += st[r--]; // r 为偶数数说明是左节点
			if (l == r) return sum += st[l];
		}
		if (l == r) return sum += st[l]; //[0,2]
		return sum;
	}
	
	public void modify(int p, int value) {
		p += n;
		st[p] = value;
		for (p>>=1;p>0;p>>=1) {
			st[p] = st[p<<1] + st[p<<1|1];
		}
	}
	
	public void print() {
		for (int i=1; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
	}
	
	public void printArray(int[] arr) {
		for (int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}