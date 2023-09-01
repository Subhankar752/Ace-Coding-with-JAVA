class Solution {

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] p = new Pair[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(capital[i], profits[i]);
        }

        Arrays.sort(p, (aa, bb) -> aa.a - bb.a);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        int kk = 0;
        while (i < k) {
            while (kk < n && p[kk].a <= w) {
                pq.add(p[kk].b);
                kk++;
            }
            
            if(pq.isEmpty())
                break;

            w += pq.remove();
            i++;
        }

        return w;
    }
}
