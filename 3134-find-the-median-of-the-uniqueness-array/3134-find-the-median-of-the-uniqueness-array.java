class Solution {

    public int medianOfUniquenessArray(int[] A) {
        int n = A.length, left = 1, right = n;
        long total = (long) n * (n + 1) / 2;
        while (left < right) {
            int k = (left + right) / 2;
            if (atmost(A, k) * 2 >= total) {
                right = k;
            } else {
                left = k + 1;
            }
        }
        return left;
    }

    private long atmost(int[] A, int k) {
        long res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0;
        for (int j = 0; j < A.length; j++) {
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (count.size() > k) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) {
                    count.remove(A[i]);
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
