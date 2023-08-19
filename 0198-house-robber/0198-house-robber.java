class Solution {
    
    static int helper2(int arr[], int idx, int dp[]){

        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        else{
            int a = arr[idx]+helper2(arr,idx+2,dp);
            int b = helper2(arr,idx+1,dp);
            return dp[idx] = Math.max(a,b);
        }
    }

    public int rob(int[] arr) {
        int n = arr.length;

        int dp[] = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = -1;
        }

        return helper2(arr,0,dp);
    }
}