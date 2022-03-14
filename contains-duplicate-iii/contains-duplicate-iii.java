class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;
        TreeSet<Integer> orderedMap=new TreeSet();
        for(int i = 0 ; i < n ; i++){
            if(i > k) 
                orderedMap.remove(nums[i - k - 1]);
            Integer floor = orderedMap.floor(nums[i]);
            Integer ceil = orderedMap.ceiling(nums[i]);
            if(floor != null && (long)nums[i] - (long)floor <= t) 
                return true;
            if(ceil != null && (long)ceil - (long)nums[i] <= t) 
                return true;
            orderedMap.add(nums[i]);
        }
        return false;
    }
}