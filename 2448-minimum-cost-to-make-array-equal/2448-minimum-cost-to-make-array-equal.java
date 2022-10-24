class Solution {
   public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        
        //******** This part is just for sorting nums in ascending order and shuffling cost respectively
        int[][] pairs = new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0] = nums[i];   pairs[i][1] = cost[i];
        }
        Arrays.sort(pairs, (o1,o2)->{
            if(o1[0]!=o2[0]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        for(int i=0;i<n;i++){
            nums[i] = pairs[i][0];   cost[i] = pairs[i][1];
        }
        //******** Sorting done here
      
        long[] pre = new long[n];
        long[] pos = new long[n];
        
        pre[0] = 0; long totalCost = cost[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + ((nums[i]-nums[i-1])*totalCost);
            totalCost+=cost[i];
        }
        
        pos[n-1] = 0; totalCost = cost[n-1];
        for(int i=n-2;i>=0;i--){
            pos[i] = pos[i+1] + ((nums[i+1]-nums[i])*totalCost);
            totalCost+=cost[i];
        }
        
        long min = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long curr = pre[i]+pos[i];
            min = Math.min(min, curr);
        }
        return min;
    }
}