class Solution {

    public int findUnsortedSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }

        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            if (nums[i] != a[i]) list.add(i);
        }

        if (list.size() == 0) return 0;

        int l = list.get(0);
        int r = list.get(list.size() - 1);

        return (r - l + 1);
    }
}
