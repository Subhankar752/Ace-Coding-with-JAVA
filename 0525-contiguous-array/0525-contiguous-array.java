class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == 1) {
                sum++;
            }
            else {
                sum--;
            }
            
            if(map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        
        return ans;
    }
}