package sort;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
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
}
