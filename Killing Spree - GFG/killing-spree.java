// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            long ans = ob.killinSpree(N);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long killinSpree(long n)
    {
        // Code Here
        long ans = 0L;
        long i = 1;
        while(i * i <= n){
            n -= (i * i);
            ans++;
            i++;
        }
        return ans;
    }
}
