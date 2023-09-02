class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        
        int n = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int unique = 0;
        int i = 0;
        long sum = 0;
        for(int j = 0 ; j < n ; j++) {
            sum += nums.get(j);
            
            if (map.containsKey(nums.get(j))) {
               map.put(nums.get(j), map.get(nums.get(j)) + 1); 
            }
            else {
               map.put(nums.get(j), 1);
            }
            
            if(map.get(nums.get(j)) == 1) {
                unique++;
            }
            
            if (j >= k) {
                sum -= nums.get(i);
                int val = map.get(nums.get(i));
                
                if(val > 1) {
                    map.put(nums.get(i), map.get(nums.get(i)) - 1);    
                }
                else {
                    map.remove(nums.get(i));
                    unique--;
                }
                i++;
            }
            
            if(unique >= m) {
                ans = Math.max(ans, sum);
            }
        }
        
        return ans;
    }
}