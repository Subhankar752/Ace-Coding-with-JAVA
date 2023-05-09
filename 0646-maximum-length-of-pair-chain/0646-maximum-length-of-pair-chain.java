class Solution {
    public int findLongestChain(int[][] pairs) {
        int i, j, max = 0, n = pairs.length;
        int mcl[] = new int[n];
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        
        for(i = 0; i < n; i++ )
          mcl[i] = 1;

        for(i = 1 ; i < n ; i++)
          for (j = 0; j < i; j++)
             if (pairs[i][0] > pairs[j][1])
                mcl[i] = Math.max(mcl[i] , mcl[j] + 1);
      
        for (i = 0 ; i < n ; i++)
          if (max < mcl[i])
             max = mcl[i];
      
        return max;
    }
}