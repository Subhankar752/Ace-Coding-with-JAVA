class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        //ending position of the unsorted array
        int e=-1; //this is done to handle the edge case, i.e even if the array is completely sorted
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<max){
                e=i;
            }
            else{
                max=nums[i];
            }
        }
        //starting of the unsorted part
        int s=0;
        int min=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>min){
                s=i;
            }
            else{
                min=nums[i];
            }
        }
        return e-s+1;
    }
}