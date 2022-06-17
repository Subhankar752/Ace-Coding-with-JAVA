// { Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] colors = new int[V];
        Arrays.fill(colors , -1);
        
        for(int i = 0 ; i < V ; i++){
            if(colors[i] == -1)
                if(!bfs(i , adj , colors))
                    return false;
        }
        
        return true;
    }
    static boolean bfs(int node , ArrayList<ArrayList<Integer>> adj , int[] colors){
        Queue<Integer> q = new LinkedList<>();
        
        colors[node] = 1;
        
        q.add(node);
        
        while(!q.isEmpty()){
            int currNode = q.poll();
            for(Integer adjNodes : adj.get(currNode)){
                if(colors[adjNodes] == -1)
                {
                    colors[adjNodes] = 1 - colors[currNode];
                    q.add(adjNodes); 
                }
                else if(colors[adjNodes] == colors[currNode])
                    return false;
            }
        }
        return true;
    }
}