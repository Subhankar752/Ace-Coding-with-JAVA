class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            int j = i;
            while(j != 0){
                ans[i] += j%2;
                j /= 2;
            }
        }
        return ans;
    }
}