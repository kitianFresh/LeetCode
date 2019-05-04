package array;

public class MedianOf2Sorted {
	public int findK(int[] nums1, int l1, int m, int[] nums2, int l2, int n, int k) {
        if (m > n) return findK(nums2, l2, n, nums1, l1, m, k);
        if (m == 0) return nums2[l2+k-1];
        if (k == 1) return Math.min(nums1[l1], nums2[l2]);
        int id1 = Math.min(m, k/2);
        int id2 = k - id1;
        if (nums1[l1+id1-1] < nums2[l2+id2-1]) {
            return findK(nums1, l1+id1, m - id1, nums2, l2, n, k-id1);
        }
        else if (nums1[l1+id1-1] > nums2[l2+id2-1]){
            return findK(nums1, l1, m, nums2, l2+id2, n-id2, k-id2);
        }
        else {
            return nums1[l1+id1-1];
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m+n) % 2 == 0) {
            int l = findK(nums1, 0, m, nums2, 0, n, (m+n)/2);
            int r = findK(nums1, 0, m, nums2, 0, n, (m+n)/2+1);
            System.out.println(l);
            System.out.println(r);
            return (l+r)/2.;
        }
        else {
            return findK(nums1, 0, m, nums2, 0, n, (m+n)/2+1);
        }
    }
}
