class Solution {

    public boolean isPossible(int[] bags, int maxopt, int p) {
        int reqOpt = 0;
        for (int bag : bags) {
            if (bag % p == 0) {
                reqOpt += bag / p - 1;
            } else {
                reqOpt += bag / p;
            }
        }
        return reqOpt <= maxopt;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int st = 1;
        int end = 0;
        for (int bag : nums) {
            end = Math.max(end, bag);
        }
        int pans = -1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (isPossible(nums, maxOperations, mid) == true) {
                pans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return pans;
    }
}
