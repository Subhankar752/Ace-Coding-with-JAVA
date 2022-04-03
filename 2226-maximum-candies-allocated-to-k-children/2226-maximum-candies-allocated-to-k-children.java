class Solution {
    public int maximumCandies(int[] A, long k) {
        int left = 0, right = 10_000_000;
        while (left < right) {
            long sum = 0;
            int mid = (left + right + 1) / 2;
            for (int a : A) {
                sum += a / mid;
            }
            if (k > sum)
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }
}