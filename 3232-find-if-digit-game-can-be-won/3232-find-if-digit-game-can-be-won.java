class Solution {

    public boolean canAliceWin(int[] nums) {
        int ssum = 0;
        int dsum = 0;
        int sum = 0;
        
        for (int i : nums) {
            sum += i;
        }

        for (int i : nums) {
            if (i < 10) {
                ssum += i;
            }
            if (i < 100 && i >= 10) {
                dsum += i;
            }
        }

        if ((ssum > (sum - ssum)) || (dsum > (sum - dsum))) {
            return true;
        }

        return false;
    }
}
