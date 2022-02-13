class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0)
            return 0;
        int cols = matrix[0].length;
        int[] h = new int[cols];
        int max = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(matrix[i][j] == '0')
                    h[j] = 0;
                else
                    h[j] += 1;
            }
            max = Math.max(max , getMaxArea(h , cols));
        }
        return max;
    }
    public int getMaxArea(int hist[], int n)
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();
         
        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar
      
        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);
      
            // If this bar is lower than top of stack, then calculate area of rectangle
            // with stack top as the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top
      
                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
      
                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }
      
        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
      
            if (max_area < area_with_top)
                max_area = area_with_top;
        }
      
        return max_area;
 
    }
}
    