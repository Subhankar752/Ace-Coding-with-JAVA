class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for(int i = 0 ; i < 32 ; i++){
            int res = 0;
            for(int j : candidates){
                int bit = (j >> i) & 1;
                if(bit == 1)
                    res++;
            }
            ans = Math.max(ans , res);
        }
        return ans;
    }
}