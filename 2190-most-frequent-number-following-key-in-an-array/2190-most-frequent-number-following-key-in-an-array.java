class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i  = 0 ; i < nums.length - 1 ; i++){
            if(nums[i] == key){
                int val = nums[i + 1];
                if(map.containsKey(val)){
                    map.put(val , map.get(val) + 1);
                }
                else{
                    map.put(val , 1);
                }
            }
        }
        int max = 0;
        int val = 0;
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            int ke = m.getKey();
            int value = m.getValue();
            if(max < value){
                max = value;
                val = ke;
            }
        }
        return val;
    }
}