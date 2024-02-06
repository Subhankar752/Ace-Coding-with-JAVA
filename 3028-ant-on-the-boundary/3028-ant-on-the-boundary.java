class Solution {

    public int returnToBoundaryCount(int[] nums) {
        int ans = 0;

        int curPos = 0;
        for (int i : nums) {
            curPos += i;
            
            if (curPos == 0) {
                ans++;
            }
        }

        return ans;
    }
}
