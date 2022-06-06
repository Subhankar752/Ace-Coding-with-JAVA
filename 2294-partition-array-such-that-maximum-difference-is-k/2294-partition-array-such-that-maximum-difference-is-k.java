class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int min = nums[0];
        int max;
        for(int i = 1 ; i < nums.length ; i++){
            max = nums[i];
            if(max - min > k){
                min = nums[i];
                System.out.println(min);
                ans++;
            }
        }
        return ans;
    }
}