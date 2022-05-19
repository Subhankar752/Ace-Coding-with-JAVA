class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int maxPath = 0;
        
        for(int i=0; i< matrix.length ; i++){
            for(int j =0 ; j<matrix[0].length ; j++){
                int n = lip(matrix, i, j, dp);
                maxPath = Math.max(maxPath, n);
            }
        }
        return maxPath;
    }
    
    int lip(int[][] arr, int x, int y, int[][] dp){
        if(dp[x][y] != 0){
            return dp[x][y];
        }
        int a=0;
        if(y-1 >-1 && arr[x][y-1] > arr[x][y]){
            a = lip(arr, x, y-1, dp);
        }
        int b=0;
        if(x-1 > -1 && arr[x-1][y] > arr[x][y]){
            b = lip(arr, x-1, y, dp);
        }
        int c=0;
        if(y+1 < arr[0].length && arr[x][y+1] > arr[x][y]){
            c = lip(arr, x, y+1, dp);
        }
        int d=0;
        if(x+1 < arr.length && arr[x+1][y] > arr[x][y]){
            d = lip(arr, x+1, y, dp);
        }
        int ans = Math.max(a, Math.max(b , Math.max(c, d))) + 1;
        dp[x][y] = ans;
        return ans;
    }
}