class Solution {

    public int maxFrequency(int[] a, int k) {
        int n = a.length;

        Arrays.sort(a);

        int ans = 0;
        int left = 0;

        long sum = 0;

        for (int right = 0; right < n; right++) {
            sum += a[right];

            while (a[right] * 1L * (right - left + 1) - sum > k) {
                sum -= a[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
