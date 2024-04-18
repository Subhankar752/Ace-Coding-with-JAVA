class Solution {

    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        int[] leftGreater = nextGreaterElement(nums);
        long ans = n;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                long val = find(list, leftGreater[i]);
                ans += val;

                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        return ans;
    }

    public int find(List<Integer> list, int idx) {
        int ans = 0;

        int s = 0;
        int e = list.size() - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (list.get(mid) == idx) {
                ans = list.size() - mid;
                s = mid + 1;
            } else if (list.get(mid) < idx) {
                s = mid + 1;
            } else {
                ans = list.size() - mid;
                e = mid - 1;
            }
        }

        return ans;
    }

    public int[] nextGreaterElement(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] >= st.peek().val) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek().idx;
            }

            st.push(new Pair(nums[i], i));
        }

        return ans;
    }
}
