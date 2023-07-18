class Solution {

    public int removeStones(int[][] stones) {
        boolean visited[] = new boolean[stones.length];
        int group = 0;
        for (int i = 0; i < stones.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                dfs(i, visited, stones);
                group++;
            }
        }
        return stones.length - group;
    }

    public void dfs(int indx, boolean[] visited, int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && (stones[i][0] == stones[indx][0] || stones[i][1] == stones[indx][1])) {
                visited[i] = true;
                dfs(i, visited, stones);
            }
        }
    }
}
