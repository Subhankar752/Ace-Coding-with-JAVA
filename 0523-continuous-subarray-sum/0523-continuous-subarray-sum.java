class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            int mod = sum % k;
            
            if(i >= 1 && mod == 0)
                return true;
            
            if(map.containsKey(mod) && (i - map.get(mod) > 1))
                return true;
            
            if(!map.containsKey(mod))
                map.put(mod , i);
        }
        
        return false;
    }
}