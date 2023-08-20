class Solution {
    int[] dp;
    
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers , (a , b) -> a.get(0) - b.get(0));
        int size = offers.size();
        
        dp = new int[size + 1];
        
        for(int i = 0 ; i < dp.length ; i++) {
            dp[i] = -1;
        }
        
        return solve(offers , 0 , size);
    }
    
    public int solve(List<List<Integer>> a, int i, int n) {
        if(i >= n) {
            return 0;
        }
        
        if(dp[i] != -1) {
            return dp[i];
        }
        
        int notTake = solve(a, i + 1, n);
        
        int take = a.get(i).get(2);
        
        int idx = search(i, a, n);
        if(idx != -1) {
            take += solve(a, idx, n);
        }
        
        return dp[i] = Math.max(take, notTake);
    }
    
    public int search(int idx, List<List<Integer>> a, int n) {
        int k = -1;
        
        // for(int i = idx + 1 ; i < n ; i++) {
        //     if(a.get(i).get(0) > a.get(idx).get(1)) {
        //         k = i;
        //         break;
        //     }
        // }
        
        int low = idx + 1;
        int high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(a.get(mid).get(0) > a.get(idx).get(1)) {
                k = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return k;
    }
}