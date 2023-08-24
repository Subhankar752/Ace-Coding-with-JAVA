class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        
        for (int i = 0 ; i <= n - k ; i++) {
            
            if(nums[i] == 0)
                continue;
            
            int cur = nums[i];
            // System.out.println(cur);
        
            for (int j = i ; j <= i + k - 1 ; j++) {
                nums[j] -= cur;
                
                if (nums[j] < 0)
                    return false;
            }
            
            // print(nums);
        }
        
        for (int i : nums) {
            if (i != 0)
                return false;
        }
        
        return true;
    }
    
    public void print(int[] nums) {
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}