class Solution {

    public long maximumHappinessSum(int[] a, int k) {
        long ans = 0;

        Arrays.sort(a);
        int n = a.length;
        int dec = 0;
        int j = n - 1;
        
        for (int i = 0; i < k; i++) {
            ans += Math.max(0, a[j] - dec);
            dec++;
            j--;
        }

        return ans;
    }
}
