class Solution {
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int n = startTime.length;
        dp = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) {
            dp[i] = -1;
        }
        
        for(int i = 0 ; i < n ; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(startTime[i]);
            l.add(endTime[i]);
            l.add(profit[i]);
            list.add(l);
        }
        
        Collections.sort(list, (a, b) -> a.get(0) - b.get(0));
        
        return solve(0, n, list);
    }
    
    public int solve(int i, int n, ArrayList<ArrayList<Integer>> list) {
        if(i >= n) {
            return 0;
        }
        
        if(dp[i] != -1) {
            return dp[i];
        }
        
        int notTake = solve(i + 1, n, list);
        
        int take = list.get(i).get(2);
        
        int search = find(i, list);
        if(search != -1) {
            take += solve(search, n, list);
        }
        
        return dp[i] = Math.max(take, notTake);
    }
    
    public int find(int i, ArrayList<ArrayList<Integer>> list) {
        int idx = -1;
        
        // for(int j = i + 1 ; j < list.size() ; j++) {
        //     if(list.get(j).get(0) >= list.get(i).get(1)) {
        //         return j;
        //     }
        // }

        int low = i + 1;
        int high = list.size() - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if (list.get(mid).get(0) >= list.get(i).get(1)) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return idx;
    }
}