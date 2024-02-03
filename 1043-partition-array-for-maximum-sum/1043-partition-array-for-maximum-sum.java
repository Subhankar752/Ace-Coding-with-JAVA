class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] memo = new Integer[arr.length + 1];
        return withMemoization(0, arr, k, memo);
    }

    public int withMemoization(int i, int[] arr, int k, Integer[] memo) {
        if (memo[i] != null) return memo[i];

        int currMax = 0;
        int ans = 0;
        
        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            currMax = Math.max(currMax, arr[j]);
            int len = j - i + 1;
            
            int temp = (currMax * len) + withMemoization(j + 1, arr, k, memo);
            ans = Math.max(ans, temp);
        }
        
        memo[i] = ans;
        return ans;
    }
}
