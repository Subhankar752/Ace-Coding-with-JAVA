// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int row, int col, int mat[][]) {
        // code here
         int[] cal = new int[row];
	     int sum = 0;
	     int maxSum = Integer.MIN_VALUE;
	     
	     for(int left = 0 ; left < col ; left++){
	         
	         for(int i = 0 ; i < row ; i++)
	            cal[i] = 0;
	            
	         for(int right = left ; right < col ; right++){
	             
	             for(int i = 0 ; i < row ; i++)
	                 cal[i] += mat[i][right];
	                 
	                sum = kadane(cal , row);
	                maxSum = Math.max(sum , maxSum);
	             }
	         }
	     
	     return maxSum;
	 }
	 
	 public static int kadane(int[] arr,int n){
	     int lc = arr[0];
        int mc = arr[0];
        for(int i = 1 ; i < n ; i++){
            lc = Math.max(lc + arr[i] , arr[i]);
            mc = Math.max(lc , mc);
        }
        return mc;
	 }
};