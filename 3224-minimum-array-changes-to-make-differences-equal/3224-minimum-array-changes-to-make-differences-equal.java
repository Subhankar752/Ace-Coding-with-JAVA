class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> v = new ArrayList<>();

        for (int i = 0; i < n / 2; ++i) {
            int diff = Math.abs(nums[i] - nums[n - i - 1]);
            m.put(diff, m.getOrDefault(diff, 0) + 1);
            
            int val = Math.max(Math.max(nums[i], nums[n - i - 1]) , k - Math.min(nums[i], nums[n - i - 1]));
            v.add(val);
        }

        Collections.sort(v); 
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0 ; i <= k ; i++) {
            int zero = m.get(i) == null ? 0 : m.get(i);
            int one = find(v, i);
            int two = n / 2 - zero + one;
            ans = Math.min(ans, two);
        }

        return ans;
    }
    
    private int find(List<Integer> arr, int val) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int curr = arr.get(mid);

            if (curr < val) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }

        return ans + 1;
    }
}