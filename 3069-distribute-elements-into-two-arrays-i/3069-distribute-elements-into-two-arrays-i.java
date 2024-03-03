class Solution {

    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        int n = nums.length;
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < n; i++) {
            int val1 = arr1.get(arr1.size() - 1);
            int val2 = arr2.get(arr2.size() - 1);

            if (val1 > val2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        int[] ans = new int[n];
        int k = 0;
        for (int i : arr1) {
            ans[k++] = i;
        }
        for (int i : arr2) {
            ans[k++] = i;
        }

        return ans;
    }
}
