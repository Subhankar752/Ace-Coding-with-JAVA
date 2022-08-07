class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    int val1 = nums[j] - nums[i];
                    int val2 = nums[k] - nums[j];
                    if(val1 == diff && val2 == diff)
                        ans++;
                }
            }
        }
        
        return ans;
    }
}