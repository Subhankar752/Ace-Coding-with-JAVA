class Solution {

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int minimumPushes(String word) {
        int ans = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            list.add(new ArrayList<>());
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Pair> freq = new ArrayList();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            freq.add(new Pair(m.getKey(), m.getValue()));
        }

        Collections.sort(freq, (aa, bb) -> bb.b - aa.b);

        int idx = 0;
        for (Pair p : freq) {
            list.get(idx).add(p.a);

            ans += (list.get(idx).size() * p.b);
            idx++;

            if (idx > 7) {
                idx = 0;
            }
        }

        return ans;
    }
}
