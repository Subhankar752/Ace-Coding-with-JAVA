class Solution {

    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> s = new HashSet<Integer>();

        for (int x : A) s.add(x);

        int res = 2;

        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                int a = A[i], b = A[j], l = 2;
                
                while (s.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                
                res = Math.max(res, l);
            }
        }
        
        return res > 2 ? res : 0;
    }
}
