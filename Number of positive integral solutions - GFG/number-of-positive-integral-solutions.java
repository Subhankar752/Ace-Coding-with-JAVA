// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.posIntSol(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   long posIntSol(String s)
   {
       String []eqs = s.split("\\=");
       int num = Integer.parseInt(eqs[1]);
       int variables = 1;
       
       for(int i=0;i <eqs[0].length() ;i++ ){
           if(eqs[0].charAt(i) == '+' ){
               variables++;
           }
       }
       long ans = soln(variables , num);
       return ans;
   }
   
   long soln(int variables , int num){
       if(num < variables )return  0;
       
       if(variables == 2) return num - 1;
       
       long count = 0;
       for(int i=1; i<= (num -variables + 1  ) ;  i++){
           count+= soln(variables -1 , num - i);
       }
       return count;
   }
}