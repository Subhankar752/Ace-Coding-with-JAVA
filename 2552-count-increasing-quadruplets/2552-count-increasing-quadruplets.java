class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        
        int[][] left = new int[n][n + 1];
        int[][] right = new int[n][n + 1];
        
        for(int i = 0 ; i < n ; i++){
            for(int no = 1 ; no <= n ; no++){
                if(nums[i] < no)
                    left[i][no]++;
                if(i > 0)
                    left[i][no] += left[i - 1][no];
            }
        }
        
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int no = 1 ; no <= n ; no++){
                if(nums[i] > no)
                    right[i][no]++;
                if(i != n - 1)
                    right[i][no] += right[i + 1][no];
            }
        }
        
        long ans = 0;
        for(int j = 1 ; j < n - 2 ; j++){
            for(int k = n - 2 ; k > j ; k--){
                if(nums[j] > nums[k]){
                    int l = left[j][nums[k]];
                    int r = right[k][nums[j]];
                    ans += (l * r);
                }
            }
        }
        return ans;
    }
}