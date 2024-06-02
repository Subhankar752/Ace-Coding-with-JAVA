class Solution {

    class SegmentTree {
        int[] tree;
        int n;

        // Constructor
        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        // Function to build the Segment Tree
        public void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] & tree[2 * node + 2];
            }
        }

        // Overloading query function to be used recursively
        public int query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        // query function to get bitwise AND of the range
        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return Integer.MAX_VALUE; // Return maximum value if
                // outside the range
            }
            if (l <= start && end <= r) {
                return tree[node]; // Return node value if range
                // is completely within the
                // query range
            }
            int mid = (start + end) / 2;
            int p1 = query(2 * node + 1, start, mid, l, r);
            int p2 = query(2 * node + 2, mid + 1, end, l, r);
            return p1 & p2; // Return bitwise AND of children nodes
        }
    }

    public int minimumDifference(int[] arr, int k) {
        int n = arr.length;
        SegmentTree st = new SegmentTree(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i - 1, r = n - 1, mid;
            // Binary search implementation
            while (r - l > 1) {
                mid = (l + r) / 2;
                if (st.query(i, mid) >= k) l = mid; else r = mid;
            }
            if (l != i - 1) ans = Math.min(ans, Math.abs(st.query(i, l) - k));
            ans = Math.min(ans, Math.abs(k - st.query(i, r)));
        }
        return ans;
    }
}
