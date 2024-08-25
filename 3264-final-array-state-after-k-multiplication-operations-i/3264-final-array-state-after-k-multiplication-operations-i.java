class Solution {

    class Pair {
        int idx;
        int val;

        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public String toString() {
            return "(" + idx + " " + val + ")";
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.val == b.val) ? a.idx - b.idx : a.val - b.val);
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(i, nums[i]));
        }

        while (k-- > 0) {
            Pair p = pq.remove();
            int idx = p.idx;
            int val = p.val;
            pq.add(new Pair(idx, val * multiplier));
        }

        while (pq.size() > 0) {
            Pair p = pq.remove();
            int idx = p.idx;
            int val = p.val;
            nums[idx] = val;
        }

        return nums;
    }
}
