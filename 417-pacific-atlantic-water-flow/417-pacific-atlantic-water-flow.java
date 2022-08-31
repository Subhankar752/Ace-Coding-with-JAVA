class Solution {
    private final int[] dy= {-1 , 1 , 0 , 0} , dx= {0 , 0 , -1 , 1};
    private int m , n;
    private enum Ocean { PACIFIC, ATLANTIC }

public List<List<Integer>> pacificAtlantic(final int[][] heights) {
    m = heights.length; n = heights[0].length;

    boolean[][] pacific = new boolean[m][n];
    visit(heights, pacific, Ocean.PACIFIC);

    boolean[][] atlantic= new boolean[m][n];
    visit(heights, atlantic, Ocean.ATLANTIC);

    List<List<Integer>> ans= new ArrayList<>();
    for (int r=0; r < m; ++r) {
        for (int c=0; c < n; ++c) {
            if (pacific[r][c] && atlantic[r][c]) {
                ans.add(List.of(r,c));
            }
        }
    }
    return ans;
}

private void visit(final int[][] heights, final boolean[][] visited, Ocean ocean) {
    for (int[] spot : beachCoordinates(ocean)) {
        final int r = spot[0] , c = spot[1];
        visited[r][c]= true;
        dfs(heights, visited, r, c);
    }
}

private void dfs(final int[][] heights, boolean[][] visited, final int r, final int c) {
    int nr, nc;
    for (int i=0; i < 4; ++i) {
        nr= r + dy[i]; nc= c + dx[i];
        if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
        if (visited[nr][nc] || heights[r][c] > heights[nr][nc]) continue;
        visited[nr][nc]= true;
        dfs(heights, visited, nr, nc);
    }
}

private List<int[]> beachCoordinates(final Ocean ocean) {
    List<int[]> coordinates = new ArrayList<>();
    if (Ocean.PACIFIC.equals(ocean)) {
        for (int r=0; r < m; ++r) coordinates.add(new int[]{r,0});
        for (int c=1; c < n; ++c) coordinates.add(new int[]{0,c});
    }
    if (Ocean.ATLANTIC.equals(ocean)) {
        for (int r=0; r < m-1; ++r) coordinates.add(new int[]{r,n-1});
        for (int c=0; c < n; ++c) coordinates.add(new int[]{m-1,c});
    }
    return coordinates;
}
}