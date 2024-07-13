class Solution {

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        Queue<Integer> fq = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            if ((A[i] == 0 && fq.size() % 2 == 0) || (A[i] == 1 && fq.size() % 2 == 1)) {
                res++;
                if (i + K > n) return -1;
                fq.add(i + K - 1);
            }
            if (fq.size() > 0 && fq.peek() == i) {
                fq.remove();
            }
        }

        return res;
    }
}
