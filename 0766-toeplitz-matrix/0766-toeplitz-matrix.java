class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0 ; i < n ; i++)
        {
            int compare = matrix[0][i];
            for(int row = 0 , col = i ; row < m && col < n ; row++ , col++)
            {
                if(matrix[row][col] != compare)  return false;
            }
        }
        
        for(int i = 0 ; i < m ; i++)
        {
            int compare = matrix[i][0];
            
            for(int row = i , col = 0 ; row < m && col < n ; row++ , col++)
            {
                if(matrix[row][col] != compare)  return false;
            }
        }
        
        return true;
    }
}