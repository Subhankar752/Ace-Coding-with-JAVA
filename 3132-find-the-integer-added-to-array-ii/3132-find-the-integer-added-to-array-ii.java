class Solution {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n = nums1.length, ans = Integer.MAX_VALUE;
        int[] diffs = { nums2[0] - nums1[0], nums2[0] - nums1[1], nums2[0] - nums1[2] };
        
        for (int diff : diffs) {
            int j = 0, deleted = 0;
        
            for (int i = 0; i < n && j < n - 2; i++) {
                if (nums2[j] - nums1[i] != diff) {
                    deleted++;
                } else {
                    j++;
                }
                if (deleted > 2) {
                    break;
                }
            }
            
            if (j == n - 2) {
                ans = Math.min(ans, diff);
            }
        }
        
        return ans;
    }
}
