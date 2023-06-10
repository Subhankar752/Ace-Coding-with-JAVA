// class Solution {
//     public int maxValue(int n, int index, int maxSum) {
//         int l = 0;
//         int r = maxSum;
//         int ans = 0;

//         while(l <= r){
//             int mid = l + (r - l) / 2;

//             if(check(mid , index , maxSum, n)){
//                 ans = mid;
//                 l = mid + 1;
//             }
//             else{
//                 r = mid - 1;
//             }
//         }

//         return ans;
//     }

//     public boolean check(int mid , int index , int maxSum, int n){
//         int val = mid;
//         int rem = mid - index;

//         long sum = (mid * (mid + 1)) / 2;

//         //right
//         int nos1 = n - (index + 1);
//         int x = mid - nos1;a
//         long sr = 0;
//         if(x > 0)
//             sr = ((x - 1) * x) / 2;

//         //left
//         int nos2 = index;
//         int y = mid - nos2;
//         long sl = 0;
//         if(y > 0)
//             sl = ((y - 1) * y) / 2;

//         long res = sum + sum - sr - sl - mid;

//         return res <= maxSum;

//     }
// }
class Solution {

    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0, right = maxSum, mid;
        while (left < right) {
            mid = (left + right + 1) / 2;
            if (test(n, index, mid) <= maxSum) left = mid; else right = mid - 1;
        }
        return left + 1;
    }

    private long test(int n, int index, int a) {
        int b = Math.max(a - index, 0);
        long res = (long) (a + b) * (a - b + 1) / 2;
        b = Math.max(a - ((n - 1) - index), 0);
        res += (long) (a + b) * (a - b + 1) / 2;
        return res - a;
    }
}
