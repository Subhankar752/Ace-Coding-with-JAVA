public class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, mid, k, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] bloomDay, int mid, int k, int booket) {
        int bouquets = 0, flowersCollected = 0;
        
        for (int value : bloomDay) {
            if (value <= mid) {
                flowersCollected++;
            } else {
                flowersCollected = 0;
            }
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }

        return bouquets >= booket;
    }
}
