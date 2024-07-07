class Solution {
    public int numberOfAlternatingGroups(int[] a, int k) {
        int n = a.length;
        int ans = 0;
        int[] nums = new int[n + k - 1];
        int[] pre = new int[n + k - 1];
        
        int c = 0;
        for (int i = 0 ; i < n + k - 1 ; i++) {
            if (i < n) {
                nums[i] = a[i];
            }
            else {
                nums[i] = a[c];
                c++;
            }
        }
        
        pre[0] = 1;
        for (int i = 1 ; i < n + k - 1 ; i++) {
            if (nums[i] != nums[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            }
            else {
                pre[i] = 1;
            }
        }
        
        for (int i : pre) {
            if (i >= k) {
                ans++;
            }        
        }
        
        return ans;
    }
}