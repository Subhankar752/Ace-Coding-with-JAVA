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
            long S = Long.parseLong(a[0]);
            int N = Integer.parseInt(a[1]);
            long X = Long.parseLong(a[2]);
            String a1[] = in.readLine().trim().split("\\s+");
            long A[] = new long[N];
            for(int i = 0;i < N;i++)
                A[i] = Long.parseLong(a1[i]);
            
            Solution ob = new Solution();
            if(ob.isPossible(S, N, X, A) == 1)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isPossible(long S, int N, long X, long A[])
    {
        // code here
        ArrayList<Long> temp=new ArrayList<>();
       temp.add(S);
       long sum=0;
       long runningsum=0;
       temp.add(S+A[0]);
       runningsum=temp.get(0)+temp.get(1);
       for(int i=1;i<N;i++){
           sum=A[i]+runningsum;
           if(sum >X){
               break;
           }
           temp.add(sum);
           runningsum+=sum;
       }
       int res=0;
       for(int i=temp.size()-1;i>=0;i--){
           if(temp.get(i) >X){
               continue;
           }
           else{
               X-= temp.get(i);
           }
           if(X==0){
               return 1;
           }
       }
       return res;
    }
}