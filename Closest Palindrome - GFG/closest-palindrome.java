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
            long num = Long.parseLong(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.closestPalindrome(num);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long closestPalindrome(long num)
    {
        // Code here
    String st=String.valueOf(num);
       int len=st.length();
       if(len==1)
       return num;
       int pow=len%2==0?(len/2-1):len/2;
       long left=Long.parseLong(st.substring(0,pow+1));
       List<Long> res=new ArrayList();
       res.add(getp(left,len%2==0));
       res.add(getp(left+1,len%2==0));
       res.add(getp(left-1,len%2==0));
       res.add((long)Math.pow(10,len-1)-1);
       res.add((long)Math.pow(10,len+1)+1);
       long ans=0,diff=Integer.MAX_VALUE;
       for(long l:res)
       {
           if(Math.abs(l-num)<diff)
           {
               diff=Math.abs(l-num);
               ans=l;
           }
           else if(Math.abs(l-num)==diff)
           ans=Math.min(ans,l);
       }
       return ans;
   }    
   static long getp(long s,boolean even)
   {
       long res=s;
       if(!even)
       s=s/10;
       while(s>0)
       {
           res=res*10+s%10;
           s=s/10;
       }
       return res;
       
   }
  }