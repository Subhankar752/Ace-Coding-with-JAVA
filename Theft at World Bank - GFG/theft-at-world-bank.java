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
            String s1 = br.readLine().trim();
            String []S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            long C = Long.parseLong(S1[1]);
            String s2 = br.readLine().trim();
            String []S2 = s2.split(" ");
            long [] w = new long[n];
            long [] p = new long[n];
            for(int i = 0; i < n; i++){
                w[i] = Long.parseLong(S2[2*i]);
                p[i] = Long.parseLong(S2[(2*i)+1]);
            }
            Solution ob = new Solution();
            double ans = ob.maximumProfit(n, C, w, p);
            String a1 = String.format("%.3f",ans);
            System.out.println(a1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Pair{
        long wt;
        long pr;
        double ratio;
        
        Pair(long wt , long pr , double ratio){
            this.wt = wt;
            this.pr = pr;
            this.ratio = ratio;
        }
    }
    
    public double maximumProfit(int n, long c, long w[], long p[])
    {
        // Code here
        Pair[] a = new Pair[n];
        for(int i = 0 ; i < n ; i++){
            double ratio = (p[i] * 1.0)/w[i];
            a[i] = new Pair(w[i] , p[i] , ratio);
        }
        
        Arrays.sort(a , (aa , bb) -> bb.ratio > aa.ratio ? 1 : bb.ratio == aa.ratio ? 0 : -1);
        
        double ans = 0.0;
        
        for(int i = 0 ; i < n ; i++){
            long wt = a[i].wt;
            if(isPerfect(wt) == true){
                continue;
            }
            if(c >= wt){
                c -= wt;
                ans += a[i].pr;
            }
            else{
                double val = a[i].ratio * c;
                ans += val;
                c = 0;
            }
        }
        return ans;
    }
    
    public boolean isPerfect(long n){
        long p = (long)Math.sqrt(n);
        long val = p * p;
        if(val == n)
        return true;
        return false;
    }
}