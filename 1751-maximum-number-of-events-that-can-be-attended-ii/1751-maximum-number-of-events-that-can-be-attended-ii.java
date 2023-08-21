class Solution {
    
    int[][] dp;
    
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events , (a, b) -> a[0] - b[0]);
        dp = new int[events.length + 1][k + 1];
        
        for(int i = 0 ; i < events.length + 1 ; i++) {
            for(int j = 0 ; j < k + 1 ; j++){
                dp[i][j] = -1;
            }
        }
        
        return solve(events, events.length, 0, k);
    }
    
    public int solve(int[][] events, int n, int i, int k) {
        if(i == n || k == 0) {
            return 0;
        }
        
        if(dp[i][k] != -1) {
            return dp[i][k];
        }
        
        int notTake = solve(events, n, i + 1, k);
        
        int idx = search(i, events);
        int take = events[i][2];
        if(idx != -1) {
            take += solve(events, n, idx, k - 1);
        }
        
        return dp[i][k] = Math.max(take, notTake);
    }
    
    public int search(int i, int[][] events) {
        int low = i + 1;
        int high = events.length - 1;
        int idx = -1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(events[mid][0] > events[i][1]) {
                idx = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return idx;
    }
}