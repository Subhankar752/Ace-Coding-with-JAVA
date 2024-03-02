class Solution {

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int len = pattern.length + 1;
        int count = 0;

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            q.addLast(nums[i]);
        }
        if (check(q, pattern)) {
            count++;
        }
        
        int n = nums.length;
        for (int i = len; i < n; i++) {
            q.removeFirst();
            q.addLast(nums[i]);
            
            if (check(q, pattern)) {
                count++;
            }
        }

        return count;
    }

    public boolean check(Deque<Integer> q, int[] a) {
        Deque<Integer> temp = new ArrayDeque<>(q);

        for (int i : a) {
            int first = temp.removeFirst();
            int second = temp.getFirst();
            if (i == 1) {
                if (second <= first) {
                    return false;
                }
            }
            if (i == 0) {
                if (first != second) {
                    return false;
                }
            }
            if (i == -1) {
                if (first <= second) {
                    return false;
                }
            }
        }

        return true;
    }
}
