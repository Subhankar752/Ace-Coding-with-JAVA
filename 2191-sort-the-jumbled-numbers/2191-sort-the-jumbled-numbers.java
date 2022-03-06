class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Pair[] p = new Pair[n];
        for(int i = 0 ; i < n ; i++){
            int val = 0;
            String x = Integer.toString(nums[i]);
            for(char c : x.toCharArray()){
                int v = Character.getNumericValue(c);
                val = val * 10 + mapping[v];
            }
            int rem = val;
            p[i] = new Pair(nums[i] , rem);
        }
        Arrays.sort(p , (aa , bb) -> aa.b - bb.b);
        for(int i = 0 ; i < n ; i++){
            ans[i] = p[i].a;
        }
        return ans;
    }
}