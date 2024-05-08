class Solution {

    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> hs = new HashSet<>();
        int ans = 0;

        for (int i : rolls) {
            hs.add(i);
            if (hs.size() == k) {
                ans++;
                hs.clear();
            }
        }

        return ans + 1;
    }
}
