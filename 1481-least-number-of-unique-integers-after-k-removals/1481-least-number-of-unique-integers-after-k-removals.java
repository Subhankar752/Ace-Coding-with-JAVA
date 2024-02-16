class Solution {

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((aa, bb) -> aa.b - bb.b);
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            int val = m.getValue();
            pq.add(new Pair(key, val));
        }
       
        for (int i = 0; i < k; i++) {
            Pair p = pq.remove();
            int key = p.a;
            int val = p.b;
            if (val - 1 > 0) {
                pq.add(new Pair(key, val - 1));
            }
        }

        int ans = pq.size();
        return ans;
    }
}
