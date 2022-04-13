class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] sort = new int[n];
        for(int i = 0 ; i < n ; i++)
            sort[i] = heights[i];
        Arrays.sort(sort);
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(heights[i] != sort[i])
                ans++;
        }
        return ans;
    }
}