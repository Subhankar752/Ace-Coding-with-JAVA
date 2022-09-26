class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        if(k == 1){
            for(int i = k ; i < (n - k) ; i++)
                ans.add(i);
            return ans;
        }
        
        long[] inc = new long[n];
        long[] dec = new long[n];
        
        for(int i = 0 ; i < n ; i++){
            inc[i] = 1;
            dec[i] = 1;
        }
        
        for(int i = n - 1 ; i > 0 ; i--){
            if(nums[i - 1] <= nums[i]){
                inc[i - 1] += inc[i];
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            if(nums[i] <= nums[i - 1]){
                dec[i] += dec[i - 1];
            }
        }
        
        for(int i = k ; i <= (n - k) ; i++){
            long val1 = inc[i + 1];
            long val2 = dec[i - 1];
            
            if(val1 >= k && val2 >= k)
                ans.add(i);
        }
        
        return ans;
    }
}