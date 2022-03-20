class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == key){
                int ind = i;
                while(ind >= 0){
                    if(Math.abs(i - ind) <= k)
                    {
                        hs.add(ind);
                    }
                    ind--;
                }
                ind = i + 1;
                while(ind < nums.length){
                    if(Math.abs(i - ind) <= k)
                    {
                        hs.add(ind);
                    }
                    ind++;
                }
            }
        }
        for(int ele : hs)
            ans.add(ele);
        Collections.sort(ans);
        return ans;
    }
}