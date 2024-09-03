class Solution {

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] a = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    a[j]++;
                } else {
                    a[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(a));
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int cur = 0;
        int i = 0;
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        while (i < n) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i);
                i++;
            } else {
                int top = st.pop();
                cur = heights[top] * (st.isEmpty() ? i : i - st.peek() - 1);
                ans = Math.max(ans, cur);
            }
        }

        while (!st.isEmpty()) {
            int top = st.pop();
            cur = heights[top] * (st.isEmpty() ? i : i - st.peek() - 1);
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
