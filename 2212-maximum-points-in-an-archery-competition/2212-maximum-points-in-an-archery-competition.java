class Solution {
    int mx = 0;
    int[] ans = null;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(aliceArrows, new int[12], numArrows, 0, 0);
        return ans;
    }
    
    void dfs(int[] a, int b[], int t, int p, int id) {
        if (t < 0) return;
        if (p > mx) {
            mx = p;
            int[] nb1 = Arrays.copyOf(b, 12);
            if (t > 0) nb1[0] += t;
            ans = nb1;
        }
        
        for(int i=id; i<a.length; i++) {
            int[] nb = Arrays.copyOf(b, 12);
            nb[i] = a[i]+1;
            dfs(a, nb, t-nb[i], p+i, i+1);
        }
    }
}