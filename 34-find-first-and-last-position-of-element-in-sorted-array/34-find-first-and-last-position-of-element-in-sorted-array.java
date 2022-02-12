class Solution {
    public int[] searchRange(int[] nums, int t) {
        int start=-1;
        int end=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==t){
                start=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]==t){
                end=i;
                break;
            }
        }
        int[] res={start,end};
        return res;
    }
}