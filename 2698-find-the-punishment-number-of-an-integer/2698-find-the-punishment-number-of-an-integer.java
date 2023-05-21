public class Solution {
    public static boolean check(int idx, String p, int target) {
        if (idx == p.length()) {
            return target == 0;
        }
        if (target < 0) {
            return false;
        }
        for (int i = idx; i < p.length(); ++i) {
            String x = p.substring(idx, i + 1);
            int y = Integer.parseInt(x);
            if (check(i + 1, p, target - y)) {
                return true;
            }
        }
        return false;
    }
    
    public static int punishmentNumber(int n) {
        long ans = 0;
        for (long i = 1; i <= n; ++i) {
            long x = i * i;
            String p = Long.toString(x);
            if (check(0, p, (int) i)) {
                ans += (i * i);
            }
        }
        return (int) ans;
    }
}