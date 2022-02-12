// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.newIPAdd(s));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String newIPAdd(String S)
    {
        // your code here
        String[] st = S.split("\\D");
        String ans = "";
        for(int i = 0 ; i < st.length ; i++){
            if(i == st.length - 1){
                ans = ans + solve(st[i]);
            }
            else
            ans = ans + solve(st[i]) + ".";
        }
        return ans;
    }
    public String solve(String st){
        String ans = "";
        boolean first = true;
        for(int i = 0 ; i < st.length() ; i++){
            char ch = st.charAt(i);
            if(ch == '0' && first == true){
                continue;
            }
            else{
                first = false;
                ans = ans + ch;
            }
        }
        if(ans.equals(""))
        return "0";
        return ans;
    }
}