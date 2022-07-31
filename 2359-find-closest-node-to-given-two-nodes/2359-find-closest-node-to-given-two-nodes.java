class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
    public void bfs(int src , int[] vis){
        
        vis[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty()){
            
            int t = q.remove();
            
            for(int ele : adj.get(t)){
            
                if(vis[ele] == -1){
                    q.add(ele);
                    vis[ele] = vis[t] + 1;
                }
            
            }
        }
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
       
        int n = edges.length;
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < n ; i++){
            if(edges[i] != -1){
                adj.get(i).add(edges[i]);        
            }
        }
        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(i + "->");
        //     for(int ele : adj.get(i))
        //         System.out.print(ele + " ");
        //     System.out.println();
        // }
        
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            dis1[i] = -1;
            dis2[i] = -1;
        }
        
        bfs(node1 , dis1);
        bfs(node2 , dis2);
        
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        // for(int i = 0 ; i < n ; i++){
        //     System.out.println(dis1[i]);
        // }
        
        for(int i = 0 ; i < n ; i++){
            
            if(dis1[i] != -1 && dis2[i] != -1){
                if(ans > Math.max(dis1[i] , dis2[i])){
                    ans = Math.min(ans , Math.max(dis1[i] , dis2[i]));
                    idx = i;
                }
              
            }
        }
        
        return idx;
    }
}