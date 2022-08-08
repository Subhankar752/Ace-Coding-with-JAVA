class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2 * n - 1 ; i >= 0 ; i--){
            int num = (i >= n) ? nums[i - n] : nums[i];
            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }
            if(i < n){
                if(!st.isEmpty()){
                    ans[i] = st.peek();
                }
                else{
                    ans[i] = -1;
                }
            }
            st.push(num);
        }
        return ans;
    }
}