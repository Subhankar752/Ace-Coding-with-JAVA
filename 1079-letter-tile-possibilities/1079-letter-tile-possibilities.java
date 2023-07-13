class Solution {

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        getPos(set, visited, "", tiles);
        return set.size() - 1;
    }

    void getPos(Set<String> set, boolean[] visited, String s, String tiles) {
        set.add(s);

        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                getPos(set, visited, s + tiles.charAt(i), tiles);
                // Backtracking
                visited[i] = false;
            }
        }
        return;
    }
}
