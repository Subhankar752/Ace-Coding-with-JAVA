class Solution {
    int n;
    List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] board = new char[n][n];
        for (int r = 0; r < n; ++r)
            for (int c = 0; c < n; ++c)
                board[r][c] = '.';

        backtrack(0, board, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return solutions;
    }
    List<String> getResult(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (int r = 0; r < n; ++r)
            ans.add(new String(board[r]));
        return ans;
    }
    void backtrack(int c, char[][] board, Set<Integer> rowSet, Set<Integer> mainDiagSet, Set<Integer> antiDiagSet) {
        if (c == n) {
            solutions.add(getResult(board));
            return;
        }
        for (int r = 0; r < n; ++r) {
            if (!rowSet.contains(r)
                    && !mainDiagSet.contains(r-c)
                    && !antiDiagSet.contains(r+c)) {
                board[r][c] = 'Q';
                rowSet.add(r);
                mainDiagSet.add(r-c);
                antiDiagSet.add(r+c);

                backtrack(c+1, board, rowSet, mainDiagSet, antiDiagSet);

                board[r][c] = '.';
                rowSet.remove(r);
                mainDiagSet.remove(r-c);
                antiDiagSet.remove(r+c);
            }
        }
    }
}