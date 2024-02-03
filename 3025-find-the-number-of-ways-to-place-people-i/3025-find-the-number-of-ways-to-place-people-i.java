class Solution {
    public int numberOfPairs(int[][] a) {
        int n = a.length;
        int ans = 0;
        
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i == j) {
                    continue;
                }
                
                if (canForm(a[i], a[j])) {
                    if (!findPoints(a[i], a[j], a, i, j)) {
                        ans++;
                    }
                }
                    
            }
        }
        
        return ans;
    }
    
    public boolean findPoints(int[] a1, int[] b1, int[][] arr, int i, int j) {
        int n = arr.length;
        
        int x = a1[0];
        int y = a1[1];
        
        int a = b1[0];
        int b = b1[1];
        
        for (int k = 0 ; k < n ; k++) {
            if (k == i || k == j) {
                continue;
            }
            
            int p = arr[k][0];
            int q = arr[k][1];
            
            if ((p >= x && p <= a) && (q <= y && q >= b)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean canForm(int[] a1, int[] b1) {
        int x = a1[0];
        int y = a1[1];
        
        int a = b1[0];
        int b = b1[1];
        
        if (x <= a && y >= b) {
            return true;
        }
        
        return false;
    }
}