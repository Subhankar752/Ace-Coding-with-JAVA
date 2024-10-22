class Solution {

    public int countPairs(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                result += almostEqual(nums[i], nums[j]) ? 1 : 0;
            }
        }
        return result;
    }

    private boolean almostEqual(int a, int b) {
        int found = 0;
        int[] ad = new int[4];
        int[] bd = new int[4];
        while (a > 0 || b > 0) {
            if (a % 10 != b % 10) {
                ad[found] = a % 10;
                bd[found] = b % 10;
                found++;
            }
            a /= 10;
            b /= 10;
            if (found == 4) {
                break;
            }
        }

        if (found <= 1) {
            return found == 0;
        }
        if (found == 2 || found == 3) {
            Arrays.sort(ad);
            Arrays.sort(bd);
            return a == b && Arrays.equals(ad, bd);
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (ad[i] == bd[j] && ad[j] == bd[i]) {
                    Arrays.sort(ad);
                    Arrays.sort(bd);
                    return a == b && Arrays.equals(ad, bd);
                }
            }
        }
        return false;
    }
}
