class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] a = new int[2 * n];
        for(int i = 0 ; i < n ; i++)
            a[i] = nums[i];
        int j = 0;
        for(int i = n ; i < 2 * n ; i++)
            a[i] = nums[j++];
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            int val = nums[i];
            ans[i] = -1;
            for(j = i + 1 ; j < n + i ; j++){
                if(val < a[j]){
                    ans[i] = a[j];
                    break;
                }
            }
        }
        return ans;
    }
}