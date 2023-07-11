class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solve(new ArrayList<>() , target , candidates , 0);
        return ans;
    }
    
    public void solve(List<Integer> temp, int t , int[] a, int i) {
        if(t < 0) {
            return;
        }
        
        if(t == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int idx = i ; idx < a.length ; idx++) {
            temp.add(a[idx]);
            solve(temp, t - a[idx] , a , idx);
            temp.remove(temp.size() - 1);
        }
    }
}