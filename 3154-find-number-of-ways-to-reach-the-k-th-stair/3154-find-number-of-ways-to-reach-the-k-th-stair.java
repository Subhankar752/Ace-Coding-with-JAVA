class Solution {
    private Map<String, Integer> dpMap;

    private int findRecur(int pos, int jump, int backsteps, int isBackAllowed, int k) {
        if (pos > k + 1) return 0;

        String key = jump + " " + backsteps + " " + isBackAllowed;
        if (dpMap.containsKey(key)) return dpMap.get(key);

        int ans = 0;
        if (pos == k) ++ans;

        if (isBackAllowed == 1) {
            ans += findRecur(pos - 1, jump, backsteps + 1, 0, k);
        }
        ans += findRecur(pos + (1 << jump), jump + 1, backsteps, 1, k);

        dpMap.put(key, ans);
        return ans;
    }

    public int waysToReachStair(int k) {
        dpMap = new HashMap<>();

        return findRecur(1, 0, 0, 1, k);
    }
}
