class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length , col = grid[0].length;
    	Integer[][] shift = new Integer[row][col];
    	for (int i = 0 ; i < row ; i++)  
    		for (int j = 0 ; j < col ; j++) {
    			int c = (j + k) % col;
    			int r = (i + (j + k) / col) % row;
    			shift[r][c] = grid[i][j];
    		}
        List<List<Integer>> res = new ArrayList<>();
    	for (int i = 0 ; i < row ; i++)
    		res.add(Arrays.asList(shift[i]));
    	return res;
    }
}