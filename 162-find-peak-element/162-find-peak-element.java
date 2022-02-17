class Solution {
    public int findPeakElement(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(i == 0){
                if(nums[i] > nums[i+1]){
                    ans=i;
                    break;
                }
            }
            else if(i == n-1){
                if(nums[i] > nums[i-1]){
                    ans=i;
                    break;
                }
            }
            
            else{
                if(nums[i] > nums[i-1]  && nums[i] > nums[i+1]){
                ans=i;
                break;
            }
            }
        }
        return ans;
    }
}