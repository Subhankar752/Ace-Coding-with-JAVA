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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPalindrome(String s){
       int len=s.length();
       int i=0;
       int j=len-1;
       while(i<j){
           if(s.charAt(i)==s.charAt(j)){
               i++;
               j--;
           }else{
               return false;
           }
       }
       return true;
   }
   static String longestPalin(String S){
       // code here
       String longStr=Character.toString(S.charAt(0));
       int len=S.length();
       for(int i=0;i<len-1;i++){
           for(int j=i+1;j<=len;j++){
               boolean flag=isPalindrome(S.substring(i,j));
               if(flag){
                   if(longStr.length()<S.substring(i,j).length()){
                       longStr=S.substring(i,j);
                   }
               }
           }
       }
       return longStr;
   }

}