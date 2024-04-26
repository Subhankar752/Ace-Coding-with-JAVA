class Solution {

    public long maxSpending(int[][] a) {
        long ans = 0;

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                l.add(a[i][j]);
            }
        }

        Collections.sort(l);
        long d = 1l;
        for (int i : l) {
            ans += (d * i);
            d++;
        }

        return ans;
    }
}
