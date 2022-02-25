// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution{
    public static String moveRobots(String s1, String s2){
        //code here
         if(s1.equals(s2)) return "Yes";
       int i = 0; int j = 0;
       while(j<s1.length()){
          if(s2.charAt(j)=='#') {
              j++;
              continue;
          }
           if(s2.charAt(j)=='A'){
               while(i<s1.length() && s1.charAt(i)=='#') i++;
               if(i<j || s1.charAt(i) == 'B' || i>=s1.length()) return "No";
               i++;
               j++;
               continue;
           }
            if(s2.charAt(j)=='B'){
               while(i<s1.length() && s1.charAt(i)=='#') i++;
               if(i>j || s1.charAt(i) == 'A' || i>=s1.length()) return "No";
               i++;
               j++;
               continue;
           }  
       }
       while(i<s1.length() && s1.charAt(i)=='#') i++;
       if(i!=j) return "No";
       return "Yes";
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s1=read.readLine();
            String s2=read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.moveRobots(s1, s2));
        }
    }
}  // } Driver Code Ends