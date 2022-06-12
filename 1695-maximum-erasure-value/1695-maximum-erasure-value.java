class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int N = nums.length;
        
        int l = 0, cur = 0, max = 0;
        
        Set<Integer> set = new HashSet();
        for (int i = 0; i < N; i++) {
            int el = nums[i];
			//check the elements uniqueness invariant
            while (set.contains(el)) {
				//if duplicate element found - move the left pointer to the right, 
				// remove element from subarray and subtract from current sum
                set.remove(nums[l]);
                cur -= nums[l];
                l++;
            }
            //for new element add it to the set, add to sum and check if that is the max sum subarray
            set.add(el);
            cur+=el;
            max = Math.max(max, cur);
        }
        return max;
    }
}