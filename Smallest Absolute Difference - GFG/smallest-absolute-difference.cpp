// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

int kthDiff(int a[], int n, int k);

// Driver code
int main() {
    int t, i;
    int k;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        cin >> k;

        cout << kthDiff(a, n, k) << endl;
    }
    return 0;
}
// } Driver Code Ends

int countPairs(int *a, int n, int mid) {
    int res = 0;
    for (int i = 0; i < n; ++i)

        // Upper bound returns pointer to position
        // of next higher number than a[i]+mid in
        // a[i..n-1]. We subtract (a + i + 1) from
        // this position to count
        res += upper_bound(a + i, a + n, a[i] + mid) - (a + i + 1);
    return res;
}
int kthDiff(int a[], int n, int k)
{
    // Sort array
    sort(a, a + n);

    // Minimum absolute difference
    int low = a[1] - a[0];
    for (int i = 1; i <= n - 2; ++i) low = min(low, a[i + 1] - a[i]);

    // Maximum absolute difference
    int high = a[n - 1] - a[0];

    // Do binary search for k-th absolute difference
    while (low < high) {
        int mid = (low + high) >> 1;
        if (countPairs(a, n, mid) < k)
            low = mid + 1;
        else
            high = mid;
    }

    return low;
}