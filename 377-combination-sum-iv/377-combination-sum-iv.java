class Solution {
    
    HashSet<String> hs = new HashSet<>();
    int ans;
    public int combinationSum4(int[] N , int T) {
//         ans = 0;
//         solve(nums , target , 0 , 0);
        
//         return ans;
         int[] dp = new int[T+1];
        dp[0] = 1;
        for (int i = 1; i <= T; i++)
            for (int num : N)
                if (num <= i) dp[i] += dp[i-num];
        return dp[T];
    }
    public void solve(int[] nums , int k , int idx , int sum){
        
        if(sum > k)
            return;
        if(sum == k){
            //System.out.println(123);
            ans++;
            return;
        }
        
        for(int i = idx ; i < nums.length ; i++){ 
            sum += nums[i];
            solve(nums , k , idx , sum);
            sum -= nums[i];
        }
    }
}