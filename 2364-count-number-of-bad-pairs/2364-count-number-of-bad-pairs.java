class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        long ans = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            int val = i - nums[i];
            
            if(map.containsKey(val)){
                ans += map.get(val);
                map.put(val , map.get(val) + 1);
            }
            else{
                map.put(val , 1);
            }
        }
        
        int n = nums.length;
        long nn = 1L * n * (n - 1)/2;
        System.out.println(nn);
       // nn /= 2;
        nn -= ans;
        
        return nn;
    }
}