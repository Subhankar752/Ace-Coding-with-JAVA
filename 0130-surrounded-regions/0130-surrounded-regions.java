class Solution {

    private void DFS(char[][] board, int r, int c, int rsize, int csize) {
        if (r < 0 || c < 0 || r == rsize || c == csize || board[r][c] != 'O') return;
        board[r][c] = 'P';
        DFS(board, r + 1, c, rsize, csize);
        DFS(board, r, c + 1, rsize, csize);
        DFS(board, r - 1, c, rsize, csize);
        DFS(board, r, c - 1, rsize, csize);
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int row = board.length, col = board[0].length;

        for (int i = 0; i < col; i++) {
            DFS(board, 0, i, row, col); //for FIRST ROW
            DFS(board, row - 1, i, row, col); //for LAST ROW
        }
        for (int i = 0; i < row; i++) {
            DFS(board, i, 0, row, col); //for FIRST COLUMN
            DFS(board, i, col - 1, row, col); //for LAST COLUMN
        }
        for (int i = 0; i < row; i++) for (int j = 0; j < col; j++) if (board[i][j] == 'O') board[i][j] = 'X'; else if (board[i][j] == 'P') board[i][j] = 'O';
    }
}
