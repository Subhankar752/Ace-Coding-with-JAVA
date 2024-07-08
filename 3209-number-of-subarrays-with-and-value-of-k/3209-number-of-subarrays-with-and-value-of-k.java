import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        return atLeastK(nums, k) - atLeastK(nums, k + 1);
    }

    private long atLeastK(int[] nums, int k) {
        long ans = 0;
        int[] temp = new int[32];

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            for (int i = 0; i < 32; i++) {
                if ((1 << i & nums[r]) != 0) {
                    temp[i]++;
                }
            }

            while ((r - l + 1) > 0 && calc(temp, r - l + 1) < k) {
                for (int i = 0; i < 32; i++) {
                    if ((1 << i & nums[l]) != 0) {
                        temp[i]--;
                    }
                }
                l++;
            }
            ans += (r - l + 1);
        }

        return ans;
    }

    private int calc(int[] temp, int w) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (temp[i] == w) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
