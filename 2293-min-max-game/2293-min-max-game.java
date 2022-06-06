class Solution {
    public int minMaxGame(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums)
            list.add(i);
        while(list.size() != 1){
            ArrayList<Integer> res = solve(list);
            list = res;
        }
        return list.get(0);
    }
    public ArrayList<Integer> solve(ArrayList<Integer> a){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = a.size();
        for(int i = 0 ; i < n/2 ; i++){
            if(i % 2 == 0){
                ans.add(Math.min(a.get(2 * i) , a.get(2 * i + 1)));
            }
            else{
                ans.add(Math.max(a.get(2 * i) , a.get(2 * i + 1)));
            }
        }
        return ans;
    }
}