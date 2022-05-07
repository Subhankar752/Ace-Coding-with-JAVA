class Solution {
    public boolean find132pattern(int[] nums) {
      int[] arr = Arrays.copyOf(nums, nums.length);

    for (int i = 1; i < nums.length; i++) {
        arr[i] = Math.min(nums[i - 1], arr[i - 1]);
    }
    
    for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
        if (nums[j] <= arr[j]) continue;
        while (top < nums.length && arr[top] <= arr[j]) top++;
        if (top < nums.length && nums[j] > arr[top]) return true;
        arr[--top] = nums[j];
    }
        
    return false;
    }
}