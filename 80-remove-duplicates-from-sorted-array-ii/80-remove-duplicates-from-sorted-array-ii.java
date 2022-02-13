class Solution {
    public int removeDuplicates(int[] nums) {
        int end = 0;
        int pointer = 0;
        
        while(end < nums.length){
            int startIndex = end;
            
            while(end < nums.length-1 && nums[end] == nums[end+1]){
                end++;
            }
            
            int length = end - startIndex + 1;
            int freq = Math.min(length,2);
            
            while(freq-- > 0){
                nums[pointer++] = nums[startIndex];
            }
            
            end++;
        }
        
        return pointer;
    }
}