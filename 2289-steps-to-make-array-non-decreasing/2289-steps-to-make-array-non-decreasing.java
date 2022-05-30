class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int n = nums.length;
        int cnt = 0;
        int mx = 0;
        for (int i=n-1;i>=0;i--) {
            if (st.empty()) {
                st.push(new int[] {nums[i],0});
            } else {
                cnt = 0;
                while (!st.empty() && st.peek()[0]<nums[i]) {
                    int[] z = st.pop();
                    cnt = Math.max(cnt+1, z[1]);
                }
                st.push(new int[] {nums[i], cnt});
                mx = Math.max(mx, cnt);
            }
        }
        return mx;
    }
}