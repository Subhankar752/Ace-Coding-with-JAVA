class Solution {
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        
        for (int i = 0; i < N; ++i) 
            tree.add(new HashSet<Integer>());
        
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        
        dfs1(0, -1);
        dfs2(0, -1);
        
        return res;
    }

    public void dfs1(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) 
                continue;
            
            dfs1(i, root);
            
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        
        count[root]++;
    }

    public void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) 
                continue;
            
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }
}
