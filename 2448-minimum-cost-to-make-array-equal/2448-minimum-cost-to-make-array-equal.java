class Solution {

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        int arr[][] = new int[n][2];
        long totalCost = 0L;

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
            totalCost += cost[i];
        }
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        long currSum = 0L;
        int j = -1;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i][1];

            if ((currSum * 1.0) / totalCost >= 0.5) {
                j = i;
                break;
            }
        }

        long mini = 0L;

        for (int a[] : arr) {
            mini += (Math.abs(a[0] - arr[j][0]) * 1L * a[1]);
        }

        return mini;
    }
}
