// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}// } Driver Code Ends


class Solution {
    static class pair{
       int ai,bi;
       pair(int Ai, int Bi){
           ai=Ai;
           bi=Bi;
       }
       int getBi(){
           return bi;
       }
       int getAi(){
           return ai;
       }
   }
   static int maxCoins(int[] A, int[] B, int T, int N) {
       ArrayList<pair> al=new ArrayList<>();
       for(int i=0;i<B.length;i++){
           al.add(new pair(A[i], B[i]));
       }
       Comparator<pair> comp=(p1, p2) -> (int)(p2.getBi() - p1.getBi());
       Collections.sort(al, comp);
     
       int ans=0;
       for(int i=0;i<B.length;i++){
           if(T<=al.get(i).getAi()){
               int pick = T;
               ans=ans+pick*al.get(i).getBi();
               T=T-pick;
           }else if(T>al.get(i).getAi()){
               int pick = al.get(i).getAi();
               ans=ans+pick*al.get(i).getBi();
               T=T-pick;
           }else if(T<=0){
               break;
           }
       }
       
       return ans;
    }
}