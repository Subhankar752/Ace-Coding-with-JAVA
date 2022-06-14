// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        // Complete this function
         int l = 0;
          int h = 5 * n;
          int ans = 0;
          while(l <= h)
          {
              int m = (l + h) / 2;
              int zeroes = help(m);
              if(zeroes >= n)
              {
                  ans = m;
                  h = m - 1;
              }
              else 
                l = m + 1;
          }
        
           return ans;
    }
    int help(int a){
            int temp = a; 
            int res = 0; 
            for(int i = 5; i <= a; i *=5 ){ 
                res += temp/i; 
            } 
            return res;
    }
}