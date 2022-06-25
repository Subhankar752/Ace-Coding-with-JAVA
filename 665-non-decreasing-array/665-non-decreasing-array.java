class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean anomaly_found = false;
		for(int i=1;i<nums.length; i++) {
			if(nums[i]<nums[i-1]) {
				if(anomaly_found) return false;//only one anomaly permitted 
				//anomaly found
				//check if decrement possible of previous num
				if(i==1) {
					//decrement possible
					nums[i-1] = nums[i]-1;
				}else if(nums[i]>=nums[i-2]) {
					//still decrement possible
					nums[i-1] = nums[i-2];
					
				}else {
					//only option is to increment the current element nums[i]
					nums[i]=nums[i-1];
				}
				anomaly_found=true;
			}
			
		}
		return true;
    }
}