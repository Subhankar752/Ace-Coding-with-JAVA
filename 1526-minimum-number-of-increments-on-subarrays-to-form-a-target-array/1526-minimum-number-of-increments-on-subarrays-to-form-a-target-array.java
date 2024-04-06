class Solution {

    public int minNumberOperations(int[] target) {
        int ans = target[0];

        for (int i = 1; i < target.length; i++) {
            ans += Math.max(0, target[i] - target[i - 1]);
        }

        return ans;
    }
}
