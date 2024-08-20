class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> hs = new TreeSet<>();
        for (int i = 0 ; i < n ; i++) {
            hs.add(i);
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] i : queries) {
            int l = i[0];
            int r = i[1];
            remove(hs, l + 1, r - 1);
            ans[idx++] = hs.size() - 1;
        }
        
        return ans;
    }
    
    public void remove(TreeSet<Integer> hs, int l, int r) {
        SortedSet<Integer> rem = hs.subSet(l, true, r, true);
        List<Integer> toRemove = new ArrayList<>(rem);
        hs.removeAll(toRemove);
    }
}