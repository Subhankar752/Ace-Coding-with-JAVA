// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int[]pre=new int[n];
        pre[0]=freq[0];
        for(int i=1;i<n;i++)pre[i]=(pre[i-1]+freq[i]);
        int[][]dp=new int[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                if(g==0)dp[i][j]=freq[i];
                else if(g==1){
                    int f1=dp[i][j-1];
                    int f2=dp[i+1][j];
                    dp[i][j]=Math.min(f1+2*f2,2*f1+f2);
                }
                else{
                    int min=Integer.MAX_VALUE;
                    int fs=pre[j]-(i==0?0:pre[i-1]);
                    for(int k=i;k<=j;k++){
                        int left=k==i?0:dp[i][k-1];
                        int right=k==j?0:dp[k+1][j];
                        if(left+right+fs<min)min=left+right+fs;
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[0][n-1];
    }
}
