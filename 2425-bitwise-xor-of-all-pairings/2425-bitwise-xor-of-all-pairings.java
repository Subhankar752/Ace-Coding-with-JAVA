class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if(n % 2 == 0 && m % 2 == 0)
            return 0;
        
        int ans = 0;
        
        if(n % 2 == 1 && m % 2 == 1){
            for(int i : nums1)
                ans ^= i;
            for(int i : nums2)
                ans ^= i;
            
            return ans;
        }
        
        if(n % 2 == 1){
            for(int i : nums2)
                ans ^= i;
            return ans;
        }
        
        if(m % 2 == 1){
            for(int i : nums1)
                ans ^= i;
            return ans;
        }
        
        return ans;

    }
}