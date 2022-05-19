// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        // code here
        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        String st1 = new String(s1);
        String st2 = new String(s2);
        if(!st1.equals(st2))
            return -1;
        int n = A.length();
        int i = n - 1;
        int j = n - 1;
        int ans = 0;
        
        while(i >= 0 && j >= 0){
            char c1 = A.charAt(i);
            char c2 = B.charAt(j);
            if(c1 == c2){
                i--;
                j--;
            }
            else{
                i--;
                ans++;
            }
        }
        return ans;
    }
}