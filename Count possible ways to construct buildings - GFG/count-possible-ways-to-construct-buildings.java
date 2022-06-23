// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int n)
    {
        // Code here
        long mod = 1000000007;
        long a[] = new long[100002];
        a[0] = 1;
	    a[1] = 1;
	   
	   for(int i = 2 ; i < 100002 ; i++)
	   a[i]=(a[i - 1] + a[i - 2]) % mod;
	   return (int)((a[n + 1] * a[n + 1]) % mod);
    }
}