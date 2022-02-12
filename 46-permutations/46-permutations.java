class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        solve(nums , new ArrayList<>());
        return ans;
    }
    public void solve(int[] nums , List<Integer> temp){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            solve(nums , temp);
            temp.remove(temp.size() - 1);
        }
    }
}