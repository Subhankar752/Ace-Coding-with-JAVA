class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        //sort the 1st row
        for(int i = 0 ; i < cols ; i++){
            PriorityQueue<Integer> list = new PriorityQueue<>();
            
            int r = 0;
            int c = i;
            
            while(r < rows && c < cols){
                list.add(mat[r][c]);
                r++;
                c++;
            }
            
            r = 0;
            c = i;
            
            // while(!list.isEmpty()){
            //     System.out.print(list.remove() + " ");
            // }
            // System.out.println();
            
            while(r < rows && c < cols){
                mat[r][c] = list.remove();
                r++;
                c++;
            }
            
        }
        
        //sort the leftmost column
        for(int i = 1 ; i < rows ; i++){
            PriorityQueue<Integer> list = new PriorityQueue<>();
            
            int r = i;
            int c = 0;
            
            while(r < rows && c < cols){
                list.add(mat[r][c]);
                r++;
                c++;
            }
            
            r = i;
            c = 0;
            
            // while(!list.isEmpty()){
            //     System.out.print(list.remove() + " ");
            // }
            //System.out.println();
            
            while(r < rows && c < cols){
                mat[r][c] = list.remove();
                r++;
                c++;
            }
        }
        
        return mat;
    }
}