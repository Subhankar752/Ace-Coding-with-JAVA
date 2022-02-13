class Solution {
   List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        ans.add(temp);
        solve(nums , nums.length , temp , 0);
        return ans;
    }
    public void solve(int[] nums , int n , List<Integer> temp , int idx){
        
        if(temp.size() == n){
            return;
        }
        
        for(int i = idx ; i < n ; i++){
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            solve(nums , n , temp , i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}