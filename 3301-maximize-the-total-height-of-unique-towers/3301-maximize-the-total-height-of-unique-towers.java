class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        Arrays.sort(maximumHeight);
        
        long sum = 0;
        int lastAssignedHeight = Integer.MAX_VALUE;
        
        for (int i = n - 1; i >= 0; i--) {
            int currentHeight = Math.min(maximumHeight[i], lastAssignedHeight - 1);
            
            if (currentHeight < 1) {
                return -1;
            }
            
            sum += currentHeight;
            lastAssignedHeight = currentHeight;
        }
        
        return sum;
    }
}