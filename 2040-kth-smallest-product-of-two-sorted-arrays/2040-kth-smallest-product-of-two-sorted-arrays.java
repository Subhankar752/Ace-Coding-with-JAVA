class Solution {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = (long) -10e10, hi = (long) 10e10;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (check(nums1, nums2, mi) >= k) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

    private long check(int[] nums1, int[] nums2, long target) {
        long res = 0;
        for (int num : nums1) {
            if (num < 0) {
                res += find1(nums2, (long) num, target);
            } else if (num > 0) {
                res += find2(nums2, (long) num, target);
            } else {
                res += target >= 0 ? nums2.length : 0;
            }
        }
        return res;
    }

    private int find1(int[] nums2, long n1, long target) {
        int lo = 0, hi = nums2.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (n1 * nums2[mi] <= target) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return nums2.length - lo;
    }

    private int find2(int[] nums2, long n1, long target) {
        int lo = 0, hi = nums2.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (n1 * nums2[mi] > target) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }
}
