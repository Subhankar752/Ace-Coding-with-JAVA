class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates , new ArrayList<Integer>() , target , 0);
        return ans;
    }
    public void helper(int[] arr , List<Integer> cur , int target , int idx){
        if(target < 0)
            return;
        if(target == 0){
            List<Integer> x = new ArrayList<>(cur);
            Collections.sort(x);
            if(!ans.contains(x))
                ans.add(new ArrayList<>(x));
            return;
        }
        for(int i = idx ; i < arr.length ; i++){
            if(i > idx && arr[i] == arr[i - 1])
                continue;
            cur.add(arr[i]);
            helper(arr , cur , target - arr[i] , i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}