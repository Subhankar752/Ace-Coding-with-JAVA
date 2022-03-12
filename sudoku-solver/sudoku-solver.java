class Solution {
    
    private static int N; // define the length of board
    private static boolean success; // it'll be used later 

    public static void solveSudoku(char[][] board) {
        N = board.length; 
        success = false;
        solveSudoku(board, 0, 0); // start at index(0,0)
    }

    private static void solveSudoku(char[][] board, int row, int col) {
	
        if(col == N) { // if we surpass the column length, 
            solveSudoku(board, row+1, 0); // then check for the next row
            return;
        }
        if(row == N) { // if we surpass the row length, 
            success = true; // then our algorithm has finished, set success to true
            return;
        }

        if(board[row][col] == '.') { // if it's a number then don't bother changing anything
            for(int num = 1; num<=N; num++) { // start guessing the number from 1 to 9
                if(isValid(board, num+48, row, col)) { // if the conditions met,
                    board[row][col] = (char) (num + 48); // set the current index as our guessed number
                    solveSudoku(board, row, col+1); // then move to the next column
                    if(success) return; // if the success changed to true, we've successfully found the ans. just return all the functions.
                }
            }
            board[row][col] = '.'; // if we have guessed from 1 to 9 and still don't meet the conditions, backtrack to the previous call, and set the current index back to dot ('.')
            
        } else solveSudoku(board, row, col+1); // if it's a number, check the next column instead
    }

// I assume you've already mastered the validator from question 36, so no need for explanation.
    public static boolean isValid(char[][] board, int num, int row, int col) {
        return (!isNumInRow(board, num, row)
                && !isNumInCol(board, num, col)
                && !isNumInSubbox(board, num, row, col));
    }

    public static boolean isNumInRow(char[][] board, int num, int row) {
        for(int col = 0; col < N; col++) {
            if(board[row][col] == num) return true;
        }
        return false;
    }

    public static boolean isNumInCol(char[][] board, int num, int col) {
        for(int row = 0; row < N; row++) {
            if(board[row][col] == num) return true;
        }
        return false;
    }

    public static boolean isNumInSubbox(char[][] board, int num, int row, int col) {
        int baseRow = row - row % 3, baseCol = col - col % 3;

        for(int i = baseRow; i < baseRow+3; i++) {
            for(int j = baseCol; j < baseCol+3; j++) {
                if(board[i][j] == num) return true;
            }
        }
        return false;
    }
}