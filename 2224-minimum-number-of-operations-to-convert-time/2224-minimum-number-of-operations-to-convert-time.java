class Solution {
    public int convertTime(String current, String correct) {
        int min1 = Integer.parseInt(current.substring(0 , 2)) * 60 +          Integer.parseInt(current.substring(3));
        int min2 = Integer.parseInt(correct.substring(0 , 2)) * 60 + Integer.parseInt(correct.substring(3));
        int res = min2 - min1;
        int ans = 0;
        ans += res/60;
        res = res%60;
        ans += res/15;
        res = res%15;
        ans += res/5;
        res = res%5;
        ans += res;
        return ans;
    }
}