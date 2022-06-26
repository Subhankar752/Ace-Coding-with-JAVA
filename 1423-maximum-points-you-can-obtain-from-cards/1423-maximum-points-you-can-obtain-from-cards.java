class Solution {
    public int maxScore(int[] a, int k) {
        int n = a.length;
        int min = n - k;
        int sum = 0;
        int minSum = 0;
        for(int i = 0 ; i < min ; i++){
            sum += a[i];
        }
        minSum = sum;
        for(int i = 0 ; i < k ; i++){
            sum -= a[i];
            sum += a[i + min];
            minSum = Math.min(minSum , sum);
        }
        int total = 0;
        for(int i : a)
            total += i;
        total -= minSum;
        return total;
    }
}