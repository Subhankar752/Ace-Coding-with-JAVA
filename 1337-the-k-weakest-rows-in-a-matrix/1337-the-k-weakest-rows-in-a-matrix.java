class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        Pair[] a = new Pair[rows];
        for(int i = 0 ; i < rows ; i++){
            int count = 0;
            for(int j = 0 ; j < cols ; j++){
                if(mat[i][j] == 1)
                    count++;
            }
            a[i] = new Pair(i , count);
        }
        Arrays.sort(a , (aa , bb) -> aa.b - bb.b);
        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++)
            ans[i] = a[i].a;
        return ans;
    }
}