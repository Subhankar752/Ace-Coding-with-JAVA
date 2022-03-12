class Solution {
    public int largestRectangleArea(int[] hist) {
        int n = hist.length;
        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int area_with_top = 0;
        int tp;
        int i = 0;
        while(i < n){
            if(s.isEmpty() || hist[s.peek()] <= hist[i])
                s.push(i++);
            else{
                tp = s.pop();
                area_with_top = hist[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
                max_area = Math.max(max_area , area_with_top);
            }
        }
        while(!s.isEmpty()){
            tp = s.pop();
            area_with_top = hist[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area , area_with_top);
        }
        return max_area;
    }
}