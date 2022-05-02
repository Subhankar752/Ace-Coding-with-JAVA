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
            int N = Integer.parseInt(in.readLine());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    		for(int i = 0;i < N+1;i++){
    	        ArrayList<Integer> arr = new ArrayList<Integer>();
    	        adj.add(arr);
    		}
    		for(int i = 0;i < N-1;i++){
    		    String a[] = in.readLine().trim().split("\\s+");
    		    int x = Integer.parseInt(a[0]);
    		    int y = Integer.parseInt(a[1]);
    		    adj.get(x).add(y);
    		    adj.get(y).add(x);
    		}
    		
    		Solution ob = new Solution();
    		System.out.println(ob.partyHouse(N, adj));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int partyHouse(int N, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int[] vis = new int[N + 1];
        int ans = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(vis , -1);
            ans = Math.min(ans , bfs(i , adj , vis));
        }
        return ans;
    }
    static int bfs(int i , ArrayList<ArrayList<Integer>> adj , int[] vis){
        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0 ; j < size ; j++){
                int val = q.remove();
                vis[val] = 1;
                for(int k : adj.get(val)){
                    if(vis[k] == -1)
                    q.add(k);
                }   
            }
            level++;
        }
        return level - 1;
    }
}