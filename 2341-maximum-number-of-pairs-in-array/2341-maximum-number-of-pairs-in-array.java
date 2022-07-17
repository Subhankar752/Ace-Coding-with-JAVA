class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1);
            }
        }
        
        int pairs = 0;
        
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            int key = m.getKey();
            int value = m.getValue();
            pairs += value / 2;
        }
        
        int rem = nums.length - (pairs * 2);
        int[] ans = new int[2];
        
        ans[0] = pairs;
        ans[1] = rem;
        
        return ans;
    }
}