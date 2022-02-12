class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int maxArea=0;
        int right=height.length-1;
        while(left<right){
            int currArea=Math.min(height[left], height[right]) * (right-left);
            maxArea=Math.max(maxArea, currArea);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}