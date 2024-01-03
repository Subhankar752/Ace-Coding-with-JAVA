class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int a = 0;
        int b = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(target - nums[i])){
                b = i;
                a = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i] , i);
        }
        int[] ans = new int[2];
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}