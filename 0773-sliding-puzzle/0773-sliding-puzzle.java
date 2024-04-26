class Solution {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        Queue<String> q = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(1, 3));
        map.put(1, Arrays.asList(0, 2, 4));
        map.put(2, Arrays.asList(1, 5));
        map.put(3, Arrays.asList(0, 4));
        map.put(4, Arrays.asList(1, 3, 5));
        map.put(5, Arrays.asList(2, 4));

        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start = start + board[i][j];
            }
        }
        q.add(start);
        Set<String> vis = new HashSet<>();
        vis.add(start);

        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.remove();
                if (cur.equals(target)) {
                    return ans;
                }

                int zeroIdx = cur.indexOf('0');
                for (int ele : map.get(zeroIdx)) {
                    String next = swapString(cur, zeroIdx, ele);
                    if (vis.contains(next)) {
                        continue;
                    }

                    q.add(next);
                    vis.add(next);
                }
            }

            ans++;
        }

        return -1;
    }

    public String swapString(String s, int zIdx, int idx) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(zIdx, s.charAt(idx));
        sb.setCharAt(idx, s.charAt(zIdx));

        return sb.toString();
    }
}
