class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int x=0;
        for(int i:nums){
            if(i==x){
                x++;
            }
            else{
                break;
            }
        }
        return x;
    }
}