class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] ch) {
        int ans = -1;
        
        int n = ch.length;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(check(nums, ch, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        if(ans != - 1) {
            return ans + 1;
        }
        
        return ans;
    }
    
    public boolean check(int[] a, int[] ch, int mid) {
        int n = a.length;
        int marked = 0;
        int dec = 0;
        int[] lastIdx = new int[n];
        Arrays.fill(lastIdx, -1);
        
        for(int i = 0 ; i <= mid ; i++) {
            lastIdx[ch[i] - 1] = i;
        }
        
        for(int i = 0 ; i < n ; i++) {
            if(lastIdx[i] == -1) {
                return false;
            }
        }
        
        for(int i = 0 ; i <= mid ; i++) {
            int val = ch[i] - 1;
            // System.out.println(i + " " + val + " " + lastIdx[val] + " " + dec + " " + marked + " " +a[val]);
            if(i == lastIdx[val]) {
                if(a[val] <= dec) {
                    marked++;
                    dec -= a[val];
                }
            }
            else {
                dec++;
            }
            // System.out.println(i + " " + val + " " + lastIdx[val] + " " + dec + " " + marked + " " + a[val]);
            // System.out.println();
        }
        
        return n == marked;
    }
}