class Solution {
    public int majorityElement(int[] nums) {
         HashMap<Integer , Integer> map=new HashMap<>();
        int n=nums.length;
        int x=n/2;
        for(int i=0;i<n;i++){
            int val=nums[i];
            if(map.get(val) == null){
                map.put(val , 1);
            }
            else{
                map.put(val , map.get(val) + 1);
            }
            if(map.get(val) > x)
                return val;
        }
        return 0;
    }
}