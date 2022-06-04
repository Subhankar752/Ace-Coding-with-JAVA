// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            int mat[][] = new int[M][2];
            for(int i = 0;i < M;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                mat[i][0] = Integer.parseInt(a1[0]);
                mat[i][1] = Integer.parseInt(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minColour(N, M, mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minColour(int N, int M, int mat[][]) {
        // code here
         Queue<Integer> queue = new LinkedList<>();
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i = 0 ; i < N ; i++) adj.add(new ArrayList<>());
       int[] indegree = new int[N];
       for(int i = 0 ; i < mat.length ; i++){
           int u = mat[i][1] - 1;
           int v = mat[i][0] - 1;
           adj.get(u).add(v);
           indegree[v]++;
       }
       for(int i = 0 ; i < N ; i++){
           if(indegree[i] == 0){
               queue.add(i);
           }
       }
       int minColors = 0;
       while(!queue.isEmpty()){
           int size = queue.size();
           minColors++;
           for(int i = 0 ; i < size ; i++){
               int curr = queue.poll();
               for(int ele : adj.get(curr)){
                   indegree[ele]--;
                   if(indegree[ele] == 0)
                   queue.add(ele);
               }
           }
       }
       return minColors;
    }
}