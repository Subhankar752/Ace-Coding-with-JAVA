// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            
            String s[] = new String[n];
            for(int i=0;i<n;i++)
            {
                s[i] = sc.next();
            }
            Solution T = new Solution();
            System.out.println(T.lcp(s,n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String lcp(String s[] , int n)
    {
        // Write your code here
        String ans = s[0];
        for(int i = 1 ; i < n ; i++){
            String temp = solve(ans , s[i]);
            ans = temp;
        }
        if(ans == "")
        return "-1";
        return ans;
    }
    public String solve(String a , String b){
        String ans = "";
        
        int i = 0 ;
        int j = 0;
        int n1 = a.length();
        int n2 = b.length();
        while(i < n1 && j < n2){
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            if(c1 != c2)
            break;
            ans += c1;
            i++;
            j++;
        }
        
        return ans;
    }
}
