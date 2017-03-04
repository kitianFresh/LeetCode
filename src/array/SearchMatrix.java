package array;

public class SearchMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 4, 7,11,15},
				{ 2, 5, 8,12,19},
				{ 3, 6, 9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
		};
		
		SearchMatrix smt = new SearchMatrix();
		System.out.println(smt.searchMatrix(matrix,19));
		System.out.println(smt.searchMatrix1(matrix,20));
	}
	
	// O(m+n) 根据左下角的元素是每一列的最大值，每一行的最小值，据此可以排除一行或者一列
    public boolean searchMatrix1(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i,j;
        i = m-1;j=0;
        while (i>=0 && j<=n-1) {
        	if (matrix[i][j] > target) {
        		i --;
        	}
        	else if (matrix[i][j] < target) {
        		j ++;
        	}
        	else {
        		return true;
        	}
        }
    	return false;
    }
	
	// 每一行可以进行 lgn 的二分查找,每次分成上下两半，top，down表示上下 O(mlgn)
	public boolean searchMatrixBin(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length; //每一行长度
		for (int i=0;i<m;i++) {
			if (binarySearch(matrix[i],0,n-1,target)) return true;
		}
		return false;
	}
	public boolean binarySearch(int[] arr, int start, int end, int target) {
		if (arr == null || arr.length == 0) return false;
		int mid;
		while (start<=end) {
			mid = (start+end)/2;
			if (arr[mid] > target) {
				end = mid - 1;
			}
			else if (arr[mid] < target) {
				start = mid + 1;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	// (i,j)左上角，(k,l)右下角, 栈爆了，这种分治方法又是不均衡的，可能导致极不平衡
    public boolean searchMatrixDC1(int[][] matrix, int i, int j, int k, int l, int target) {
        if (i == j && j == k && k == l) return matrix[i][j]==target;
        int midx,midy;
        midx = (j+l)/2;
        midy = (i+k)/2;
        if (matrix[midy][midx] > target) {
            return searchMatrixDC1(matrix,i,j,midy,midx,target);
        }
        else if (matrix[midy][midx] < target) {
            return searchMatrixDC1(matrix,midy+1,j,k,midx,target) || searchMatrixDC1(matrix,i,midx+1,midy,l,target) || searchMatrixDC1(matrix,midy+1,midx+1,k,l,target);
        }
        else {
            return true;
        }
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        return searchMatrixBin(matrix,target);
    }
    
}
