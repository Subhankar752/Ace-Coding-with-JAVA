class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] b = new boolean[n][n];
        for(int[] i : dig){
            int u = i[0];
            int v = i[1];
            b[u][v] = true;
        }
        int ans = 0;
        for(int[] i : artifacts){
            int r1 = i[0];
            int c1 = i[1];
            int r2 = i[2];
            int c2 = i[3];
            boolean flag = true;
            for(int k = r1 ; k <= r2 ; k++){
                for(int m = c1 ; m <= c2 ; m++){
                    if(b[k][m] == false){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag == true)
                ans++;
        }
        return ans;
    }
}