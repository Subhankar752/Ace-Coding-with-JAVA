class Solution {
    
    private int minK;
    private int maxK;
    
    private long countOfSubarraysInSpilttedSubarray(List<Integer> subarray) {
        long cnt = 0;
        int n = subarray.size();
        
        int[] maxKPositions = new int[n + 1];
        Arrays.fill(maxKPositions, n); 
        
        int[] minKPositions = new int[n + 1];
        Arrays.fill(minKPositions, n);
        
        for(int i = n - 1; i >= 0; i -= 1) {
            maxKPositions[i] = subarray.get(i) == maxK ? i : maxKPositions[i + 1];
            minKPositions[i] = subarray.get(i) == minK ? i : minKPositions[i + 1];
        }
        
        for(int i = 0; i < n; i += 1) {
            int firstIndexBothIncluded = Math.max(maxKPositions[i], minKPositions[i]);
            cnt += (n - firstIndexBothIncluded);
        }
        
        return cnt;
    }
    
    public long countSubarrays(int[] nums, int minK, int maxK) {
        this.minK = minK; this.maxK = maxK;
        long countOfSubarray = 0;
        List<Integer> subarray = new ArrayList<>();
        for(int i = 0; i < nums.length; i += 1) {
            if(nums[i] < minK || nums[i] > maxK) {
                countOfSubarray += countOfSubarraysInSpilttedSubarray(subarray);
                subarray.clear(); 
            } else 
                subarray.add(nums[i]);
        }
        countOfSubarray += countOfSubarraysInSpilttedSubarray(subarray);
        return countOfSubarray;
    }
}