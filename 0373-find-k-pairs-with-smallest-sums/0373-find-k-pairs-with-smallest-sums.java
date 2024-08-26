class Solution {
    
    /*
            2   4   6
        +------------
        1 |  3   5   7
        7 |  9  11  13
        11 | 13  15  17
    */

    class Pair {
        int idx1;
        int idx2;
        int val;

        Pair(int idx1, int idx2, int val) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.val = val;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        List<List<Integer>> ans = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        
        pq.add(new Pair(i, j, nums1[i] + nums2[j]));
        while (pq.size() > 0 && k-- > 0) {
            Pair p = pq.remove();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[p.idx1]);
            list.add(nums2[p.idx2]);
            ans.add(list);
            
            //next column
            if (p.idx1 + 1 < n1) {
                pq.add(new Pair(p.idx1 + 1, p.idx2, nums1[p.idx1 + 1] + nums2[p.idx2]));
            }
            //next row
            if (p.idx1 == 0 && p.idx2 + 1 < n2) {
                pq.add(new Pair(p.idx1, p.idx2 + 1, nums1[p.idx1] + nums2[p.idx2 + 1]));
            }
        }

        return ans;
    }
}
