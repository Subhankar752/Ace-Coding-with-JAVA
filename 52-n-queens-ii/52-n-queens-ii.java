class Solution {
   int result = 0;
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        dfs(0, new boolean[n], new boolean[2*n], new boolean[2*n]);
        return result;
    }
    public void dfs(int row, boolean[] cols, boolean[] leftDia, boolean[] rightDia){
        if(row == n){
            result++;
            return;
        }
        for(int i=0; i<n; i++){
            int d1 = row + i;
            int d2 = row - i + n;
            if(cols[i] || leftDia[d1] || rightDia[d2])
                continue;
            cols[i] = true;
            leftDia[d1] = true;
            rightDia[d2] = true;
        
            dfs(row+1, cols, leftDia, rightDia);
            cols[i] = false;
            leftDia[d1]  = false;
            rightDia[d2] = false;
        }
    }
}