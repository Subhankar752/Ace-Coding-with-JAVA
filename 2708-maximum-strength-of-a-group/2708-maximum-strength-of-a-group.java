class Solution {

    public long maxStrength(int[] nums) {
        long ans = 1;

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int zeroCount = 0;
        boolean flag = false;

        for (int i : nums) {
            if (i > 0) {
                pos.add(i);
            }
            if (i < 0) {
                neg.add(Math.abs(i));
            }
            if (i == 0) {
                zeroCount++;
            }
        }

        for (int i : pos) {
            flag = true;
            ans = ans * (1l * i);
        }

        if (neg.size() % 2 == 0 && neg.size() > 0) {
            flag = true;
            for (int i : neg) {
                ans = ans * (1l * i);
            }
        } else if (neg.size() % 2 == 1) {
            Collections.sort(neg, Collections.reverseOrder());
            for (int i = 0; i < neg.size() - 1; i++) {
                flag = true;
                ans = ans * (1l * neg.get(i));
            }
        }

        if (pos.size() == 0 && neg.size() == 1 && zeroCount == 0) {
            return - neg.get(0) * 1l;
        }

        if (pos.size() == 0 && neg.size() == 1 && zeroCount > 0) {
            return 0l;
        }

        if (!flag) {
            return 0;
        }

        return ans;
    }
}
