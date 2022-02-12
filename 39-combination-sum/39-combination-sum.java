class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates , new ArrayList<>() , target , 0);
        return ans;
    }
    public void helper(int[] arr , List<Integer> cur , int target , int idx){
        
        if(target < 0)
            return;
        
        if(target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = idx ; i < arr.length ; i++){
            cur.add(arr[i]);
            helper(arr , cur , target - arr[i] , i);
            cur.remove(cur.size() - 1);
        }
    }
}