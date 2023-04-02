
class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = getGraph(edges , n);
        int shortestCycle = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){

            Queue<Integer> q = new LinkedList<>();
            int[] distance = new int[n];
            int[] parent = new int[n];
            Arrays.fill(distance , Integer.MAX_VALUE);
            Arrays.fill(parent , -1 );

            q.add(i);
            distance[i] = 0;

            while(!q.isEmpty()){
                int node = q.poll();

                for(int edge : graph.get(node)){

                    if(distance[edge] == Integer.MAX_VALUE){

                        parent[edge] = node;
                        distance[edge] = distance[node] + 1;

                        q.add(edge);

                    }else if(parent[node] != edge && parent[edge]!=node){

                        int dist = distance[edge] + distance[node] + 1;
                        shortestCycle = Math.min(shortestCycle , dist );
                    }
                }
            }
        }
        if(shortestCycle == Integer.MAX_VALUE){
            return -1;
        }else{
            return shortestCycle;
        }
    }
    private List<List<Integer>> getGraph(int[][] edges , int n){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}