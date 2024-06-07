class Solution {
    List<List<Integer>> adj;
    long res;
    int components;
    int val;

    public int componentValue(int[] nums, int[][] edges) {
        int sum = 0;
        int ans = 0;
        for (int i : nums) {
            sum += i;
        }

        adj = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0) {
                components = i;
                val = sum / i;
                solve(0, -1, nums);
                if (components == 0) {
                    ans = Math.max(ans, i - 1);
                }
            }
        }

        return ans;
    }

    public int solve(int node, int parent, int[] nums) {
        int sum = nums[node];
        for (int ele : adj.get(node)) {
            if (ele != parent) {
                sum += solve(ele, node, nums);
            }
        }

        if (sum == val) {
            components--;
            sum = 0;
        }

        return sum;
    }
}
