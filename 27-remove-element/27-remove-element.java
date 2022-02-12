class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i : nums){
            if(i == val)
                k++;
        }
        int ans = nums.length - k;
        int j = nums.length - 1;
        Arrays.sort(nums);
        for(int i = 0 ; i < ans ; i++){
            if(nums[i] == val){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j--;
            }
        }
        return ans;
    }
}