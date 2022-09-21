class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int ans = 0;
        
        for(int i : nums) if(i % 2 == 0) ans += i;
        
        int l = queries.length;
        int[] f = new int[l];
        
        for(int ind = 0 ; ind < l ; ind++){
            int val = queries[ind][0];
            int index = queries[ind][1];
            
            if(nums[index] % 2 == 0 && val % 2 != 0){
                ans -= nums[index];
            }
            
            else if(nums[index] % 2 == 0 && val % 2 == 0){
                ans += val;
            }
            
            else if(nums[index] % 2 != 0 && val % 2 != 0){
                ans += nums[index] + val;
            }
           
            nums[index] += val;
            f[ind] = ans;
        }
        
        return f;
    }
}