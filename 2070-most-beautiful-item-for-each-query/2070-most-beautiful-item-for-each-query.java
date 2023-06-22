class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));

        TreeMap<Integer, Integer> map = new TreeMap<>() {

            {
                put(0, 0);
            }
        };
        int currMax = 0;
        for (int[] item : items) {
            currMax = Math.max(currMax, item[1]);
            map.put(item[0], currMax);
        }

        for (int i = 0; i < queries.length; ++i) result[i] = map.floorEntry(queries[i]).getValue();

        return result;
    }
}
