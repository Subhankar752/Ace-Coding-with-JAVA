class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int k = 0;
        int l = n - 1;
        int[] ans = new int[n];
        for(int i : nums){
            if(i % 2 == 0){
                ans[k++] = i;
            }
            else{
                ans[l--] = i;
            }
        }
        return ans;
    }
}