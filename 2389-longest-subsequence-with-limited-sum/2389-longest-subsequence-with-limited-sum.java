class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        
        int[] ans = new int[m];
        
        Arrays.sort(nums);
        int k = 0;
        
        for(int i : queries){
            int sum = i;
            int cnt = 0;
            
            for(int j : nums){
                if(j <= sum){
                    cnt++;
                    sum -= j;
                }
                else{
                    break;
                }
            }
            
            ans[k++] = cnt;
        }
        
        return ans;
    }
}