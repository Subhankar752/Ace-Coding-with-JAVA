// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int c=0,k=0;
   ArrayList<Integer> o1  = new ArrayList<Integer>();
   void towerOfHanoi(int n, int from_rod, int to_rod, int aux_rod)
   {
       if (n == 0 || c>=k)
       {
           return;
       }
       towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
         c++;
         if(c==k)
         {
             o1.add(from_rod);
             o1.add(to_rod);
         }
       towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
   }
   List<Integer> shiftPile(int N, int n){
       k=n;
     towerOfHanoi(N,1,3,2);
     return o1;
   }
}