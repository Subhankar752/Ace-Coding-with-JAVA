class Solution {

    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i : nums) {
            if (i > 0) {
                pos.add(i);
            } else {
                neg.add(i);
            }
        }

        int p = 0;
        int n = 0;
        int i = 0;
        boolean flag = true;

        while (i < nums.length) {
            if (flag) {
                nums[i] = pos.get(p);
                p++;
            } else {
                nums[i] = neg.get(n);
                n++;
            }

            flag = !flag;
            i++;
        }

        return nums;
    }
}
