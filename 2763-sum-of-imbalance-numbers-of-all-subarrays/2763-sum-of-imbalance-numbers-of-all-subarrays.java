class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int ans = 0;
        int n = nums.length;
        
        for (int i = 0 ; i < n ; i++) { 
            Set<Integer> hs = new HashSet<>();
            hs.add(nums[i]);
            int c = 0;
            
            for (int j = i + 1 ; j < n ; j++) {
                if (!hs.contains(nums[j])) {
                    int d = 1;
                    int cur = nums[j];
                    
                    if (hs.contains(cur - 1)) {
                        d--;
                    }
                    
                    if (hs.contains(cur + 1)) {
                        d--;
                    }
                    
                    c += d;
                    hs.add(cur);
                }
                
                ans += c;
            }
        }
        
        return ans;
    }
}