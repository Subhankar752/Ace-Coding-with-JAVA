class Solution {
    int[] rank;
    int[] parent;

    public boolean equationsPossible(String[] equations) {
        rank = new int[26];
        parent = new int[26];

        for(int i = 0;i < 26;i++){
            rank[i] = 0;
            parent[i] = i;
        }

        for(String it : equations){
            if(it.charAt(1) == '='){
                union(it.charAt(0)-'a', it.charAt(3)-'a');
            }
        }

        for(String it : equations){
            if(it.charAt(1) == '!'){
                if(find_parent(it.charAt(0)-'a') == find_parent(it.charAt(3)-'a')){
                    return false;
                }
            }
        }

        return true;
    }

    private int find_parent(int node){
        if(node == parent[node]){
            return node;
        }

        return parent[node] = find_parent(parent[node]);
    }

    private void union(int u, int v){
        int parent_u = find_parent(u);
        int parent_v = find_parent(v);

        if(parent_u == parent_v){
            return ;
        }

        if(rank[parent_u] > rank[parent_v]){
            parent[parent_v] = parent_u;
        }
        else if(rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
        }
        else{
            parent[parent_u] = parent_v;
            rank[parent_v]++;
        }
    }
}