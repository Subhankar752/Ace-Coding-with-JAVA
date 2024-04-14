class Solution {

    public int maximumPrimeDifference(int[] nums) {
        for (int i = 0, j = nums.length - 1; i <= j;) {
            boolean check1 = prime(nums[i]);
            boolean check2 = prime(nums[j]);
            
            if (check1 && check2) {
                return j - i;
            } else if (!check1 && check2) {
                i++;
            } else if (check1 && !check2) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        
        return 0;
    }

    private boolean prime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
