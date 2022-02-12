class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        boolean visited[] = new boolean[nums.length];
        solve(nums, res, visited, new ArrayList());
        return res;
    }
    
    void solve(int[] nums, List<List<Integer>> res, boolean visited[], List<Integer> temp) {
        if(temp.size() == nums.length) {
            if(!res.contains(temp))
                res.add(new ArrayList(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                solve(nums, res, visited, temp);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}