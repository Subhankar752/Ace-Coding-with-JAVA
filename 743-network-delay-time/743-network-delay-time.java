class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] i : times){
            int u = i[0];
            int v = i[1];
            int wt = i[2];
            adj.get(u).add(new Pair(v , wt));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((aa , bb) -> aa.b - bb.b);
        pq.add(new Pair(k , 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.a;
            int dis = p.b;
            for(Pair ele : adj.get(node)){
                if(dis + ele.b < dist[ele.a]){
                    dist[ele.a] = dis + ele.b;
                    pq.add(new Pair(ele.a , dist[ele.a]));
                }
            }
        }
        int ans = -1;
        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans , dist[i]);
            //System.out.println(dist[i]);
        }
        return ans;
    }
}