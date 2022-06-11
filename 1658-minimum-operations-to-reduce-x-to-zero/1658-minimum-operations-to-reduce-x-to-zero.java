class Solution {
    public int minOperations(int[] nums, int k) {
       int target = -1 * k;
        for(int e: nums){
            target += e;
        }
        
        if(target == 0){
            return nums.length;
        }
        if(target < 0){
            return -1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int m = -1;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == target){
                m = i + 1;
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            if(map.containsKey(sum - target)){
                if(m < (i - map.get(sum - target))){
                    m = i - map.get(sum - target);
                }
            }
        }
        return m != -1 ? nums.length - m : m;
    }
}