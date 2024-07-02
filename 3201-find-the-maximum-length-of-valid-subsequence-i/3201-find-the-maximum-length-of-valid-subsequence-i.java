class Solution {

    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;
        int evenodd = 0;
        int oddeven = 0;

        for (int i : nums) {
            if (i % 2 == 0) {
                even++;
            }
        }

        for (int i : nums) {
            if (i % 2 == 1) {
                odd++;
            }
        }

        boolean flag = true;
        for (int i : nums) {
            if (i % 2 == 0 && flag) {
                evenodd++;
                flag = !flag;
            } else if (i % 2 == 1 && !flag) {
                evenodd++;
                flag = !flag;
            }
        }

        flag = true;
        for (int i : nums) {
            if (i % 2 == 1 && flag) {
                oddeven++;
                flag = !flag;
            } else if (i % 2 == 0 && !flag) {
                oddeven++;
                flag = !flag;
            }
        }

        return Math.max(Math.max(even, odd), Math.max(oddeven, evenodd));
    }
}
