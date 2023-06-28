class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;
        int left = 0, right = 0;
        int count = 0, sum = 0;
        for (; right < n; right++) {
            sum += A[right];
            while (left < right && sum > S) {
                sum -= A[left++];
            }
            if (sum == S) count++;
            for (int i = left; sum == S && i < right && A[i] == 0; i++)
                count++;
        }

        return count;
    }
}