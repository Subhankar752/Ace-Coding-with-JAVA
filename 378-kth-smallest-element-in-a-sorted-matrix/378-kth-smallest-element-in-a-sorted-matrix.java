class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> a=new ArrayList<>();
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a.add(matrix[i][j]);
            }
        }
        Collections.sort(a);
        return a.get(k-1);
    }
}