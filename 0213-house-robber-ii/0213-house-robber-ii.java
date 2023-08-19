class Solution {
    static int helper1(int arr[], int idx, int dp[]){

        if(idx>=arr.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        else{
            int a = arr[idx]+helper1(arr,idx+2,dp);
            int b = helper1(arr,idx+1,dp);
            return dp[idx] = Math.max(a,b);
        }
    }

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

        if(n<=3){
            if(n==1) return arr[0];
            else if(n==2) return Math.max(arr[0],arr[1]);
            else{
                return Math.max(arr[0],Math.max(arr[1],arr[2]));
            }
        }

        int dp[] = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = -1;
        }

        int robbedHouse1 = helper1(arr,0,dp);

        for(int i=0; i<n; i++){
            dp[i] = -1;
        }
        int robbedHouse2 = helper2(arr,1,dp);

        return Math.max(robbedHouse1,robbedHouse2);
    }
}