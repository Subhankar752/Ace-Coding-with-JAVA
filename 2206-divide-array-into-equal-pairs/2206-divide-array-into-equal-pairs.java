class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1);
            }
        }
        boolean flag = true;
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            int val = m.getValue();
            if(val % 2 != 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}