class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        
        int[] cal = new int[rows];
        
        for(int left = 0 ;left < cols ; left++){
            Arrays.fill(cal , 0);
            
            for(int right = left ; right < cols ; right++){
                for(int i = 0 ; i < rows ; i++)
                    cal[i] += matrix[i][right];
                sum = kadane(cal , k);
                
                ans = Math.max(ans , sum);
                
                sum = 0;
            }
        }
        return ans;
    }
    
    public int kadane(int[] c , int k){
        TreeSet<Integer>ts = new TreeSet<>();
        ts.add(0);
        
        int res = Integer.MIN_VALUE;
        int prefix = 0;
        
        for(int i = 0 ; i < c.length ; i++)
        {
         prefix += c[i];
            Integer target = ts.ceiling(prefix - k);
            if(target != null)
                res = Math.max(res , prefix - target);
            ts.add(prefix);
        }
        
        return res;
    }
}