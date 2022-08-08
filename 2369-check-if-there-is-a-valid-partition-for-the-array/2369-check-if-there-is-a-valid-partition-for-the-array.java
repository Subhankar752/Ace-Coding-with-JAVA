class Solution {
    Boolean dp[];
    public boolean solve(int arr[] , int i){
        if(i >= arr.length)   
            return true;
        
        if(dp[i] != null) 
            return dp[i];
        if(i <= (arr.length - 3) && arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]){
            return dp[i] = solve(arr , i + 2) || solve(arr , i + 3);
        }
        if(i <= (arr.length - 2) && arr[i] == arr[i + 1]){
            return  dp[i] = solve(arr , i + 2);
        }
        if(i <= (arr.length - 3)){
            if((arr[i + 1] - arr[i]) == 1 && (arr[i + 2] - arr[i + 1]) == 1){
                return dp[i] = solve(arr , i + 3);
            }
        }
        System.out.println(i);
        return false;
    }
    public boolean validPartition(int[] nums) {
        dp = new Boolean[nums.length];
        return solve(nums , 0);
    }
}